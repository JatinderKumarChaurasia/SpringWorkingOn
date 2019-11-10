package com.jkc.SecurityApp.dao;

import com.jkc.SecurityApp.entity.Role;

public interface RoleDAO {

	public Role findRoleByName(String roleName);
}
