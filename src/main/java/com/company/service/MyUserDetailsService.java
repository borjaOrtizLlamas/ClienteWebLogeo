/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

/**
 *
 * @author borja
 */
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.model.UserRole;
import com.company.model.Usuario;
import com.company.servicioweb.serviciologeo.LogeoRequest;
import com.company.servicioweb.serviciologeo.LogeoResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class MyUserDetailsService implements UserDetailsService {
	
    private UserDao userDao; 
	private String contrasena;
    
	public UserDetails loadUserByUsername(final String username)    
			throws UsernameNotFoundException {

		Usuario user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(username);

		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(Usuario user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), contrasena , user.isEnabled(), true, true, true, authorities); 
	}
	
	private List<GrantedAuthority> buildUserAuthority(String username) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		List<UserRole> a = userDao.findByUserNamerRoles(username); 
		
		for(UserRole b : a){
			setAuths.add(new SimpleGrantedAuthority(b.getRole()));
		}
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}