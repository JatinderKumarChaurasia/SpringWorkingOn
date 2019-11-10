package com.jkc.SecurityApp.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jkc.SecurityApp.dao.RoleDAO;
import com.jkc.SecurityApp.dao.UserDAO;
import com.jkc.SecurityApp.entity.Role;
import com.jkc.SecurityApp.entity.User;
import com.jkc.SecurityApp.user.CRMUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userDAO.findUserbyUserName(arg0);
		if (user == null) {
			throw new UsernameNotFoundException("");
		} else {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					mapRolesToAuthorities(user.getRoles()));
		}
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void save(CRMUser crmUser) {
		/*
		 * List<GrantedAuthority> authorites = AuthorityUtils.createAuthorityList();
		 * authorites.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
		 */
		User user = new User();
		user.setUsername(crmUser.getUsername());
//		String encodedPassword = bcryptPasswordEncoder.encode(crmUser.getPassword());
//		encodedPassword = "${bcrypt}"+encodedPassword;
		user.setPassword(bcryptPasswordEncoder.encode(crmUser.getPassword()));
		user.setFirstname(crmUser.getFirstname());
		user.setLastname(crmUser.getLastname());
		user.setEmail(crmUser.getEmail());
		String userRole = crmUser.getUserRole();
		System.out.println(userRole);
//		user.setRoles(Arrays.asList(roleDAO.findRoleByName("ROLE_EMPLOYEE")));

		user.setRoles(Arrays.asList(roleDAO.findRoleByName(userRole),roleDAO.findRoleByName("ROLE_EMPLOYEE")));
		userDAO.save(user);
	}

	@Override
	@Transactional
	public User findUserByUserName(String userName) {
		return userDAO.findUserbyUserName(userName);
	}

}
