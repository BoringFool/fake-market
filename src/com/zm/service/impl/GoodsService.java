package com.zm.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IGoodsDao;
import com.zm.dao.IUserDao;
import com.zm.model.Goods;
import com.zm.model.Roles;
import com.zm.model.Stock;
import com.zm.model.User;
import com.zm.service.IGoodsService;

@Service("goodsservice")
@Transactional
public class GoodsService implements IGoodsService {

	@Resource
	private IGoodsDao goodsdao;
	@Resource
	private IUserDao userdao;

	public IGoodsDao getGoodsdao() {
		return goodsdao;
	}

	public void setGoodsdao(IGoodsDao goodsdao) {
		this.goodsdao = goodsdao;
	}

	@Override
	public String save(String userName, Goods g) {
		User u = userdao.getByName(userName);
		boolean ok = false;
		Set<Roles> setR = u.getRoles();
		Iterator<Roles> it = setR.iterator();
		while (it.hasNext()) {
			Roles r = it.next();
			if (r.getName().equals("商人")) {
				System.out.println("*****************************************");
				ok = true;
				break;
			} else {

				System.out.println("*****************************************2" + r.getName() + ok);
			}
		}
		if (ok) {
			if (u.getStock() == null) {
				Stock s = new Stock();
				u.setStock(s);
				userdao.update(u);
			}
			Goods newG = goodsdao.getByName(g.getName());
			if (newG == null) {
				g.setStock(u.getStock());
				goodsdao.add(g);
				return "保存成功！";
			} else {
				return "商品已经存在！";
			}
		} else {
			return "仅商人可以添加商品！";
		}

	}

	@Override
	public Goods getById(long l) {
		return goodsdao.getById(l);

	}

	@Override
	public void update(Goods g) {
		goodsdao.update(g);

	}

	@Override
	public void delete(long l) {
		goodsdao.delet(l);

	}

	@Override
	public List<Goods> limitq(int num, int length) {
		return goodsdao.limitquery(num, length);
	}

	@Override
	public long count() {
		return goodsdao.countNum();
	}

	public Goods getByName(String name) {
		return goodsdao.getByName(name);
	}

	public List<Goods> likeAndLimit(String what, int start, int number) {

		return goodsdao.likeAndLimit(what, start, number);
	}
}
