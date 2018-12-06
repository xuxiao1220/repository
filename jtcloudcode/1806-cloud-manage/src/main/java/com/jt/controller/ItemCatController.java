package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.service.HttpClientService;

@Controller
public class ItemCatController {
	
	@RequestMapping("page/{pageName}")
	public String goPage(@PathVariable String pageName){
		return pageName;
	}
	
	//根据网关的接口,想办法访问网关的地址,传递参数,获取数据
	@Autowired
	private HttpClientService client;
	@RequestMapping("item/cat/list")
	@ResponseBody
	public String queryItemList
	(@RequestParam(defaultValue="0") String id) throws Exception{
		//localhost:8100/itemcat/item/cat/list
		String url="http://localhost:8100/itemcat/item/cat/list?id="+id;
		String itemCatJson=client.doGet(url);
		return itemCatJson;
	}
}
