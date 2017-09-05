package com.zhidisoft.blog.admin.service;

import com.zhidisoft.blog.admin.entity.Article;
import com.zhidisoft.blog.admin.vo.PageVo;

public interface IArticleService {

	public PageVo findPage(Integer pageNum, Integer pageSize);
	
	
	public int save(Article article);
}
