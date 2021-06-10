package br.com.automacaoAPI.teste;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.*;

public class GetConsultaRestricaoTeste extends BaseTeste {

    private static final String CONSULTA_RESTICAO_CPF = "/v1/restricoes/{0}";

    @Test
    public void testRestricaoCPF(){

        given()
            .when()
                .get(CONSULTA_RESTICAO_CPF,"24094592008")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .body("mensagem", is("O CPF 24094592008 tem problema"));
                //.log().all();
    }

    @Test
    public void testNaoPossuiRestricaoCPF(){

        given()
                .when()
                .get(CONSULTA_RESTICAO_CPF,"66414919004")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
                //.body("mensagem", is("Não possui restrição"));
                //.log().all();
    }

}
