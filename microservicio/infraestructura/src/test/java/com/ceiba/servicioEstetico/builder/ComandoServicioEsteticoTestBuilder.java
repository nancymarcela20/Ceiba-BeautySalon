package com.ceiba.servicioestetico.builder;

import com.ceiba.servicioestetico.comando.ComandoServicioEstetico;

public class ComandoServicioEsteticoTestBuilder {

    private Long id;
    private String idServicio;
    private String nombre;
    private String tipoServicio;
    private int costo;
    private boolean estadoServicio;

    public ComandoServicioEsteticoTestBuilder(){
        this.idServicio = "CE09";
        this.nombre = "Cejas";
        this.tipoServicio="DEPILACION";
        this.costo = 8000;
        this.estadoServicio=true;
    }

    public ComandoServicioEsteticoTestBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder conIdServicio(String idServicio){
        this.idServicio = idServicio;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder conTipoServicio(String tipoServicio){
        this.tipoServicio = tipoServicio;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder conCosto(int costo){
        this.costo = costo;
        return this;
    }

    public ComandoServicioEsteticoTestBuilder conEstadoServicio(boolean estadoServicio){
        this.estadoServicio = estadoServicio;
        return this;
    }

    public ComandoServicioEstetico build(){
        return new ComandoServicioEstetico(id, idServicio, nombre, tipoServicio, costo, estadoServicio);
    }

    public static ComandoServicioEsteticoTestBuilder aComandoServicioEstetico(){
        return new ComandoServicioEsteticoTestBuilder();
    }

}
