package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_orderlist")
public class OrderList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false)
	private long id;
	@ManyToMany(fetch=FetchType.EAGER)//��ManyToManyָ����Զ�Ĺ�����ϵ
    //��Ϊ��Զ�֮���ͨ��һ���м����ά������ֱ�ӵĹ�ϵ������ͨ�� JoinTable ���ע����������name����
    //ָ�����м������֣�JoinColumns��һ�� @JoinColumn���͵����飬��ʾ�������ⷽ�ڶԷ��е�������ƣ���
    //����Course�������ڶԷ���������ƾ��� rid��inverseJoinColumnsҲ��һ�� @JoinColumn���͵����飬��ʾ��
    //�ǶԷ���������е�������ƣ��Է���Teacher���������ҷ���������ƾ��� tid
    @JoinTable(name="t_good_orderlist", joinColumns={ @JoinColumn(name="oid")}, 
    inverseJoinColumns={ @JoinColumn(name = "gid") })
	private Set<Goods> goods;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderList() {
		goods = new HashSet<Goods>();
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
