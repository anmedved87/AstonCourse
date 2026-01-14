package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostTest {

    @Test
    void testPost() {

        String json = "{\"name\":\"Anastasiya\",\"surname\":\"Medvedeva\"}";

        given()
                .header("Content-Type", "application/json")
                .body(json)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("Anastasiya"))
                .body("data.surname", equalTo("Medvedeva"));
    }
}
