package com.ceiba.servicioestetico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioestetico.puerto.repositorio.RepositorioServicioEstetico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static com.ceiba.servicioestetico.builder.ServicioEsteticoTestBuilder.aServicioEstetico;

public class ServicioCrearServicioEsteticoTest {

    public static final String EL_SERVICIO_ESTETICO_YA_EXISTE_EN_EL_SISTEMA = "El servicio estético ya existe en el sistema";

    private RepositorioServicioEstetico repositorioServicioEstetico;

    @Before
    public void setUp(){
        repositorioServicioEstetico = mock(RepositorioServicioEstetico.class);
    }

    /**
     * Prueba la creación de un servicio estético manipulando exitosamente los retornos del repositorio
     */
    @Test
    public void validarCreacionServicioEstetico(){
        //Arrange
        ServicioEstetico servicioEstetico = aServicioEstetico().build();
        when(repositorioServicioEstetico.existe(anyString())).thenReturn(false);
        when(repositorioServicioEstetico.crear(servicioEstetico)).thenReturn(1L);
        ServicioCrearServicioEstetico servicioCrearServicioEstetico = new ServicioCrearServicioEstetico(repositorioServicioEstetico);
        //Act
        long idServicio = servicioCrearServicioEstetico.ejecutar(servicioEstetico);
        //Assert
        Assert.assertEquals(1L, idServicio);
    }

    @Test
    public void validarExistenciaPrevia(){
        //Arrange
        ServicioEstetico servicioEstetico = aServicioEstetico().conIdServicio("CA22").build();
        when(repositorioServicioEstetico.existe(anyString())).thenReturn(true);
        ServicioCrearServicioEstetico servicioCrearServicioEstetico = new ServicioCrearServicioEstetico(repositorioServicioEstetico);
        //Act Assert
        BasePrueba.assertThrows(
                ()->servicioCrearServicioEstetico.ejecutar(servicioEstetico),
                ExcepcionDuplicidad.class,EL_SERVICIO_ESTETICO_YA_EXISTE_EN_EL_SISTEMA);

    }
}
