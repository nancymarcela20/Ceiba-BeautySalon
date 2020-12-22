package com.ceiba.promocion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.promocion.modelo.entidad.Promocion;
import com.ceiba.promocion.puerto.repositorio.RepositorioPromocion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPromocionEnMemoria implements RepositorioPromocion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "promocion", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "promocion", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "promocion", value = "contarPromocionesPorDia")
    private static String sqlContarPromocionesPorDia;

    public RepositorioPromocionEnMemoria(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Promocion promocion) {
        return customNamedParameterJdbcTemplate.crear(promocion, sqlCrear);
    }

    @Override
    public boolean existe(String idServicio, String dia) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idServicio", idServicio);
        paramSource.addValue("dia", dia);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public int contarPromocionesPorDia(String dia) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("dia", dia);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContarPromocionesPorDia, paramSource, Integer.class);
    }
}
