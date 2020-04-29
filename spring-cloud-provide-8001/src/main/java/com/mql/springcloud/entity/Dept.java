package com.mql.springcloud.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept {
	
	private Long id;

	private String deptName;

	private String dbSource;

	private Date createTime;

	public Dept(String deptName, String dbSource) {
		super();
		this.deptName = deptName;
		this.dbSource = dbSource;
	}
	
}
