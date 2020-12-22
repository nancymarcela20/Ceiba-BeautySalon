package com.ceiba.servicioestetico.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.servicioestetico.builder.ObjetoRespuestaComandoCrear;
import com.ceiba.servicioestetico.comando.ComandoServicioEstetico;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.ceiba.servicioestetico.builder.ComandoServicioEsteticoTestBuilder.aComandoServicioEstetico;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorServicioEstetico.class)
public class ComandoControladorServicioEsteticoTest {

    private static final String ENDPOINT = "/beauty-services";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void validarCreacionServicioEstetico() throws Exception{
        //Arrange
        ComandoServicioEstetico comandoServicioEstetico = aComandoServicioEstetico().conIdServicio("TT02")
                .conNombre("Rayos")
                .conTipoServicio("TINTE")
                .conCosto(150000)
                .conEstadoServicio(true)
                .build();
        //Act
        MvcResult result = mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoServicioEstetico)))
                //Assert
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();

        ObjetoRespuestaComandoCrear comandoRespuesta = objectMapper.readValue(
                json, ObjetoRespuestaComandoCrear.class);
        //Assert.assertNotNull(comandoRepuesta.getValor());
        //Assert.assertThat(comandoRespuesta.getValor(), Matchers.greaterThan(0L));
        boolean isOK = comandoRespuesta.getValor() != null && ((Long)comandoRespuesta.getValor())>0;
        Assert.assertTrue(isOK);


    }

}
