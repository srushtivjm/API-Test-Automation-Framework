package tests;



import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import endpoints.Routes;
import utils.ApiValidator;
import utils.JsonReader;



public class CreatePostTest extends BaseTest{
    @Test
    public void createPost() throws Exception{

        String requestBody =
                JsonReader.readJsonFile("src/test/resources/postData.json");


        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all()
                        .when()
                        .post(Routes.CREATE_POST);
        response.then()
                .log()
                .all();

        System.out.println(response.asPrettyString());

        ApiValidator.validateStatusCode(response, 201);

        ApiValidator.validateStringField(response, "title", "Learning REST Assured");

        ApiValidator.validateStringField(response, "body", "My First API Test");

        ApiValidator.validateIntField(response, "userId", 1);
    }
}
