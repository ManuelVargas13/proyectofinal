package com.proyectfinal.vargasproyectofinal.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testCliente(){
        Client client = new Client("","Manuel","Vargas Azañero", "71883851", "952761400", "manuelvargasa13@gmail.com");

        String nombreEsperado = "Rodolfo";
        String nombreReal = client.getNombres();

        Assertions.assertEquals(nombreEsperado,nombreReal);

        Assertions.assertEquals("71883851", client.getDni());

        Assertions.assertNotNull(client, () -> "debe tener datos");

    }

}