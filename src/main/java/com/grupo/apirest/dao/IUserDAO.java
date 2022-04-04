package com.grupo.apirest.dao;

import java.util.List;

import com.grupo.apirest.entity.User;


public interface IUserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
}