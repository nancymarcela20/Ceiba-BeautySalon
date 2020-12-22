package com.ceiba.promocion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.promocion.comando.ComandoPromocion;
import com.ceiba.promocion.comando.manejador.ManejadorCrearPromocion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("/beauty-service-promotions")
@Api(tags = {"Controlador comando de las promociones de servicios"})
public class ComandoControladorPromocion {

    private final ManejadorCrearPromocion manejadorCrearPromocion;

    @Autowired
    public ComandoControladorPromocion(ManejadorCrearPromocion manejadorCrearPromocion) {
        this.manejadorCrearPromocion = manejadorCrearPromocion;
    }

    @PostMapping
    @ApiOperation("Crear una promocion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPromocion comandoPromocion){
        return manejadorCrearPromocion.ejecutar(comandoPromocion);
    }
}
