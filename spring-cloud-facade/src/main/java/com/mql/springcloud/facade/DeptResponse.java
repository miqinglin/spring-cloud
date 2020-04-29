package com.mql.springcloud.facade;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DeptResponse {
	private Long id;

	private String deptName;

	private String dbSource;

	private Date createTime;
	
}
