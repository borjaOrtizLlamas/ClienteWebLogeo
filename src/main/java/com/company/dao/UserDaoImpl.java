package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import com.company.model.UserRole;
import com.company.model.Usuario;

public class UserDaoImpl implements UserDao {
	
	
	private SessionFactory sessionFactory;
	
	public Usuario findByUserName(String username) {
		List<Usuario> users = new ArrayList<Usuario>();

		users = sessionFactory.getCurrentSession().createQuery("from Usuario where username=?").setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}


	public List<UserRole> findByUserNamerRoles (String username) {
	
		List<UserRole> users = new ArrayList<UserRole>();

		users = sessionFactory.getCurrentSession().createQuery("from UserRole where usuario=?").setParameter(0, username).list();

		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}

	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
