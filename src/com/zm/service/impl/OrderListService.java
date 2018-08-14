package com.zm.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderDao;
import com.zm.dao.IOrderListDao;
import com.zm.dao.IUserDao;
import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.model.User;
import com.zm.service.IOrderListService;

@Service("orderlistservice")
@Transactional
public class OrderListService implements IOrderListService {

	@Resource
	private IOrderListDao orderlistdao;

	@Resource
	private IUserDao userdao;

	@Resource
	private IOrderDao orderdao;

	public IOrderListDao getOrderlistdao() {
		return orderlistdao;
	}

	public void setOrderlistdao(IOrderListDao orderlistdao) {
		this.orderlistdao = orderlistdao;
	}

	@Override
	public void save(OrderList o_l) {
		orderlistdao.add(o_l);

	}

	@Override
	public void delete(long l) {
		orderlistdao.delet(l);

	}

	@Override
	public OrderList getById(long l) {
		return orderlistdao.getById(l);

	}

	public List<OrderList> getByIds(Long[] ids) {
		return orderlistdao.getByIds(ids);

	}

	@Override
	public void update(OrderList ol) {
		orderlistdao.update(ol);

	}

	@Override
	public List<OrderList> byState(boolean b) {
		return orderlistdao.getByState(b);
	}

	@Override
	public List<OrderList> getByGoodsId(Long id) {

		return orderlistdao.byGoodsId(id);
	}

	@Override
	// 结算方法，能重复购买，但是不能改变购买数量，因为我没有做(没有返回库存不足的goods，所以只能所有单重新下...)
	public boolean saveContainOrder(Long[] ids, String username) {
		boolean buyOk = true;
		User u = userdao.getByName(username);
		Order order = new Order();
		order.setUsers(u);
		orderdao.add(order);
		List<OrderList> ol = orderlistdao.getByIds(ids);
		Iterator<OrderList> it = ol.iterator();
		// 遍历确定库存数量足够ps:不能用while来遍历，会导致遍历一遍后，下面的while直接判定已经遍历过了
		for (OrderList o : ol) {
			long stockNumber = o.getGoods().getNumber();
			int buyNumber = o.getNumber();
			if (stockNumber < buyNumber) {
				buyOk = false;
				break;
			}
		}

		// 判断是否进行数量减少完成结算
		if (buyOk) {
			while (it.hasNext()) {
				OrderList oList = it.next();
				long stockNumber = oList.getGoods().getNumber();
				int buyNumber = oList.getNumber();
				oList.getGoods().setNumber(stockNumber - buyNumber);
				Calendar c = Calendar.getInstance();
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String payData = s.format(c.getTime());
				// 再次购买相同产品，不做判断，数据库会直接覆盖oId，order会增加，但是orderList不会生成新的记录
				if (oList.getOrder() == null) {
					oList.setPayState(true);
					oList.setPayData(payData);
					oList.setOrder(order);
					orderlistdao.update(oList);
				} else {
					OrderList orderlN = new OrderList();
					orderlN.setPayState(true);
					orderlN.setPayData(payData);
					orderlN.setOrder(order);
					orderlN.setNumber(oList.getNumber());
					orderlN.setGoods(oList.getGoods());
					orderlistdao.add(orderlN);
				}

			}
			return true;
		} else {
			return false;
		}
	}

	public long count() {
		return orderlistdao.countCart();
	}
}
