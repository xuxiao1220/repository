package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class StarterRHClient {
	
	public static void main(String[] args) {
		SpringApplication.run(StarterRHClient.class, args);
	}
	@Bean
	@LoadBalanced//实现调用服务负载均衡的逻辑
	public RestTemplate getResource(){
		return new RestTemplate();
	}
}
