package tests.petstore;

import framework.base.BaseTest;
import framework.pojo.Pet;
import framework.utils.PayloadBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddPetTest extends BaseTest {

    @Test
    public void testAddNewPet() {
        Pet newPet = PayloadBuilder.buildPetPayload(12345, "Tommy", "available");

        Response response = given()
                .spec(requestSpec)
                .body(newPet)
                .when()
                .post("/pet");

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "Pet was not created");
        Assert.assertEquals(response.jsonPath().getString("name"), "Tommy");
    }
}
