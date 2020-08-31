package com.occoa.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("tb_error")
@Data
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column("erro_id")
	private Long id;
	
	@Column("erro_stack")
	private String stackTrace;
	
	@Column("erro_appli")
	private String applicationName;
	
	@Column("erro_regis")
	private Date registerDateTime;

}
