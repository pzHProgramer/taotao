package com.taotao.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.manage.service.ItemService;

@RequestMapping("item")
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
//	@RequestMapping("index")
//	public ModelAndView item(){
//		return new ModelAndView("index");
//	}
	
	
	
	
	
	
	
}
