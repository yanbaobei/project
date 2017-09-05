package com.zhidisoft.blog.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhidisoft.blog.admin.entity.ArticleType;

public interface ArticleTypeMapper {

	@Select("select * from article_type")
	List<ArticleType> findAll();
}
