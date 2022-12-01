package com.clinicapet.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinicapet.app.model.Animal;
import com.clinicapet.app.repository.AnimalRepository;



@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	//CRUD CREATE, RED, UPDATE, DELETE
	//create
	public Animal addAnimal(Animal animal) {
		return repository.save(animal);
	}
	
	//read
	public List<Animal> findAllAnimales(){
		return  repository.findAll();
	}
	
	public Animal getAnimalById(String id) {
		return repository.findById(id).get();
	}
	
	//update
	public Animal updateAnimal(String Getid, Animal animalRequest) {
		Animal existe = repository.findById(animalRequest.getGetId()).get();
		existe.setNombre(animalRequest.getNombre());
		existe.setPeso(animalRequest.getPeso());
		existe.setProblema(animalRequest.getProblema());
		existe.setRaza(animalRequest.getRaza());
		existe.setGenero(animalRequest.getGenero());
		existe.setImagen(animalRequest.getImagen());
		
		return repository.save(existe);
	}
	//delete
	
	public String deleteAnimal(String id) {
		repository.deleteById(id);
		return id+" animal eliminado";
		
	}
		
		

	
	

}
