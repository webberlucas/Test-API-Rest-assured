package br.com.automacaoAPI.teste;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.*;
import org.junit.BeforeClass;
import static io.restassured.RestAssured.*;

public class BaseTeste {

    protected static final String EFETUA_OPERACOES_SIMULACAO = "/v1/simulacoes";

    @BeforeClass
    public static void setup(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "/api";

        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

    }
}
