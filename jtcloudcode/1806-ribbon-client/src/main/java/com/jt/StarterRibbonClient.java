package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class StarterRibbonClient {
	
	public static void main(String[] args) {
		SpringApplication.run(StarterRibbonClient.class, args);
	}
	@Bean
	@LoadBalanced//实现调用服务负载均衡的逻辑
	public RestTemplate getResource(){
		return new RestTemplate();
	}
}
