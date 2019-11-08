package com.jkc.SecurityApp.dao;

import com.jkc.SecurityApp.entity.User;

public interface UserDAO {

	public void save(User user);

	public User findUserbyUserName(String userName);

}
