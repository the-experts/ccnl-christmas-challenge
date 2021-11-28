package nl.codecentric.xmascodechallenge.queries;

import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
@Slf4j
public class ChristmasControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/xmas/vibesAtCCNL")
                .then()
                .statusCode(200);
    }

    @Test
    public void testEncodeDecodeIsCorrect() {
        String expected = "Dit is een test!";

        byte[] encoded = given()
                .when()
                .body(expected).post("/xmas/encode")
                .then()
                .extract().asByteArray();

        String outputBody = given().when()
                .body(encoded).header("Content-Type", "image/png").post("/xmas/decode")
                .then()
                .extract()
                .body()
                .asString();

        assertThat(outputBody).isEqualTo(expected);
    }

}