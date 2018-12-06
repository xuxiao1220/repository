package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigController {
	
	@Value("${spring.redis.nodes:null}")
	private String nodes;
	@Value("${spring.datasource.url}")
	private String shujuku;
	
	@RequestMapping("config")
	@ResponseBody
	public String getConfig(){
		return nodes+":"+shujuku;
	}
}
