package com.ceiba.promocion.adaptador.mapper;

import com.ceiba.promocion.modelo.dto.DtoPromocion;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoPromocion implements RowMapper<DtoPromocion> {

    @Override
    public DtoPromocion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String idServicio= rs.getString("id_servicio");
        Float porcentaje= rs.getFloat("porcentaje");
        String dia  = rs.getString("dia");

        return new DtoPromocion(id, idServicio, porcentaje, dia);
    }
}
