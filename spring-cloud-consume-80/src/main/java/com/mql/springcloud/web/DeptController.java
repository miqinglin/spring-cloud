package com.mql.springcloud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.mql.springcloud.facade.DeptAddReq;
import com.mql.springcloud.facade.DeptResponse;

@RestController
@RequestMapping(value = "/consumer")
public class DeptController {
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://CLOUD-PROVIDE";
	
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping(value = "/dept/add", method={RequestMethod.GET, RequestMethod.POST})
	public boolean add(@Validated DeptAddReq dept){
		DeptAddReq req = dept;
//		Map<String, String> data = new HashMap<String, String>();
//		data.put("deptName", "deptName");
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", req, Boolean.class);
	}

	@RequestMapping(value = "/dept/get/{id}")
	public JSONObject get(@PathVariable("id") Long id)
	{
		JSONObject result = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, JSONObject.class);
		System.out.println(result);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dept/list")
	public List<DeptResponse> list()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}
	
	@RequestMapping(value = "/dept/discovery")
	public Object discovery(){
		
		return  restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}
