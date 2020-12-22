package com.ceiba.promocion.modelo.entidad;

import com.ceiba.promocion.constans.DiaSemana;

import static com.ceiba.dominio.ValidadorArgumento.*;

public class Promocion {

    private static final String ID_SERVICIO_ESTETICO_ES_REQUERIDO="Se debe diligenciar el identificador del servicio estético";
    private static final String PORCENTAJE_PROMOCION_ES_REQUERIDO="Se debe indicar el porcentaje de la promoción";
    private static final String DIA_ES_REQUERIDO="Se debe diligenciar el día de la promoción";
    private static final String DIA_VALIDO="Se debe diligenciar un día válido";

    private Long id;
    private String idServicio;
    private float porcentaje;
    private String dia;

    public Promocion(Long id, String idServicio, float porcentaje, String dia){
        validarObligatorio(idServicio, ID_SERVICIO_ESTETICO_ES_REQUERIDO);
        validarObligatorio(porcentaje, PORCENTAJE_PROMOCION_ES_REQUERIDO);
        validarObligatorio(dia, DIA_ES_REQUERIDO);
        validarValido(dia, DiaSemana.class, DIA_VALIDO);

        this.id = id;
        this.idServicio = idServicio;
        this.porcentaje = porcentaje;
        this.dia = dia;

    }

    public Long getId() {
        return id;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public String getDia() {
        return dia;
    }
}