package com.zhidisoft.blog.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhidisoft.blog.admin.dao.ArticleTypeMapper;
import com.zhidisoft.blog.admin.entity.ArticleType;
import com.zhidisoft.blog.admin.service.IArticleTypeService;

@Service
@Transactional
public class ArticleTypeServiceImpl implements IArticleTypeService{

	@Autowired
	ArticleTypeMapper articleTypeMapper;

	@Override
	public List<ArticleType> findAll() {
		return articleTypeMapper.findAll();
	}
}
