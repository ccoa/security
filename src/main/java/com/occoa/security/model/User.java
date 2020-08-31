package com.occoa.security.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("security.tb_user")
@Data
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
	@Column("user_id")
	private Long id;
	
	@Column("username")
	private String username;

	@Column("password")
	private String password;
	
	@Column("photo")
	private String photo;
	
	@Column("expiration_password")
	private Date expirationPassword;
	
	@Column("phone_number")
	private String phoneNumber;

	@Column("register_date")
	private Date registerDateTime;
	
	@Column("update_date")
	private Date modificationDateTime;

	@Column("type")
	private String type;

	@Column("status")
	private String status;

}
