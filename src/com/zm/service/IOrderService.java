package com.zm.service;

import com.zm.model.Order;

public interface IOrderService {

	public void save(Order o);

	public Order getById(long l);

	public void upadte(Order o);

	public void delete(long id);

}
