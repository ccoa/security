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

	@Column("name")
	private String name;

	@Column("description")
	private String description;

	@Column("register_date")
	private Date registerDateTime;

	@Column("status")
	private String status;

}
