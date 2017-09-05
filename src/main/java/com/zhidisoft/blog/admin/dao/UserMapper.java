package com.zhidisoft.blog.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhidisoft.blog.admin.entity.User;

public interface UserMapper {

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	@Select("select * from user where username=#{username}")
	User findByUserName(@Param("username") String username);
}
