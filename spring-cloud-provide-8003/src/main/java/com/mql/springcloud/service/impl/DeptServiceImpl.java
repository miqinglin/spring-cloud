package com.mql.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mql.springcloud.dao.DeptMapper;
import com.mql.springcloud.entity.Dept;
import com.mql.springcloud.facade.DeptAddReq;
import com.mql.springcloud.facade.DeptResponse;
import com.mql.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public boolean addDept(DeptAddReq req) {
		Dept dept = new Dept(req.getDeptName(), req.getDbSource());
		return deptMapper.addDept(dept);
	}

	@Override
	public DeptResponse get(Long id) {
		Dept dept = deptMapper.queryById(id);
		DeptResponse resp = new DeptResponse();
		BeanUtils.copyProperties(dept, resp);
		return resp;
	}

	@Override
	public List<DeptResponse> list() {
		List<Dept> list = deptMapper.queryAll();
		List<DeptResponse> respList = new ArrayList<>();
		for(Dept dept : list){
			DeptResponse resp = new DeptResponse();
			BeanUtils.copyProperties(dept, resp);
			respList.add(resp);
		}
		return respList;
	}

}
