package com.zhidisoft.blog.admin.entity;

import java.util.Date;

public class Article extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String title;

	private String imgUrl;

	private String infoTitle;

	private String info;

	private Date createTime;

	private String userId;

	private String typeId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", imgUrl=" + imgUrl + ", info=" + info + ", createTime=" + createTime
				+ ", userId=" + userId + ", typeId=" + typeId + "]";
	}

}
