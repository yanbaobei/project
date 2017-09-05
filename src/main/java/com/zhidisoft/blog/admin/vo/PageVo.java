package com.zhidisoft.blog.admin.vo;

import java.util.List;

/**
 * 和前台设置
 * 
 * @author REN
 *
 */
@SuppressWarnings("rawtypes")
public class PageVo {
	private Integer pageNum;
	private Integer pageSize;

	private Integer totalCount;//
	private Integer totalPage;

	private List list;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getTotalPage() {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		} else {
			return (totalCount / pageSize) + 1;
		}
		// return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
