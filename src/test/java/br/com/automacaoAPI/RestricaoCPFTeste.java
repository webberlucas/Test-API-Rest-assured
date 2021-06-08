package br.com.automacaoAPI;

import io.restassured.http.ContentType;
import org.junit.Test;
import util.BaseLocalHost;

import static io.restassured.RestAssured.*;

public class RestricaoCPFTeste {

    BaseLocalHost base = new BaseLocalHost();

    @Test
    public void testRestricaoCPF(){
        baseURI = base.getURI();
        port = base.getPorta();
        basePath = base.getPath();

        given()
            .when()
                .get("/v1/restricoes/{0}","24094592008")
            .then()
                .log().all();
    }

}
