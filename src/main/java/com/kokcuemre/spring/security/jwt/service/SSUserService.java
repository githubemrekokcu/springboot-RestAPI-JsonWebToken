package com.kokcuemre.spring.security.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kokcuemre.spring.security.jwt.domain.SSUser;
import com.kokcuemre.spring.security.jwt.repository.SSUserRepository;

@Service
public class SSUserService {
	
	private final SSUserRepository ssUserRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public SSUserService(SSUserRepository ssUserRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.ssUserRepository = ssUserRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	public List<SSUser> findAllUser() {
		return ssUserRepository.findAll();
	}
	public SSUser saveUser(SSUser ssUser) {
		ssUser.setPassword(bCryptPasswordEncoder.encode(ssUser.getPassword()));
		return ssUserRepository.save(ssUser);
	}
	
}
