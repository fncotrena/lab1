package com.sistemaDistribuido.Banco;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class Test1 {

 private String urlBase="http://localhost:8080";

    @Test
    public void Saldo() {

       RestAssured
                .given()
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .get("/cuentas/saldo")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
               .and().body("saldo", Matchers.equalTo( 2000));

    }
    @Test
    public void Extraccion() {
        RestAssured
                .given()
                .request().param("id",1,"saldo",2000)
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .post("/cuentas/depositar")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().body("saldo", Matchers.equalTo( 0));
    }

}