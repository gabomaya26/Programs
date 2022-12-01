package com.clinicapet.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinicapet.app.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
