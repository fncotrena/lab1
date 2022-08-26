package com.sistemaDistribuido.Banco;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("saldo", 2000);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .post("/cuentas/extraer")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().body("saldo", Matchers.equalTo( 0));
    }

    @Test
    public void deposito() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("saldo", 3000);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .post("/cuentas/depositar")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().body("saldo", Matchers.equalTo( 3000));
    }


    @Test
    public void interes() {
        Map<String, Object> map = new HashMap<>();
        map.put("interes", 10.0);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(map)
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .post("/cuentas/interes")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().body("saldo", Matchers.equalTo( 2700));
    }


    @Test
    public void balance() {
        RestAssured
                .given()
                .baseUri(urlBase)
                .and()
                .queryParam("format", "json")
                .when()
                .get("/transacciones/balance")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and().body(Matchers.equalTo(4000.0));
    }

}