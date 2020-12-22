package com.ceiba.servicioestetico.builder;

import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;

public class ServicioEsteticoTestBuilder {
    private Long id;
    private String idServicio;
    private String nombre;
    private String tipoServicio;
    private int costo;
    private boolean estadoServicio;

    public ServicioEsteticoTestBuilder(){
        this.id = 1L;
        this.idServicio = "CA22";
        this.nombre = "cejas";
        this.tipoServicio = "DEPILACION";
        this.costo = 7000;
        this.estadoServicio = true;
    }

    public ServicioEsteticoTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioEsteticoTestBuilder conIdServicio(String idServicio){
        this.idServicio = idServicio;
        return this;
    }

    public ServicioEsteticoTestBuilder sinIdServicio(){
        this.idServicio = null;
        return this;
    }

    public ServicioEsteticoTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ServicioEsteticoTestBuilder sinNombre(){
        this.nombre = null;
        return this;
    }

    public ServicioEsteticoTestBuilder conTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
        return this;
    }

    public ServicioEsteticoTestBuilder sinTipoServicio(){
        this.tipoServicio = null;
        return this;
    }

    public ServicioEsteticoTestBuilder conCosto(int costo) {
        this.costo = costo;
        return this;
    }

    public ServicioEsteticoTestBuilder conEstadoServicio(boolean estadoServicio) {
        this.estadoServicio = estadoServicio;
        return this;
    }

    public ServicioEstetico build(){
        return new ServicioEstetico(id, idServicio, nombre, tipoServicio, costo, estadoServicio);
    }

    public static ServicioEsteticoTestBuilder aServicioEstetico(){
        return new ServicioEsteticoTestBuilder();
    }
}
