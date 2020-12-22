package com.ceiba.servicioestetico.adaptador.mapper;

import com.ceiba.servicioestetico.modelo.dto.DtoServicioestetico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoServicioEstetico implements RowMapper<DtoServicioestetico>{

    @Override
    public DtoServicioestetico mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String idServicio= rs.getString("id_servicio");
        String nombre= rs.getString("nombre");
        String tipoServicio = rs.getString("tipo_servicio");
        int costo = rs.getInt("costo");
        boolean estadoServicio= rs.getBoolean("estado_servicio");

        return new DtoServicioestetico(
                id, idServicio, nombre, tipoServicio, costo, estadoServicio
        );
    }
}
