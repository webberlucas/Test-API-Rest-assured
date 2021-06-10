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
                4,
                true);

        given()
                .pathParam("paramCpf", simula.getCpf())
                .body(simula)
            .when()
                .put(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("nome", is(simula.getNome()))
                .and()
                .body("cpf", is(simula.getCpf()))
                .and()
                .body("email", is(simula.getEmail()))
                .and()
                .body("parcelas", is(simula.getParcelas()))
                .and()
                .body("seguro", is(simula.isSeguro()));
    }

    @Test
    public void testUpdateSimulationExistingThroughCPFa(){
        SimulaCredCPF simula = new SimulaCredCPF(
                "Jose Pai",
                "99999999900",
                "JosePai@gmail.com",
                new BigDecimal(10000) ,
                2,
                true);


        given()
                .pathParam("paramCpf", simula.getCpf())
                .body(simula)
            .when()
                .put(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("mensagem", equalTo("CPF "+ simula.getCpf() +" não encontrado"));
    }

    @Test
    public void testUpdateSimulationExistingNumberParcelasUm() {
        SimulaCredCPF simula = new SimulaCredCPF(
                "Jose Pai",
                "98745632122",
                "JosePai@gmail.com",
                new BigDecimal(10000),
                1,
                true);

        given()
                .pathParam("paramCpf", simula.getCpf())
                .body(simula)
            .when()
                .put(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("erros.parcelas", is("Parcelas deve ser igual ou maior que 2"));
    }

}
