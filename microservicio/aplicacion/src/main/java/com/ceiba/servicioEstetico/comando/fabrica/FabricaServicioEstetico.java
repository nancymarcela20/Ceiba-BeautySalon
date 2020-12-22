package com.ceiba.servicioestetico.comando.fabrica;

import com.ceiba.servicioestetico.comando.ComandoServicioEstetico;
import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicioEstetico {

    public ServicioEstetico crear(ComandoServicioEstetico comandoServicioEstetico){
        return new ServicioEstetico(
                comandoServicioEstetico.getId(),
                comandoServicioEstetico.getIdServicio(),
                comandoServicioEstetico.getNombre(),
                comandoServicioEstetico.getTipoServicio(),
                comandoServicioEstetico.getCosto(),
                comandoServicioEstetico.isEstadoServicio()
        );

    }
}
