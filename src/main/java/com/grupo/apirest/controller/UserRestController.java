package com.grupo.apirest.controller;

import java.util.List;

import com.grupo.apirest.util.SwaggerConfigurationConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.apirest.entity.User;
import com.grupo.apirest.service.IUserService;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class UserRestController {

	@Autowired
	private IUserService userService;

	@ApiOperation(value = SwaggerConfigurationConstants.FIND_ALL_DESCRIPCION)
	@GetMapping("/users")
	public List<User> findAll(){
		//retornará todos los usuarios
		return userService.findAll();
	}

	@ApiOperation(value = SwaggerConfigurationConstants.GET_USUARIO_DESCRIPCION)
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId){
		User user = userService.findById(userId);
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		//retornará al usuario con id pasado en la url
		return user;
	}

	@ApiOperation(value = SwaggerConfigurationConstants.ADD_USUARIO_DESCRIPCION)
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		//Este metodo guardará al usuario enviado
		userService.save(user);
		
		return user;
		
	}

	@ApiOperation(value = SwaggerConfigurationConstants.UPDATE_USUARIO_DESCRIPCION)
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}

	@ApiOperation(value = SwaggerConfigurationConstants.DELETE_USUARIO_DESCRIPCION)
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User user = userService.findById(userId);
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		userService.deleteById(userId);
		return "Deleted user id - "+userId;
	}
	
}