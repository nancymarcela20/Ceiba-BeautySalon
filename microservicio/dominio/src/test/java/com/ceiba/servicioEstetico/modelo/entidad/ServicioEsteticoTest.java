package com.ceiba.servicioestetico.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static com.ceiba.servicioestetico.builder.ServicioEsteticoTestBuilder.aServicioEstetico;

public class ServicioEsteticoTest {

    private static final String ID_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el identificador del servicio estético";
    private static final String NOMBRE_SERVICIO_ESTETICO_REQUERIDO = "Se debe diligenciar el nombre del servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_REQUERIDO = "Se debe definir el tipo de servicio estético";
    private static final String TIPO_SERVICIO_ESTETICO_INVALIDO = "El tipo de servicio estético no corresponde";

    @Test
    public void validarIdServicioEsteticoRequerido(){
        //Arrange - Act - Assert
        BasePrueba.assertThrows(aServicioEstetico().sinIdServicio()::build, ExcepcionValorObligatorio.class, ID_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarNombreServicioEsteticoRequerido(){
        //Arrange - Act - Assert
        BasePrueba.assertThrows(aServicioEstetico().sinNombre()::build, ExcepcionValorObligatorio.class, NOMBRE_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoRequerido(){
        //Arrange - Act - Assert
        BasePrueba.assertThrows(aServicioEstetico().sinTipoServicio()::build, ExcepcionValorObligatorio.class, TIPO_SERVICIO_ESTETICO_REQUERIDO);
    }

    @Test
    public void validarTipoServicioEsteticoNoExiste(){
        //Arrange - Act - Assert
        BasePrueba.assertThrows(aServicioEstetico().conTipoServicio("TIPO_INVALIDO")::build, ExcepcionValorInvalido.class, TIPO_SERVICIO_ESTETICO_INVALIDO);
    }



}
