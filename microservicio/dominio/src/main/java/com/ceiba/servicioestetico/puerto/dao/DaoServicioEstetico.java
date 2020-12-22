package com.ceiba.servicioestetico.puerto.dao;

import com.ceiba.servicioestetico.modelo.dto.DtoServicioestetico;

import java.util.List;

public interface DaoServicioEstetico {

    /**
     * Permite listar los servicios esteticos
     * @return los servicios esteticos
     */
    List<DtoServicioestetico> listar();
}
