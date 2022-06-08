package com.proyectfinal.vargasproyectofinal.controller;

import com.proyectfinal.vargasproyectofinal.model.entity.Vinculation;
import com.proyectfinal.vargasproyectofinal.repository.VinculationRepository;
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
@RequestMapping("/api/vinculacion")
public class VinculationControler {

    @Autowired
    private VinculationRepository vinculationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/listadoV")
    @ResponseStatus(HttpStatus.OK)
    public List<Vinculation> getAllVinculations(){

        LOGGER.info("Hizo la petición de listado");
        return vinculationRepository.findAll();
    }

    @PostMapping("/nuevoV")
    @ResponseStatus(HttpStatus.OK)
    public String createVinculation(@RequestBody Vinculation vinculation){

        LOGGER.info("Hizo la petición de nuevo");

        Boolean yaVinculado = vinculationRepository.existsByClient(vinculation.getClient());

        //LOGGER.info("valor: " + yaVinculado);

        if (yaVinculado){
            return "Cliente solo debe pertenecer a una Afp";
        }else{
            vinculationRepository.save(vinculation);
            return "Cliente afiliado a una Afp";
        }
    }

    @GetMapping("/obtenerV/{idVinculation}")
    public ResponseEntity<Vinculation> getVinculation(@PathVariable(value = "idVinculation") String idVinculation){

        LOGGER.info("Hizo la petición de obtener");
        Optional<Vinculation> vinculation = vinculationRepository.findById(idVinculation);
        if(vinculation.isPresent()){
            return new ResponseEntity<>(vinculation.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(vinculation.get(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("eliminarV/{idVinculation}")
    public String deleteVinculation(@PathVariable(value = "idVinculation") String idVinculation){

        LOGGER.info("Hizo la petición de eliminar");
        vinculationRepository.deleteById(idVinculation);

        return "Se eliminó correctamente la vinculación a la afp";

    }

    @PutMapping("/actualizarV/{idVinculation}")
    public Vinculation updateVinculation(@RequestBody Vinculation vinculation, @PathVariable(value = "idVinculation") String idVinculation){

        LOGGER.info("Hizo la petición de actualizar");
        vinculation.setIdVinculation(idVinculation);
        vinculationRepository.save(vinculation);

        return vinculation;

    }

}
