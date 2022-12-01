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

import com.clinicapet.app.model.Animal;
import com.clinicapet.app.service.AnimalService;



@RestController

@RequestMapping("/api/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	@CrossOrigin(origins = "http://localhost:8093")
	@PostMapping("/add")
	public Animal crearAnimal(@RequestBody Animal animal) {
		return service.addAnimal(animal);
	}
	@CrossOrigin(origins = "http://localhost:8093")
	@GetMapping("/all")
	public List<Animal> getAnimales(){
		return service.findAllAnimales();
	}
	@CrossOrigin(origins = "http://localhost:8093")
	@GetMapping("/one/{id}")
	public Animal getAnimal(@PathVariable String id) {
		return service.getAnimalById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8093")
	@PutMapping("/update")
	public Animal modifyAnimal(@RequestBody String id, Animal animal) {
		return service.updateAnimal(id, animal);
	}
	@CrossOrigin(origins = "http://localhost:8093")
	@DeleteMapping("/delete/{id}")
	public String deleteAnimal(@PathVariable String id) {
		return service.deleteAnimal(id);
	}
}
