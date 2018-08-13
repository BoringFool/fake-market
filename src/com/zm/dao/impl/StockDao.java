package com.zm.dao.impl;

import org.springframework.stereotype.Component;

import com.zm.dao.IStockDao;
import com.zm.model.Stock;

@Component("stockdao")
public class StockDao extends BaseDao<Stock> implements IStockDao {

}
