package com.occoa.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("tb_menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column("menu_id")
	private Long id;

	@Column("menu_name")
	private String name;

	@Column("menu_descr")
	private String description;

	@Column("menu_level")
	private String level;

	@Column("menu_url")
	private String url;

	@Column("menu_icon")
	private String icon;

	@Column("menu_menid")
	private Long menuId;

	@Column("menu_statu")
	private String status;

}
