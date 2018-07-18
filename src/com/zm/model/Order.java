package com.zm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "t_order")
public class Order {

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	@JoinColumn(name = "uid",unique=true)
	private User users;
	@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<OrderList> order_num;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Set<OrderList> getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Set<OrderList> order_num) {
		this.order_num = order_num;
	}

}