package com.ceiba.promocion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.promocion.adaptador.mapper.MapeoPromocion;
import com.ceiba.promocion.modelo.dto.DtoPromocion;
import com.ceiba.promocion.puerto.dao.DaoPromocion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPromocionEnMemoria implements DaoPromocion {

    private final CustomNamedParameterJdbcTemplate customerNamedParameterJdbcTemplate;

    public DaoPromocionEnMemoria(CustomNamedParameterJdbcTemplate customerNamedParameterJdbcTemplate) {
        this.customerNamedParameterJdbcTemplate = customerNamedParameterJdbcTemplate;
    }

    @SqlStatement (namespace = "promocion", value="listar")
    private static String sqlListar;

    @Override
    public List<DtoPromocion> listar() {
        return this.customerNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPromocion());
    }
}
