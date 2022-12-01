package com.clinicapet.app.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinicapet.app.model.Animal;


@Repository
public interface AnimalRepository extends MongoRepository<Animal, String>{


}
