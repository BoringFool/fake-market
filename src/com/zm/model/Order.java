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
	private String name;
	private int age;
	@OneToOne
	@JoinColumn(name="uid")
	private User users;
	private Integer num;
	@OneToMany(mappedBy="order",cascade=CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<OrderList> order_num;

	public User getUsers() {
		return users;
	}

	public void setUser(User users) {
		this.users = users;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}