package com.mql.springcloud.web.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {
	@LoadBalanced // Ribbon是一个客户端负载均衡器
	@Bean
	public RestTemplate getRestTemplate(){
		
		return new RestTemplate();
	}
	
}
