package com.grupo.apirest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.grupo.apirest.entity.User;

@Transactional
public interface IUserService {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
}