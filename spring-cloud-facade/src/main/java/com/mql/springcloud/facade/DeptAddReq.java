package com.mql.springcloud.facade;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true)
public class DeptAddReq {
	@NotBlank
	private String deptName;
	
	private String dbSource;
	
}
