package com.zm.service;

import com.zm.model.Stock;

public interface IStockService {
	public void save(Stock s);

	public void delete(long id);

	public void update(Stock s);

	public Stock getById(long id);
}
