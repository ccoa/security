package com.occoa.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("tb_permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_INACTIVE = "I";
	
	@Id
	@Column("perm_id")
	private Long id;
	
	@Column("perm_name")
	private String name;
	
	@Column("perm_code")
	private String code;
	
	@Column("perm_statu")
	private String status;

}
