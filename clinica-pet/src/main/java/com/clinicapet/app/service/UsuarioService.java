package com.clinicapet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicapet.app.model.Usuario;
import com.clinicapet.app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	//CREATE READ UPDATE DELETE
	//create
	public Usuario addUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	//read
	public List<Usuario>findAllUsuarios(){
		return repository.findAll();
	}
	
	public Usuario getUsuarioById(String id) {
		return repository.findById(id).get();
	}
	
	//update
	public Usuario updateUsuario(String id, Usuario usuarioRequest) {
		Usuario existe = repository.findById(usuarioRequest.getId()).get();
		existe.setNombre(usuarioRequest.getNombre());
		existe.setCorreo(usuarioRequest.getCorreo());
		existe.setUsername(usuarioRequest.getUsername());
		existe.setPassword(usuarioRequest.getPassword());
		
		return repository.save(existe);
	}
	
	public String deleteUsuario(String id) {
		repository.deleteById(id);
		return id+"usuario eliminado";
	}
}
