package com.ceiba.promocion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.promocion.comando.ComandoPromocion;
import com.ceiba.promocion.comando.fabrica.FabricaPromocion;
import com.ceiba.promocion.modelo.entidad.Promocion;
import com.ceiba.promocion.servicio.ServicioCrearPromocion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPromocion implements ManejadorComandoRespuesta<ComandoPromocion, ComandoRespuesta<Long>> {

    private final FabricaPromocion fabricaPromocion;
    private final ServicioCrearPromocion servicioCrearPromocion;

    public ManejadorCrearPromocion(FabricaPromocion fabricaPromocion, ServicioCrearPromocion servicioCrearPromocion) {
        this.fabricaPromocion = fabricaPromocion;
        this.servicioCrearPromocion = servicioCrearPromocion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPromocion comandoPromocion) {
        Promocion promocion = this.fabricaPromocion.crear(comandoPromocion);
        return new ComandoRespuesta<>(this.servicioCrearPromocion.ejecutar(promocion));
    }
}
