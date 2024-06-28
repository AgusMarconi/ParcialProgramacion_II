package com.example.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioDAOImp implements UsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> obtenerUsuarios() {
		
		String query="from Usuario";
		return entityManager.createQuery(query).getResultList();
	}
	
	
}
