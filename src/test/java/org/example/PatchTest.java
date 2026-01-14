package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchTest {

    @Test
    void testPatch() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"company\":\"Aston\"}")

                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("data.company", equalTo("Aston"));
    }
}

