package com.jkc.SecurityApp.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jkc.SecurityApp.entity.User;
import com.jkc.SecurityApp.user.CRMUser;

public interface UserService extends UserDetailsService {

	public void save(CRMUser user);
	public User findUserByUserName(String userName);
}
