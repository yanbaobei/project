package com.zhidisoft.blog.admin.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class ArticleVo {

	@NotEmpty(message = "名字不能为空")
	private String title;

	@NotEmpty(message = "类型不能为空")
	private String typeId;

	private String infoTitle;

	@NotEmpty(message = "内容不能为空")
	private String info;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
