package tests.petstore;

import framework.base.BaseTest;
import framework.client.ApiClient;
import framework.pojo.Pet;
import framework.utils.LoggerUtil;
import io.restassured.response.Response;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import framework.utils.JsonDataProvider;

@Test(dataProvider = "addPetData", dataProviderClass = JsonDataProvider.class)
public class AddPetTest extends BaseTest {
	
	Logger log = LoggerUtil.getLogger(AddPetTest.class);

    @Test
    public void testAddNewPet(Pet newPet) {

        log.info("Sending POST request to add pet: " + newPet.getName());
        Response response = ApiClient.post(requestSpec, "/pet", newPet);

        response.then().log().all();
        
        response.then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("schemas/pet-schema.json"));

        log.info("Validating response");
        Assert.assertEquals(response.getStatusCode(), 200, "Pet was not created");
    }
}
