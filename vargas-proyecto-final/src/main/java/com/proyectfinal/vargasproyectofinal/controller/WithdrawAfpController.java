package com.proyectfinal.vargasproyectofinal.controller;

import com.proyectfinal.vargasproyectofinal.model.entity.Vinculation;
import com.proyectfinal.vargasproyectofinal.model.entity.WithdrawAfp;
import com.proyectfinal.vargasproyectofinal.repository.VinculationRepository;
import com.proyectfinal.vargasproyectofinal.repository.WithdrawAfpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("/api/retirarafp")
public class WithdrawAfpController {

    @Autowired
    private WithdrawAfpRepository withdrawAfpRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/listadoR")
    @ResponseStatus(HttpStatus.OK)
    public List<WithdrawAfp> getAllSolicitudes(){

        LOGGER.info("Hizo la petición de listado");
        return withdrawAfpRepository.findAll();
    }

    @PostMapping("/nuevoR")
    @ResponseStatus(HttpStatus.OK)
    //REGISTRAR SOLICITUD CON VALIDACIONES DE MONTO PERMITIDO
    public String createSolicitud(@RequestBody WithdrawAfp withdrawAfp){

        LOGGER.info("Hizo la petición de nuevo");

        double afp = withdrawAfp.getVinculation().getMontoDisponible();
        double retiro = withdrawAfp.getMontoRetiro();
        double permitido = afp * 0.5;

        if(retiro>permitido){
            return "No se puede registrar la solicitud. Cantidad superior a la permitida";
        }else if(retiro<permitido){
            return "Monto mínimo no cubierto por favor revise el monto mínimo a retirar";
        }else if(retiro>=permitido && retiro <=afp){
            withdrawAfpRepository.save(withdrawAfp);
            return "Solicitud Registrada";
        }else{
            return "No se puede registrar la solicitud";
        }
    }

}
