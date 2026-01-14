package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteTest {

    @Test
    void testDelete() {
        given()
                .queryParam("user", "one")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("args.user", equalTo("one"));
    }
}

