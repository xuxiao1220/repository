package com.jt.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-hi") //当前接口任何的方法都访问这个服务
public interface HiService {
	@RequestMapping(value="hi",method=RequestMethod.GET)
	String sayHi();

}
