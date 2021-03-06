package com.zm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1614358555228367804L;
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonIgnore
	private User users;
	@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = { "order" })
	private Set<OrderList> order_num;

	public Order() {
		order_num=new HashSet<OrderList>();
	}
	
	
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