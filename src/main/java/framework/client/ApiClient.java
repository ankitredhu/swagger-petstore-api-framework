package framework.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class ApiClient {

    public static Response post(RequestSpecification spec, String endpoint, Object body) {
        return given()
                .spec(spec)
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response get(RequestSpecification spec, String endpoint) {
        return given()
                .spec(spec)
                .when()
                .get(endpoint);
    }

    public static Response put(RequestSpecification spec, String endpoint, Object body) {
        return given()
                .spec(spec)
                .body(body)
                .when()
                .put(endpoint);
    }

    public static Response delete(RequestSpecification spec, String endpoint) {
        return given()
                .spec(spec)
                .when()
                .delete(endpoint);
    }
}
