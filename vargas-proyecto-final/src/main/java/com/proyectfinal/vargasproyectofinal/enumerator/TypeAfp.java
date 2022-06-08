package com.proyectfinal.vargasproyectofinal.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeAfp {
    PRIMA("PRIMA"), INTEGRA("INTEGRA"), PROFUTURO("PROFUTURO"), HABITAT("HABITAT");
    private String name;
}
