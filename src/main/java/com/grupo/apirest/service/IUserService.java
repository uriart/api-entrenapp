package com.grupo.apirest.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.grupo.apirest.entity.administracion.UserModel;

@Transactional
public interface IUserService {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void save(UserModel user);
	
	void deleteById(int id);
}