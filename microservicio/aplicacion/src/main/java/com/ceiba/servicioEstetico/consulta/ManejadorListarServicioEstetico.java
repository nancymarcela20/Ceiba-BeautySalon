package com.ceiba.servicioestetico.consulta;

import com.ceiba.servicioestetico.modelo.dto.DtoServicioestetico;
import com.ceiba.servicioestetico.puerto.dao.DaoServicioEstetico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServicioEstetico {

    private final DaoServicioEstetico daoServicioEstetico;

    public ManejadorListarServicioEstetico(DaoServicioEstetico daoServicioEstetico){
        this.daoServicioEstetico = daoServicioEstetico;
    }

    public List<DtoServicioestetico> ejecutar(){
        return this.daoServicioEstetico.listar();
    }

}
