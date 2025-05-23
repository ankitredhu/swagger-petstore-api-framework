package tests.petstore;

import framework.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import framework.utils.LoggerUtil;

import static io.restassured.RestAssured.given;

public class AddPetNegativeTest extends BaseTest {
    Logger log = LoggerUtil.getLogger(AddPetNegativeTest.class);

    @Test
    public void testAddPetWithInvalidPayload() {
        log.info("Sending invalid POST request (missing body)");

        Response response = given()
                .spec(requestSpec)
                .body("{}") // Empty JSON
                .when()
                .post("/pet");

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 400, "Expected Bad Request");
        
    }
}
