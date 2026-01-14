package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutTest {

    @Test
    void testPut() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"city\":\"London\",\"country\":\"UK\"}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data.city", equalTo("London"))
                .body("data.country", equalTo("UK"));
    }
}
