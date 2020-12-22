package com.ceiba.promocion.comando.fabrica;

import com.ceiba.promocion.comando.ComandoPromocion;
import com.ceiba.promocion.modelo.entidad.Promocion;
import org.springframework.stereotype.Component;

@Component
public class FabricaPromocion {

    public Promocion crear(ComandoPromocion comandoPromocion){
        return new Promocion(
                comandoPromocion.getId(),
                comandoPromocion.getIdServicio(),
                comandoPromocion.getPorcentaje(),
                comandoPromocion.getDia()
        );
    }
}
