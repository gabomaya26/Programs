package com.clinicapet.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicapet.app.model.Usuario;
import com.clinicapet.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	@CrossOrigin(origins = "http://localhost:8093")
	@PostMapping("/add")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {return service.addUsuario(usuario);}
	
	@CrossOrigin(origins = "http://localhost:8093")
	@GetMapping("/all")
	public List<Usuario>getUsuarios(){return service.findAllUsuarios();}
	
	@CrossOrigin(origins = "http://localhost:8093")
	@GetMapping("one/{id}")
	public Usuario getUsuario(@PathVariable String id) {return service.getUsuarioById(id);}
	
	@CrossOrigin(origins = "http://localhost:8093")
	@PutMapping("/update")
	public Usuario modifyUsuario(@RequestBody String id, Usuario usuario) {return service.updateUsuario(id, usuario);}
	
	@CrossOrigin(origins = "http://localhost:8093")
	@DeleteMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable String id) {return service.deleteUsuario(id);}
}
