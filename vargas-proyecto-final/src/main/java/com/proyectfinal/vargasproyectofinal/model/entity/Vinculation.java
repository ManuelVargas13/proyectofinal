package com.proyectfinal.vargasproyectofinal.model.entity;

import com.proyectfinal.vargasproyectofinal.enumerator.TypeAfp;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("vinculacion")
@Data
@NoArgsConstructor
public class Vinculation {

    @Id
    private String idVinculation;
    private Client client;
    private TypeAfp afp;
    private double montoDisponible;
    private Date fechaRetiro;
    private String numeroCuenta;

}
