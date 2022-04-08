package com.grupo.apirest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.grupo.apirest.dao.IUserDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo.apirest.entity.UserModel;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<UserModel> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<UserModel> theQuery = currentSession.createQuery("from UserModel", UserModel.class);
		
		List<UserModel> users = theQuery.getResultList();
		
		return users;

	}

	@Override
	public UserModel findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		UserModel user = currentSession.get(UserModel.class, id);
		
		return user;
	}

	@Override
	public void save(UserModel user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(user);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<UserModel> theQuery = currentSession.createQuery("delete from User where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
		
	}

	
}