package com.ceiba.promocion.controlador;

import com.ceiba.promocion.consulta.ManejadorListarPromociones;
import com.ceiba.promocion.modelo.dto.DtoPromocion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@RestControllerAdvice
@RequestMapping("/beauty-service-promotions")
@Api(tags = {"Controlador consulta de promociones"})
public class ConsultaControladorPromocion {

    private final ManejadorListarPromociones manejadorListarPromociones;

    public ConsultaControladorPromocion(ManejadorListarPromociones manejadorListarPromociones) {
        this.manejadorListarPromociones = manejadorListarPromociones;
    }

    @GetMapping
    @ApiOperation("Listar promociones")
    public List<DtoPromocion> listar(){
        return this.manejadorListarPromociones.ejecutar();
    }
}
