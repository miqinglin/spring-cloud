package com.mql.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mql.springcloud.facade.DeptAddReq;
import com.mql.springcloud.facade.DeptResponse;
import com.mql.springcloud.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addDept(@RequestBody DeptAddReq req){
		
		return deptService.addDept(req);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public DeptResponse get(@PathVariable("id") Long id){
		
		return deptService.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<DeptResponse> list(){
		
		return deptService.list();
	}
	
	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery(){
		List<String> services = client.getServices();
		System.out.println("****发现的服务******" + services);
		List<ServiceInstance> srvList = client.getInstances("CLOUD-PROVIDE");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
