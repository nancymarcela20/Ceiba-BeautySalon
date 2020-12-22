package com.ceiba.servicioestetico.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoServicioestetico {

    private Long id;
    private String idServicio;
    private String nombre;
    private String tipoServicio;
    private int costo;
    private boolean estadoServicio;
}
