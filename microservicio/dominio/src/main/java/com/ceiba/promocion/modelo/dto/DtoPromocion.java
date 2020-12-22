package com.ceiba.promocion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPromocion {

    private Long id;
    private String idServicio;
    private float porcentaje;
    private String dia;

}
