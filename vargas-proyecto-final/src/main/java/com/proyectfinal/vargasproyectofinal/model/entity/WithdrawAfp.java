package com.proyectfinal.vargasproyectofinal.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("retiroafp")
@Data
@NoArgsConstructor
public class WithdrawAfp {

    @Id
    private String idWithdraw;
    private Vinculation vinculation;
    private double montoRetiro;

}
