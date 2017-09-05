package com.zhidisoft.blog.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhidisoft.blog.admin.dao.ArticleMapper;
import com.zhidisoft.blog.admin.entity.Article;
import com.zhidisoft.blog.admin.service.IArticleService;
import com.zhidisoft.blog.admin.vo.PageVo;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private ArticleMapper dao;

	@Override
	public PageVo findPage(Integer pageNum, Integer pageSize) {
		PageVo pageVo = new PageVo();
		pageVo.setPageNum(pageNum);
		pageVo.setPageSize(pageSize);
		pageVo.setList(dao.pageList((pageNum - 1) * pageSize, pageSize));
		pageVo.setTotalCount(dao.totalCount().intValue());
		return pageVo;
	}

	@Override
	public int save(Article article) {
		return dao.save(article.getId(),article.getTitle(), article.getInfoTitle(), article.getInfo(), article.getUserId(), article.getTypeId());
	}

}
