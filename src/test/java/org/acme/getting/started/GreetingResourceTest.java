package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    @Test
    public void testGreetingEndpoint() {
        final var name = UUID.randomUUID().toString();
        given()
            .pathParam("name", name)
            .when().get("/hello/greeting/{name}")
            .then()
                .statusCode(200)
                .body(is("Hello, " + name + "!"));
    }

}