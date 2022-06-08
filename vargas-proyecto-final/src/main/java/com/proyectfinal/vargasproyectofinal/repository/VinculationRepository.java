package com.proyectfinal.vargasproyectofinal.repository;

import com.proyectfinal.vargasproyectofinal.model.entity.Client;
import com.proyectfinal.vargasproyectofinal.model.entity.Vinculation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VinculationRepository extends MongoRepository<Vinculation, String> {

    Boolean existsByClient(Client client);

}
