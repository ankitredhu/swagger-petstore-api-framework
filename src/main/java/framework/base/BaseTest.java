package framework.base;

import framework.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected RequestSpecification requestSpec;

    public BaseTest() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.uri"))
                .setContentType("application/json")
                .build();
    }
}
