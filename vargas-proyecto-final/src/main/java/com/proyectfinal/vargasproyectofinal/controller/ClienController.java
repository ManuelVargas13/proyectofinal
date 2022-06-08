package com.proyectfinal.vargasproyectofinal.controller;

import com.proyectfinal.vargasproyectofinal.model.entity.Client;
import com.proyectfinal.vargasproyectofinal.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienController {

    @Autowired
    private ClientRepository clientRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients(){

        LOGGER.info("Hizo la petición de listado");
        return clientRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createClient(@RequestBody Client cliente){

        LOGGER.info("Hizo la petición de nuevo");
        clientRepository.save(cliente);
    }

    @GetMapping("/obtener/{idClient}")
    public ResponseEntity<Client> getClient(@PathVariable(value = "idClient") String idClient){

        LOGGER.info("Hizo la petición de obtener");
        Optional<Client> cliente = clientRepository.findById(idClient);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(cliente.get(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("eliminar/{idClient}")
    public String deleteClient(@PathVariable(value = "idClient") String idClient){

        LOGGER.info("Hizo la petición de eliminar");
        clientRepository.deleteById(idClient);

        return "Se eliminó correctamente el cliente";

    }

    @PutMapping("/actualizar/{idClient}")
    public Client updateProduct(@RequestBody Client cliente, @PathVariable(value = "idClient") String idClient){

        LOGGER.info("Hizo la petición de actualizar");
        cliente.setIdClient(idClient);
        clientRepository.save(cliente);

        return cliente;

    }

}
