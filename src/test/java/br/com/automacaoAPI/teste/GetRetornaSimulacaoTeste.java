package br.com.automacaoAPI.teste;

import br.com.automacaoAPI.model.SimulaCredCPF;
import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


import java.math.BigDecimal;

import static io.restassured.RestAssured.*;

public class GetRetornaSimulacaoTeste extends BaseTeste {


    // SINTAX RODAR TEST LINHA COMANDO MAVEN "mvn test -Dtest=SimulacoesCPFTeste#test* test"

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
                .pathParam("paramCpf", "66414919004")
            .when()
                .get(EFETUA_OPERACOES_SIMULACAO +  "/{paramCpf}")
            .then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("cpf", is("66414919004"));
    }

    @Test
    public void testSimulationWithCPFNotExisting(){

        given()
                .pathParam("paramCpf", "66414919999")
            .when()
                .get(EFETUA_OPERACOES_SIMULACAO + "/{paramCpf}")
            .then().log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("mensagem", is("CPF 66414919999 não encontrado"));
    }


}
