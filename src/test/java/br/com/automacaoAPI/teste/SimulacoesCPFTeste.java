package br.com.automacaoAPI.teste;

import br.com.automacaoAPI.model.SimulaCredCPF;
import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;


import java.math.BigDecimal;

import static io.restassured.RestAssured.*;

public class SimulacoesCPFTeste extends BaseTeste {


    private static final String EFETUA_OPERACOES_SIMULACAO = "/v1/simulacoes";


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
    public void testSimulationInsetExistingSimulation(){

        SimulaCredCPF simula = new SimulaCredCPF("Fulano",
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

        SimulaCredCPF simula = new SimulaCredCPF("Jose Pai",
                                                    "98745632122",
                                                    "JosePai@gmail.com",
                                                    new BigDecimal(10000) ,
                                                    5,
                                                    false);
        given()
                .body(simula)
                .when()
                .post(EFETUA_OPERACOES_SIMULACAO)
                .then()//.log().all();
                .statusCode(HttpStatus.SC_CREATED)
                .body("cpf", is("98745632122"));
    }


}
