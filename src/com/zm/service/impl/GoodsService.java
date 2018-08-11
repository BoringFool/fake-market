package com.zm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IGoodsDao;
import com.zm.model.Goods;
import com.zm.service.IGoodsService;

@Service("goodsservice")
@Transactional
public class GoodsService implements IGoodsService {

	@Resource
	private IGoodsDao goodsdao;

	public IGoodsDao getGoodsdao() {
		return goodsdao;
	}

	public void setGoodsdao(IGoodsDao goodsdao) {
		this.goodsdao = goodsdao;
	}

	@Override
	public String save(Goods g) {
		Goods newg=goodsdao.getByName(g.getName());
		if(newg==null){
			goodsdao.add(g);
			return "保存成功！";
		}else{
			return "商品已经存在！";
		}
	}

	@Override
	public Goods getById(long l) {
		return goodsdao.getById(l);

	}

	@Override
	public void update(Goods g) {
		goodsdao.update(g);

	}

	@Override
	public void delete(long l) {
		goodsdao.delet(l);

	}

	@Override
	public List<Goods> limitq(int num,int length) {
		return goodsdao.limitquery(num,length);
	}

	@Override
	public long count() {
		return goodsdao.countNum();
	}
	
	
	public Goods getByName(String name) {
		return goodsdao.getByName(name);
	}
	
	public List<Goods> likeAndLimit(String what,int start,int number){
		
		return goodsdao.likeAndLimit(what, start, number);
	}
}
