package tests;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ApiValidator;
import utils.JsonReader;

import static io.restassured.RestAssured.*;

public class UpdatePostTest extends BaseTest {
    @Test
    public void updatePost() throws Exception {
        String requestBody =
                JsonReader.readJsonFile(
                        "src/test/resources/updatePostData.json");

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .put(Routes.UPDATE_POST);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        ApiValidator.validateStatusCode(response, 200);

        ApiValidator.validateIntField(response, "id", 1);

        ApiValidator.validateStringField(response, "title", "Updated REST Assured Post");

        ApiValidator.validateStringField(response, "body", "This post was updated using PUT");

        ApiValidator.validateIntField(response, "userId", 1);
    }
}

