package com.example.DAO;

import java.util.List;

import com.example.models.Usuario;

import jakarta.transaction.Transactional;


@Transactional
public interface UsuarioDAO {
	
	List<Usuario> obtenerUsuarios();
}
