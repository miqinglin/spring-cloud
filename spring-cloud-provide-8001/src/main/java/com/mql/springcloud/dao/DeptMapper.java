package com.mql.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mql.springcloud.entity.Dept;

@Mapper
public interface DeptMapper {
	
	public boolean addDept(Dept dept);

	public Dept queryById(Long id);

	public List<Dept> queryAll();
}
