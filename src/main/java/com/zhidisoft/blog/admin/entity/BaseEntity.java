package com.zhidisoft.blog.admin.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
