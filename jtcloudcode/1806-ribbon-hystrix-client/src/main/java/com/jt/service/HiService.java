package com.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HiService {
	@Autowired
	private RestTemplate template;
	@HystrixCommand(fallbackMethod="errorHi")
	public String sayHi(String name){
		//负载均衡的访问服务 service-hi
		String response = template.getForObject("http://service-hi/hi", String.class);
		//template.getForEntity("http://service-hi/hi", String.class).getBody();
		//template.postForEntity(url, request, responseType)
		response=name+"/"+response;
		
		return response;
	}
	@HystrixCommand(fallbackMethod="sayHi")
	public String errorHi(String name){
		//负载均衡的访问服务 service-hi
		String response = template.getForObject("http://service-hi/hi", String.class);
		//template.getForEntity("http://service-hi/hi", String.class).getBody();
		//template.postForEntity(url, request, responseType)
		response=name+"/"+response;
		return response;
	}
}
