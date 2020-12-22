package com.ceiba.servicioestetico.builder;

import com.ceiba.ComandoRespuesta;

import java.io.Serializable;

public class ObjetoRespuestaComandoCrear extends ComandoRespuesta<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    public ObjetoRespuestaComandoCrear() {
        super(null);
    }

    public ObjetoRespuestaComandoCrear(Long valor) {
        super(valor);
    }

    public Long getValor() {return (Long) super.getValor();}

}
