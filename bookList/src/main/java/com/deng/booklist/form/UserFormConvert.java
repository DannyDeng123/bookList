package com.deng.booklist.form;

import org.springframework.beans.BeanUtils;

import com.deng.booklist.entity.User;

public class UserFormConvert implements FormConvert<UserForm, User> {
	@Override
	public User convert(UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		return user;
	}
}
