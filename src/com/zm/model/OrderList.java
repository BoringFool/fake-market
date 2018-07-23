package com.zm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_orderlist")
public class OrderList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3724185033567410620L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false)
	private long id;
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "t_good_orderlist", joinColumns = { @JoinColumn(name = "oid") }, inverseJoinColumns = {
			@JoinColumn(name = "gid") })
	private Set<Goods> goods;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;
	// 存储购物id和number
  	@ElementCollection(fetch=FetchType.LAZY) 
  	@CollectionTable(name="NUMBER") //指定集合生成的表
 	@MapKeyColumn(name="GOODS_ID") //指定key生成的列
	private Map<Long, Integer> orderNumber;
  	private boolean payState;

	public OrderList() {
		goods = new HashSet<Goods>();
		orderNumber = new HashMap<Long, Integer>();
	}

	public Map<Long, Integer> getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Map<Long, Integer> orderNumber) {
		this.orderNumber = orderNumber;
	}


	public boolean isPayState() {
		return payState;
	}

	public void setPayState(boolean payState) {
		this.payState = payState;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void addGood(Goods good) {
		goods.add(good);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

}
