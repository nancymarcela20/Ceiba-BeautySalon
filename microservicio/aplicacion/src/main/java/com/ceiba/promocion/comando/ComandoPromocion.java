package com.ceiba.promocion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPromocion {

    private Long id;
    private String idServicio;
    private float porcentaje;
    private String dia;

}
