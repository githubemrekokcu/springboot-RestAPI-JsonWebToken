package com.kokcuemre.spring.security.jwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kokcuemre.spring.security.jwt.domain.SSUser;

public interface SSUserRepository extends CrudRepository<SSUser, Long> {
	
	Optional<SSUser> findByUserNameAndPassword(String userName,String password);
	List<SSUser> findAll();
	SSUser findByUserName(String userName);
	
}
