package com.proyectfinal.vargasproyectofinal.model.entity;

import com.proyectfinal.vargasproyectofinal.enumerator.TypeAfp;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cliente")
@Data
@NoArgsConstructor
public class Client {

    @Id
    private String idClient;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    //private TypeAfp afp;
    private String correo;

}
