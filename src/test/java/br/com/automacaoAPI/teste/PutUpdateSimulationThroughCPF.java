package br.com.automacaoAPI.teste;

import br.com.automacaoAPI.model.SimulaCredCPF;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.Matcher.*;
import org.junit.Test;

import java.math.BigDecimal;

public class PutUpdateSimulationThroughCPF extends BaseTeste {


    @Test
    public void testUpdateSimulationExistingThroughCPF(){
        SimulaCredCPF simula = new SimulaCredCPF(
                "Jose Pai",
                "98745632122",
                "JosePai@gmail.com",
                new BigDecimal(10000) ,
                5,
                false);


        given()
                .pathParam("paramCpf", simula.getCpf())
                .body(simula)
            .when()
                .put(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then()
                .log().all();
               // .statusCode(HttpStatus.SC_BAD_REQUEST)
               // .body("mensagem", is("CPF duplicado"));
    }

}
