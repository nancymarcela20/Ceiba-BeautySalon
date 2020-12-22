package com.ceiba.servicioestetico.controlador;

import com.ceiba.servicioestetico.consulta.ManejadorListarServicioEstetico;
import com.ceiba.servicioestetico.modelo.dto.DtoServicioestetico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestController
@RequestMapping("/beauty-services")
@Api(tags = {"Controlador consulta de servicios esteticos"})
public class ConsultaControladorServicioEstetico {

    private final ManejadorListarServicioEstetico manejadorListarServicioEstetico;

    public ConsultaControladorServicioEstetico(ManejadorListarServicioEstetico manejadorListarServicioEstetico){
        this.manejadorListarServicioEstetico = manejadorListarServicioEstetico;
    }

    @GetMapping
    @ApiOperation("Listar servicios esteticos")
    public List<DtoServicioestetico> listar(){
        return this.manejadorListarServicioEstetico.ejecutar();
    }
}
