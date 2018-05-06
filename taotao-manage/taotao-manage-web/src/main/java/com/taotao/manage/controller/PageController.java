package com.taotao.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用页面跳转处理类
 * @author Henry
 *
 */
@RequestMapping("page")
@Controller
public class PageController {

	/**
	 * 通用页面跳转
	 */
	@RequestMapping("{viewName}")
	public String page(@PathVariable("viewName") String viewName){
		//我是程序员B，基于版本1改变了改代码
		System.out.println("程序员A改变");
		return viewName;
	}
	
	
	
	
	@RequestMapping("/xx/{viewName}")
	public String page2(@PathVariable("viewName") String viewName){
		
		System.out.println("程序员A改变");
		return viewName;
	}
	
}
