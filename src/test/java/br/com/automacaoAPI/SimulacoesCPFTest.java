package br.com.automacaoAPI;

import io.restassured.http.ContentType;
import org.junit.Test;
import util.BaseLocalHost;

import static io.restassured.RestAssured.*;

public class SimulacoesCPFTest {

    BaseLocalHost base = new BaseLocalHost();

    public void getLocalHost(){
        baseURI = base.getURI();
        port = base.getPorta();
        basePath = base.getPath();
    }

    @Test
    public void testSimulationReturnAllSimulationsExisting(){
        getLocalHost();

        given()
                .when()
                        .get("/v1/simulacoes")
                .then()
                    .statusCode(200);
    }

    @Test
    public void testSimulationInsetNewSimulation(){
        getLocalHost();
        given()
                .body("{\n" +
                        "  \"nome\": " + "Jose filho" + " ,\n" +
                        "  \"cpf\": " + "98745632122" + ",\n" +
                        "  \"email\": " + "josefilho@email.com" + ",\n" +
                        "  \"valor\": " + "5700" + ",\n" +
                        "  \"parcelas\": " + "3" + ",\n" +
                        "  \"seguro\": " + "true" + "\n" +
                        "}")
                .contentType(ContentType.JSON)
            .when()
                .post("/v1/simulacoes")
            .then()
                //.statusCode(201)
                .log().all();
    }

}
