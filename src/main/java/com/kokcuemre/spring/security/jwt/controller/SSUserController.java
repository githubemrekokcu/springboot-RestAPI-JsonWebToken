package com.kokcuemre.spring.security.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kokcuemre.spring.security.jwt.domain.SSUser;
import com.kokcuemre.spring.security.jwt.service.SSUserService;

@RestController
@RequestMapping("/api/user")
public class SSUserController {
	
	private final SSUserService userService;
	
	@Autowired
	public SSUserController(SSUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	private ResponseEntity<List<SSUser>> findAllUser(){
		return ResponseEntity.ok(userService.findAllUser());
	}
	
	@PostMapping
	private ResponseEntity<SSUser> saveUser(@RequestBody SSUser ssUser){
		return ResponseEntity.ok(userService.saveUser(ssUser));
	}
}
