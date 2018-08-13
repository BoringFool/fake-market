package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IStockDao;
import com.zm.model.Stock;
import com.zm.service.IStockService;
@Service("stockservice")
@Transactional
public class StockService implements IStockService {

	@Resource
	IStockDao stockdao;
	@Override
	public void save(Stock s) {
		
		stockdao.add(s);
	}

	@Override
	public void delete(long id) {
		
		stockdao.delet(id);
	}

	@Override
	public void update(Stock s) {
		
		stockdao.update(s);

	}

	@Override
	public Stock getById(long id) {
		
		return stockdao.getById(id);
	}

}
