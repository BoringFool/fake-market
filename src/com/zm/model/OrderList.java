package com.zm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "goods_id")
	private Goods goods;
	@ManyToOne
	@JoinColumn(name = "oid")
	@JsonIgnore
	private Order order;
	private boolean payState;
	private int number;
	private String payData;

	public String getPayData() {
		return payData;
	}

	public void setPayData(String payData) {
		this.payData = payData;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isPayState() {
		return payState;
	}

	public void setPayState(boolean payState) {
		this.payState = payState;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * 存储购物id和number
	 * 
	 * @ElementCollection(fetch=FetchType.LAZY)
	 * 
	 * @CollectionTable(name="NUMBER") //指定集合生成的表
	 * 
	 * @MapKeyColumn(name="GOODS_ID") //指定key生成的列 private Map<Long, Integer>
	 * orderNumber;
	 */
}
