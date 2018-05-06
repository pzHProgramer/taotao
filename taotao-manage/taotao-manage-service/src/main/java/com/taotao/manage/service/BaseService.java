package com.taotao.manage.service;

import java.util.List;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 抽取的Service层公共类
 * @author Henry
 *
 * @param <T>
 */
public abstract class BaseService<T>{

//	public abstract Mapper<T> getMapper();
	//抽象方法，谁调用谁必须实现该抽象方法
	//该抽象方法要求实现者返回通用 Mapper类型的具体实现对象
	public abstract Mapper<T> getMapper();
	
	/**
	 * 根据主键查询单个对象
	 * @param id
	 * @return
	 */
	public T queryById(Object id){
		return this.getMapper().selectByPrimaryKey(id);
	}
	/**
	 * 根据条件查询多个对象
	 * @param record
	 * @return
	 */
	public List<T> queryListByRecord(T record) {
		return this.getMapper().select(record);
	}
	
	/**
	 * 根据条件查询单个对象
	 * 注意：请保证条件至多只有一个匹配
	 * @param reocrd
	 * @return
	 */
	public T queryOne(T reocrd){
		return this.getMapper().selectOne(reocrd);
	}
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> queryAll(){
		return this.getMapper().select(null);
	}
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<T> queryPageListByWhere(Integer pageNum,Integer pageSize){
		//启用分页助手  基于拦截器的机制 
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = this.queryAll();
		return new PageInfo<T>(list);
		
	}
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	public Boolean save(T record){
		return this.getMapper().insertSelective(record) == 1;
	}
	
	/**
	 * 更新
	 * 注意：主键不能为空
	 * @param record
	 * @return
	 */
	public Boolean updateById(T record){
		return this.getMapper().updateByPrimaryKeySelective(record) == 1;
	}
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 */
	public Boolean deleteById(Object id){
		return this.getMapper().deleteByPrimaryKey(id) == 1;
	}
	/**
	 * 根据集合删除多个对象
	 * @param property
	 * @param ids
	 * @param clazz
	 * @return
	 */
	public Integer deleteByIds(String property,List<Object> ids,@SuppressWarnings("rawtypes") Class clazz){
		Example example = new Example(clazz);
		Criteria criteria = example.createCriteria();
		criteria.andIn(property, ids);
		return this.getMapper().deleteByExample(example);
	}
	
	
	/**
	 * 根据条件删除多个对象
	 * @param record
	 * @return
	 */
	public Integer deleteByWhere(T record){
		return this.getMapper().delete(record);
	}
	
	
	
}
