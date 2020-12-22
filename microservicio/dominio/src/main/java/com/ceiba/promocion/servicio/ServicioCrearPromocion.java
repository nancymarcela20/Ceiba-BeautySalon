package com.ceiba.promocion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.promocion.modelo.entidad.Promocion;
import com.ceiba.promocion.puerto.repositorio.RepositorioPromocion;

public class ServicioCrearPromocion {

    private static final String LA_PROMOCION_YA_EXISTE_EN_EL_SISTEMA="La promoción ya existe en el sistema";
    private static final String NO_SE_PUEDEN_CREAR_MAS_PROMOCIONES_PARA_EL_DIA_INDICADO="No se pueden crear más promociones para el día indicado";
    private static final String EL_SERVICIO_NO_PUEDE_TENER_PROMOCIONES_EL_VIERNES="El servicio no puede tener promociones los viernes";
    private static final String EL_MAXIMO_PERMITIDO_PROMOCIONES_POR_DIA_ES="El máximo de promociones permitidas es: ";
    private static final String EL_PORCENTAJE_ES_MAYOR_AL_PERMITIDO="El porcentaje es mayor al permitido";
    private static final String VIERNES="VIERNES";
    private static final float MAXIMO_PORCENTAJE_PERMITIDO=50;
    private static final int CANTIDAD_PROMOCIONES_POR_DIA=3;

    private final RepositorioPromocion repositorioPromocion;

    public ServicioCrearPromocion(RepositorioPromocion repositorioPromocion){
        this.repositorioPromocion=repositorioPromocion;
    }

    public Long ejecutar(Promocion promocion){
        validarExistenciaPrevia(promocion);
        validarPromocionViernes(promocion);
        validarPorcentaje(promocion.getPorcentaje());
        validarCantidadDePromocionesPorDia(promocion.getDia());

        return this.repositorioPromocion.crear(promocion);
    }

    private void validarCantidadDePromocionesPorDia(String dia) {

        int promocionesMismoDia = this.repositorioPromocion.contarPromocionesPorDia(dia);

        if(promocionesMismoDia==CANTIDAD_PROMOCIONES_POR_DIA){
            throw new ExcepcionValorInvalido(EL_MAXIMO_PERMITIDO_PROMOCIONES_POR_DIA_ES + CANTIDAD_PROMOCIONES_POR_DIA);
        }

    }

    private void validarPorcentaje(float porcentaje) {
        if(porcentaje>MAXIMO_PORCENTAJE_PERMITIDO){
            throw new ExcepcionValorInvalido(EL_PORCENTAJE_ES_MAYOR_AL_PERMITIDO);
        }
    }

    private void validarPromocionViernes(Promocion promocion) {

        String idServicio=promocion.getIdServicio();

        char[] vIdServicio= idServicio.toCharArray();

        int contador= 0;

        char dato;

        for(int i=0;i<vIdServicio.length;i++){
            dato=vIdServicio[i];
            if(Character.isDigit(dato)){
                contador+=Character.getNumericValue(dato);
            }
        }

        if(contador%2==0 && promocion.getDia().equals(VIERNES)){
            throw  new ExcepcionValorInvalido(EL_SERVICIO_NO_PUEDE_TENER_PROMOCIONES_EL_VIERNES);
        }
    }

    private void validarExistenciaPrevia(Promocion promocion) {

        boolean existe = this.repositorioPromocion.existe(promocion.getIdServicio(), promocion.getDia());

        if(existe){
            throw new ExcepcionDuplicidad(LA_PROMOCION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
