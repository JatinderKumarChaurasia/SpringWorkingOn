package com.jkc.SecurityApp.dao;

import org.hibernate.query.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jkc.SecurityApp.entity.User;

@Repository
public class UserDAOImple implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public User findUserbyUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where username =: userName",User.class);
		query.setParameter("userName", userName);
		User user = null;
		try{
			user = query.getSingleResult();
		}catch(Exception e){
			user = null;
		}
		return user;
	}

}
