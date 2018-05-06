package com.taotao.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.service.ItemCatService;

/**
 * 商品类目的控制器类
 * @author Henry
 *
 */
@RequestMapping("item/cat")
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 商品新增页 点击 ‘选中类目’ 触发的商品类目加载
	 * 该请求是同步还是异步？ 异步
	 * 参数是什么？ parentId 必须  默认为0
	 * 结果是什么？ List<ItemCat>
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ItemCat>> queryItemCatByParentId(
			@RequestParam(value="id",defaultValue="0") Long parentId){
		
		try {
			ItemCat record = new ItemCat();
			record.setParentId(parentId);
			record.setStatus(1);
			List<ItemCat> list = this.itemCatService.queryListByRecord(record);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
