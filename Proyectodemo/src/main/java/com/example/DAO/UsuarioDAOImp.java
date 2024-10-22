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
	public List<Usuario> getUsuarios() {
		
		String query="from Usuario";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void eliminarUsuario(Long id) {
		Usuario usuario=entityManager.find(Usuario.class, id);
		
		entityManager.remove(usuario);
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		entityManager.merge(usuario);
		
	}

	@Override
	public boolean verificarCredenciales(Usuario usuario) {
		String query="FROM Usuario WHERE email= :email AND password= :password";
		List<Usuario> lista=entityManager.createQuery(query)
				.setParameter("email",usuario.getEmail())
				.setParameter("password", usuario.getPassword()).getResultList();

		return !lista.isEmpty();
		
	}
	
	
}
