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
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_ACTIVE = "A";
	public static final String STATUS_INACTIVE = "I";
	public static final String TYPE_FREE = "F";
	public static final String TYPE_STANDAR = "S";
	public static final String TYPE_PREMIUM = "P";
	public static final String GENDER_FEMALE = "F";
	public static final String GENDER_MALE = "M";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_uname")
	private String username;

	@Column(name = "user_passw")
	private String password;
	
	@Column(name = "user_photo")
	private String photo;
	
	@Column(name = "user_expir")
	private Date expirationPassword;

	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_phone")
	private String phoneNumber;

	@Column(name = "user_regis")
	private Date registerDateTime;
	
	@Column(name = "user_modif")
	private Date modificationDateTime;

	@Column(name = "user_utype")
	private String type;

	@Column(name = "user_statu")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getExpirationPassword() {
		return expirationPassword;
	}

	public void setExpirationPassword(Date expirationPassword) {
		this.expirationPassword = expirationPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModificationDateTime() {
		return modificationDateTime;
	}

	public void setModificationDateTime(Date modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}
	
	

}
