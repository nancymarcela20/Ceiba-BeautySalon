package com.ceiba.configuracion;

import com.ceiba.promocion.puerto.repositorio.RepositorioPromocion;
import com.ceiba.promocion.servicio.ServicioCrearPromocion;
import com.ceiba.servicioestetico.puerto.repositorio.RepositorioServicioEstetico;
import com.ceiba.servicioestetico.servicio.ServicioCrearServicioEstetico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPromocion {

    @Bean
    public ServicioCrearPromocion servicioCrearPromocion(RepositorioPromocion repositorioPromocion){
        return new ServicioCrearPromocion(repositorioPromocion);
    }

}
