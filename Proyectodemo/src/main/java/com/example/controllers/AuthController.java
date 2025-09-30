package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.UsuarioDAO;
import com.example.models.Usuario;
import com.example.utils.JWTUtil;

@RestController
public class AuthController {

	@Autowired UsuarioDAO usuarioDAO;
	
	@Autowired JWTUtil jwtUtil;
	
	@PostMapping(value="api/login")
	public String login(@RequestBody Usuario usuario) {
		Usuario usuarioLogueado = usuarioDAO.obtenerUsuarioPorCredenciales(usuario);
	
		if (usuarioLogueado != null) {
			String token = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
			
			return token;
		}
		
		return "Fail";
		
	}
}
