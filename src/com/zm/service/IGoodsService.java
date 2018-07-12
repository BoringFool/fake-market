package com.zm.service;

import java.util.List;

import com.zm.model.Goods;

public interface IGoodsService {

	public String save(Goods g);

	public Goods getById(long l);

	public void update(Goods g);

	public void delete(long l);

	public List<Goods> limitq(int num,int length);

	public long count();
	public Goods getByName(String name);


}
