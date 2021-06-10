package br.com.automacaoAPI.teste;

import br.com.automacaoAPI.model.SimulaCredCPF;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PostInsereNovaSimulacaoTeste extends BaseTeste  {




    @Test
    public void testSimulationInsetExistingSimulation(){

        SimulaCredCPF simula = new SimulaCredCPF(
                "Fulano",
                "66414919004",
                "fulano@gmail.com",
                new BigDecimal(11000) ,
                3,
                true);
        given()
                .body(simula)
                .when()
                .post(EFETUA_OPERACOES_SIMULACAO)
                .then()//.log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("mensagem", is("CPF duplicado"));
    }



    @Test
    public void testSimulationInsetNewSimulation(){

        SimulaCredCPF simula = new SimulaCredCPF(
                "Jose Pai",
                "98745632122",
                "JosePai@gmail.com",
                new BigDecimal(10000) ,
                5,
                false);

        given()
                .body(simula)
            .when()
                .post(EFETUA_OPERACOES_SIMULACAO)
            .then().log().all();
                //.statusCode(HttpStatus.SC_CREATED)
               // .body("cpf", is("98745632122"));
    }

    @Test
    public void testSimulationInsetMissingAttribute(){

        SimulaCredCPF simula = new SimulaCredCPF(
                "Jose Pai",
                "JosePai@gmail.com",
                new BigDecimal(10000) ,
                5,
                false);
        given()
                .body(simula)
                .when()
                .post(EFETUA_OPERACOES_SIMULACAO)
                .then().log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("erros.cpf", is("CPF não pode ser vazio"));
    }
}
