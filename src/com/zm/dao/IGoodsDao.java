package com.zm.dao;

import java.util.List;

import com.zm.model.Goods;

public interface IGoodsDao extends IBaseDao<Goods> {

	public List<Goods> limitquery(int num, int length);

	public long countNum();

	public Goods getByName(String name);

	public List<Goods> likeAndLimit(String what, int start, int number);
}
