package br.com.automacaoAPI.teste;

import br.com.automacaoAPI.model.SimulaCredCPF;
import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


import java.math.BigDecimal;

import static io.restassured.RestAssured.*;

public class GetRetornaSimulacaoTeste extends BaseTeste {


    // SINTAX RODAR TEST LINHA COMANDO MAVEN "mvn test -Dtest=SimulacoesCPFTeste#test* test"

    static String cpf = "66414919004";
    static String cpfNotExisting = "66414919999";

    @Test
    public void testSimulationReturnAllSimulationsExisting(){

        given()
                .when()
                        .get(EFETUA_OPERACOES_SIMULACAO)
                .then().log().all()
                    .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testSimulationReturnSimulationsWithCPF(){


        given()
                .pathParam("paramCpf", cpf)
            .when()
                .get(EFETUA_OPERACOES_SIMULACAO +  "/{paramCpf}")
            .then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("cpf", is(cpf));
    }

    @Test
    public void testSimulationWithCPFNotExisting(){

        given()
                .pathParam("paramCpf", cpfNotExisting)
            .when()
                .get(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then().log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("mensagem", is("CPF " + cpfNotExisting + " não encontrado"));
    }


}
