package com.jkc.SecurityApp.dao;

import org.hibernate.query.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jkc.SecurityApp.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String roleName) {

		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("from Role r where r.name=:roleName", Role.class);
		query.setParameter("roleName", roleName);
		Role role = null;
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		return role;
	}

}
