package com.ceiba.servicioestetico.puerto.repositorio;

import com.ceiba.servicioestetico.modelo.entidad.ServicioEstetico;

public interface RepositorioServicioEstetico {

    /**
     * Permite crear servicio estetico
     * @param servicioEstetico
     * @return el id generado
     */
    Long crear(ServicioEstetico servicioEstetico);

    /**
     * Permite validar si existe un servicio estetico con el mismo IS
     * @param idServicio identificar del servicio estetico en el salon de belleza
     * @return si existe o no
     */
    boolean existe(String idServicio);





}
