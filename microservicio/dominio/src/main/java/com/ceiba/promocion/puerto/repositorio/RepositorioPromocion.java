package com.ceiba.promocion.puerto.repositorio;

import com.ceiba.promocion.modelo.entidad.Promocion;

public interface RepositorioPromocion {

    Long crear(Promocion promocion);

    boolean existe(String idServicio, String dia);

    int contarPromocionesPorDia(String dia);



}
