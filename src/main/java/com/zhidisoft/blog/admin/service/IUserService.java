package com.zhidisoft.blog.admin.service;

import com.zhidisoft.blog.admin.entity.User;

public interface IUserService {
	
	User findByUserName(String username);
}
