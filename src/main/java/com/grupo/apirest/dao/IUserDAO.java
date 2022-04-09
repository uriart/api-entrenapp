package com.grupo.apirest.dao;

import java.util.List;

import com.grupo.apirest.entity.administracion.UserModel;


public interface IUserDAO {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void save(UserModel user);
	
	void deleteById(int id);
}