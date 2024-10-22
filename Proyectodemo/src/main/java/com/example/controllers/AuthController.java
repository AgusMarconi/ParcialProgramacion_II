package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.UsuarioDAO;
import com.example.models.Usuario;

@RestController
public class AuthController {

	@Autowired UsuarioDAO usuarioDAO;
	
	@PostMapping(value="api/login")
	public String login(@RequestBody Usuario usuario) {
		if (usuarioDAO.verificarCredenciales(usuario)) {
			return "OK";
		}else {
			return "Fail";
		}
	}
}
