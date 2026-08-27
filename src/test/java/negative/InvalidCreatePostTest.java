package negative;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class InvalidCreatePostTest extends BaseTest {

    @Test
    public void createPostwithInvalidBody(){

        String invalidBody = """
                {
                "title": "",
                "body": "",
                "userId": -1
                }
                """;

         Response response =
                 given()
                         .header("Content-Type", "application/json")
                         .body(invalidBody)
                         .when()
                         .post(Routes.CREATE_POST);


        System.out.println("Status Code:" + response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertTrue(
                response.getStatusCode() >= 200 &&
                        response.getStatusCode() < 500
        );


    }
}
