package tests.petstore;

import framework.base.BaseTest;
import framework.pojo.Pet;
import framework.utils.LoggerUtil;
import framework.utils.PayloadBuilder;
import io.restassured.response.Response;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;

public class AddPetTest extends BaseTest {
	
	Logger log = LoggerUtil.getLogger(AddPetTest.class);

    @Test
    public void testAddNewPet() {
        Pet newPet = PayloadBuilder.buildPetPayload(12345, "Tommy", "available");

        log.info("Sending POST request to add new pet");
        Response response = given()
                .spec(requestSpec)
                .body(newPet)
                .when()
                .post("/pet");

        response.then().log().all();
        
        response.then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("schemas/pet-schema.json"));

        log.info("Validating response");
        Assert.assertEquals(response.getStatusCode(), 200, "Pet was not created");
        Assert.assertEquals(response.jsonPath().getString("name"), "Tommy");
    }
}
