package com.ceiba.servicioestetico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicioestetico.adaptador.mapper.MapeoServicioEstetico;
import com.ceiba.servicioestetico.modelo.dto.DtoServicioestetico;
import com.ceiba.servicioestetico.puerto.dao.DaoServicioEstetico;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioEsteticoEnMemoria implements DaoServicioEstetico {

    private final CustomNamedParameterJdbcTemplate customerNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicioEstetico", value="listar")
    private static String sqlListar;

    public DaoServicioEsteticoEnMemoria(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customerNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioestetico> listar() {
        return this.customerNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicioEstetico());
    }
}
