package com.occoa.security.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_error")
public class Error implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "erro_id")
	private Long id;
	
	@Column(name = "erro_stack")
	private String stackTrace;
	
	@Column(name = "erro_appli")
	private String applicationName;
	
	@Column(name = "erro_regis")
	private Date registerDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Date getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

}
