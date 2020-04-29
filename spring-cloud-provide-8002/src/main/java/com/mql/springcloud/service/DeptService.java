package com.mql.springcloud.service;

import java.util.List;

import com.mql.springcloud.facade.DeptAddReq;
import com.mql.springcloud.facade.DeptResponse;

public interface DeptService {
	
	public boolean addDept(DeptAddReq req);
	
	public DeptResponse get(Long id);
	
	public List<DeptResponse> list();
	
}
