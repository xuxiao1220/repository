package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.service.HiService;

@Controller
public class HiController {
	@Autowired
	private HiService hiService;
	
	@RequestMapping("hi")
	@ResponseBody
	public String sayHi(String name){
		//访问一个叫hi的逻辑,但是ribbon并不能独立完成hi的逻辑
		//,需要后台其他服务的支持
		String response=hiService.sayHi(name);
		return "RIBBON+HYSTRIX:"+response;
		//RIBBON:name/hello cloud, i am from 809*
	}
}
