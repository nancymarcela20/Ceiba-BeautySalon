package com.ceiba.servicioestetico.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;
import com.ceiba.servicioestetico.puerto.repositorio.RepositorioServicioEstetico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioEsteticoEnMemoria implements RepositorioServicioEstetico {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "servicioEstetico", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "servicioEstetico", value = "existe")
    private static String sqlExiste;

    public RepositorioServicioEsteticoEnMemoria(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(ServicioEstetico servicioEstetico) {
        return customNamedParameterJdbcTemplate.crear(servicioEstetico, sqlCrear);
    }

    @Override
    public boolean existe(String idServicio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idServicio", idServicio);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }
}
