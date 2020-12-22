package com.ceiba.servicioestetico.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.servicioestetico.comando.ComandoServicioEstetico;
import com.ceiba.servicioestetico.comando.fabrica.FabricaServicioEstetico;
import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioestetico.servicio.ServicioCrearServicioEstetico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearServicioEstetico implements ManejadorComandoRespuesta<ComandoServicioEstetico, ComandoRespuesta<Long>> {

    private final FabricaServicioEstetico fabricaServicioEstetico;
    private final ServicioCrearServicioEstetico servicioCrearServicioEstetico;

    public ManejadorCrearServicioEstetico(FabricaServicioEstetico fabricaServicioEstetico,
                                          ServicioCrearServicioEstetico servicioCrearServicioEstetico){
        this.fabricaServicioEstetico = fabricaServicioEstetico;
        this.servicioCrearServicioEstetico =  servicioCrearServicioEstetico;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoServicioEstetico comandoServicioEstetico) {
        ServicioEstetico servicioEstetico = this.fabricaServicioEstetico.crear(comandoServicioEstetico);
        return new ComandoRespuesta<>(this.servicioCrearServicioEstetico.ejecutar(servicioEstetico));
    }
}
