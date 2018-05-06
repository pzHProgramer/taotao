package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;

@Service
public class ItemService {

	 
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 根据id查询商品
	 */
	public Item queryItemById(Long id){
		return this.itemMapper.selectByPrimaryKey(id);
	}
	
	
	
}
