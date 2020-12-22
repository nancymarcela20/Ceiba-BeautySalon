package com.ceiba.servicioestetico.modelo.dto;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ServicioEsteticoDtoTest {

    @Test
    public void validarIdServicioEsteticoRequerido(){
        //Arrange
        long id = 1L;
        String idServicio = "CC03";
        String nombre = "grafilado";
        String tipoServicio = "CORTE";
        int costo = 15000;
        boolean estadoServicio = true;
        //Act
        DtoServicioestetico servicioEstetico = new DtoServicioestetico(id, idServicio, nombre, tipoServicio, costo, estadoServicio);
        //Assert
        boolean esValido = id == servicioEstetico.getId()&&idServicio.equals(servicioEstetico.getIdServicio())
                &&nombre.equals(servicioEstetico.getNombre())&&tipoServicio.equals(servicioEstetico.getTipoServicio())
                &&costo == servicioEstetico.getCosto()&&estadoServicio==servicioEstetico.isEstadoServicio();
        assertTrue(esValido);

    }
}
