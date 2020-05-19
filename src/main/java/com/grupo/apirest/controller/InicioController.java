package com.grupo.apirest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo.apirest.entity.User;

@Controller
public class InicioController {

    private final UserRestController userRestController;

    public InicioController(UserRestController userRestController) {
        this.userRestController = userRestController;
    }
	
    @RequestMapping("/")
    public String paginaInicial(Model model) {
		List<User> usuarios = userRestController.findAll();
		model.addAttribute("usuariosSalida", usuarios);
        return "inicio";
    }
    
    @RequestMapping("/nuevoUsuario")
    public String nuevoUsuario() {
        return "nuevoUsuario";
    }
    
    @RequestMapping("/submitUsuario")
    public String submitUsuario(String inputEmail, String inputPassword) {
    	User usr = new User();
    	usr.setEmail(inputEmail);
    	usr.setPassword(inputPassword);
    	usr.setCreatedAt(new Date());
    	usr.setUpdatedAt(new Date());
    	
    	userRestController.addUser(usr);
        return "redirect:/";
    }
    
    @RequestMapping("/deleteUsuario")
    public String deleteUsuario(String checked) {
    	String[] ids = checked.split(",");
    	for(int i=0;i<ids.length;i++) {
    		System.out.println("id eleminar "+Integer.valueOf(ids[i]));
    		userRestController.deleteUser(Integer.valueOf(ids[i]));	
    	}
        return "redirect:/";
    }
}
