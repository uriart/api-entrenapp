package com.grupo.apirest.service.impl;

import com.grupo.apirest.dao.IUserDAO;
import com.grupo.apirest.entity.administracion.UserModel;
import com.grupo.apirest.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public List<UserModel> findAll() {
		List<UserModel> listUsers= userDAO.findAll();
		return listUsers;
	}

	@Override
	public UserModel findById(int id) {
		UserModel user = userDAO.findById(id);
		return user;
	}

	@Override
	public void save(UserModel user) {
		log.info("Usuario {} eliminado", user.getName());
		userDAO.save(user);
	}

	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}

}