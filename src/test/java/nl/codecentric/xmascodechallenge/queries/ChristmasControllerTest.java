package nl.codecentric.xmascodechallenge.queries;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ChristmasControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/xmas/vibesAtCCNL")
          .then()
             .statusCode(200);
    }

}