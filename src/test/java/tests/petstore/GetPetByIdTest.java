package tests.petstore;

import framework.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPetByIdTest extends BaseTest {

    @Test
    public void testGetPetById() {
        int petId = 1;

        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/pet/" + petId);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "Pet not found or request failed");
    }
}
