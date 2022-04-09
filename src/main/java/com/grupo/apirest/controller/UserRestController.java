package com.grupo.apirest.controller;

import com.grupo.apirest.entity.administracion.UserModel;
import com.grupo.apirest.service.IUserService;
import com.grupo.apirest.util.SwaggerConfigurationConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@RequestMapping(path = "/administracion", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

	@Autowired
	private IUserService userService;

	@ApiOperation(value = SwaggerConfigurationConstants.FIND_ALL_DESCRIPCION)
	@GetMapping("/users")
	public List<UserModel> findAll(){
		//retornará todos los usuarios
		return userService.findAll();
	}

	@ApiOperation(value = SwaggerConfigurationConstants.GET_USUARIO_DESCRIPCION)
	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable int userId){
		UserModel user = userService.findById(userId);
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		//retornará al usuario con id pasado en la url
		return user;
	}

	@ApiOperation(value = SwaggerConfigurationConstants.ADD_USUARIO_DESCRIPCION)
	@PostMapping("/users")
		public UserModel addUser(@RequestBody UserModel user) {
		//Este metodo guardará al usuario enviado
		userService.save(user);
		return user;
	}

	@ApiOperation(value = SwaggerConfigurationConstants.UPDATE_USUARIO_DESCRIPCION)
	@PutMapping("/users")
	public UserModel updateUser(@RequestBody UserModel user) {
		userService.save(user);
		return user;
	}

	@ApiOperation(value = SwaggerConfigurationConstants.DELETE_USUARIO_DESCRIPCION)
	@DeleteMapping("users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		UserModel user = userService.findById(userId);
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		userService.deleteById(userId);
		return "Deleted user id - "+userId;
	}
	
}