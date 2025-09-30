package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.UsuarioDAO;
import com.example.models.Usuario;
import com.example.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="mensaje")
	public String mensaje(){
		return "mensaje";
	}
	
	@RequestMapping(value="persona")
	public List<String> listarPersonas(){
		return List.of("Diego","Juan","Pedro");
	}
	
	/*@RequestMapping(value="usuario")
	public Usuario getUsuario() {
		Usuario user=new Usuario();
		user.setNombre("Agustina");
		user.setApellido("Marconi");
		user.setEmail("agustinamarconi39@gmail.com");
		user.setTelefono("2615160338");
		
		return user;
		
	}*/
	
	@RequestMapping(value="usuario/{id}")
	public Usuario getUsuarioId(@PathVariable Long id){
		Usuario user=new Usuario();
		user.setId(id);
		user.setNombre("Agustina");
		user.setApellido("Marconi");
		user.setEmail("agustinamarconi39@gmail.com");
		user.setTelefono("2615160338");
		
		return user;
	}
	
	
	@RequestMapping(value="api/usuarios")
	public List<Usuario> getUsuario(@RequestHeader(value="Authorization") String token){
		
		String usuarioId = jwtUtil.getKey(token);
		
		if (usuarioId == null) {
			return new ArrayList<>();
		}
		List<Usuario> usuarios=usuarioDao.getUsuarios();
		
		return usuarios;
		/*Usuario user=new Usuario();
		user.setId(1L);
		user.setNombre("Agustina");
		user.setApellido("Marconi");
		user.setEmail("agustinamarconi39@gmail.com");
		user.setTelefono("2615160338");
		usuarios.add(user);*/

	}
	
	@DeleteMapping(value="api/usuarios/{id}")
	public void deleteUsuario(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
		
		String usuarioId = jwtUtil.getKey(token);
		
		if (usuarioId == null) {
			return;
		}
		usuarioDao.eliminarUsuario(id);
	}
	
	@PostMapping(value="api/usuarios")
	public void registrarUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
		String pass_hasheado=argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(pass_hasheado);
		usuarioDao.registrarUsuario(usuario);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
