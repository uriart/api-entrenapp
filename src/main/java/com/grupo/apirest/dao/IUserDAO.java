package com.grupo.apirest.dao;

import java.util.List;

import com.grupo.apirest.entity.UserModel;


public interface IUserDAO {
	
	public List<UserModel> findAll();
	
	public UserModel findById(int id);
	
	public void save(UserModel user);
	
	public void deleteById(int id);
}