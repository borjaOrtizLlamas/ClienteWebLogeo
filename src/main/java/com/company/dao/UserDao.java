package com.company.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.company.model.UserRole;
import com.company.model.Usuario;

public interface UserDao {
	
	@Transactional (readOnly = true)
	Usuario findByUserName(String username);

	@Transactional (readOnly = true)
	List<UserRole> findByUserNamerRoles(String username);
}

