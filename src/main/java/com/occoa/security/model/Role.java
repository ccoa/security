package com.occoa.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("security.tb_role")
@Data
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_INACTIVE = "I";
	
	@Id
	@Column("role_id")
	private Long id;

	@Column("role_name")
	private String name;

	@Column("role_descr")
	private String description;

	@Column("role_regis")
	private Date registerDateTime;

	@Column("role_statu")
	private String status;

}
