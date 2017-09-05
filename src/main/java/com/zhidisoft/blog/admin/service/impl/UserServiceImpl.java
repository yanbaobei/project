package com.zhidisoft.blog.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhidisoft.blog.admin.dao.UserMapper;
import com.zhidisoft.blog.admin.entity.User;
import com.zhidisoft.blog.admin.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

}
