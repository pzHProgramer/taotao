package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;
import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;

@Service
public class ItemCatService extends BaseService<ItemCat>{

	@Autowired
	private ItemCatMapper itemCatMapper;

	/**
	 * 根据id查询商品类目
	 */
	public ItemCat queryItemCatById(Long id){
		return this.itemCatMapper.selectByPrimaryKey(id);
	}
	
	
	
	@Override
	public Mapper<ItemCat> getMapper() {
		return this.itemCatMapper;
	}

}
