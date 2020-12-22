package com.ceiba.promocion.consulta;

import com.ceiba.promocion.modelo.dto.DtoPromocion;
import com.ceiba.promocion.puerto.dao.DaoPromocion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPromociones {

    private final DaoPromocion daoPromocion;

    public ManejadorListarPromociones(DaoPromocion daoPromocion) {
        this.daoPromocion = daoPromocion;
    }

    public List<DtoPromocion> ejecutar(){
        return this.daoPromocion.listar();
    }

}
