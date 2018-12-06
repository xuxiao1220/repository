package com.jt.manage.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jt.common.util.ObjectUtil;
import com.jt.manage.pojo.ItemCatResult;
import com.jt.manage.service.ItemCatService;

@Controller
public class WebItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List queryItemList(@RequestParam(defaultValue="0")Long id){
		//传入的id值,有可能是第一次查询,初始化状态,id为空
	
		List itemCatList=itemCatService.queryItemList(id);
		return itemCatList;
	}
	//前台三级分类树封装
	@RequestMapping("web/itemcat/all")
	@ResponseBody
	public String queryAllItemCat(String callback) throws Exception{
		//调用service先封装数据,返回对象,controller将字符串拼接
		ItemCatResult result=itemCatService.queryAllItemCat();
		//转化成字符串
		return callback+"("+ObjectUtil.mapper.writeValueAsString(result)+")";
	}
	
	
}











