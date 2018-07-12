package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_good")
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false)
	private long id;
	//用户名字直接代替店铺名
	private String store;
	private String brand;
	private String name;
	private String imageurl;
	private Double price;
	private String color;
	private String size;
	private Long number;
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(mappedBy="goods",fetch=FetchType.EAGER)//������ʾ��Course��һ��������ά��
	private Set<OrderList> orderlists;

	public Set<OrderList> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(Set<OrderList> orderlists) {
		this.orderlists = orderlists;
	}

	public Goods() {
		orderlists = new HashSet<OrderList>();
	}

	public void addTeacher(OrderList orderlist) {
		orderlists.add(orderlist);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

}
