package tests;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import static io.restassured.RestAssured.*;

public class DataDrivenPostTest extends BaseTest {

    @DataProvider(name = "postData")
   public Object[][] postData() throws Exception{

        return JsonReader.readTestData(
                "src/test/resources/postTestData.json"
        );
    }

    @Test(dataProvider = "postData")
    public void creatPostWithMultipleData (String title,
                                           String body,
                                           int userId){

        String requestBody = """
                {
                "title": "%s",
                "body": "%s",
                "userId": %d
                }  
                """.formatted(title, body, userId);

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .post(Routes.CREATE_POST);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(),201);



        Assert.assertEquals(
                response.jsonPath().getString("title"),
                title
        );

        Assert.assertEquals(
                response.jsonPath().getString("body"),
                body
        );

        Assert.assertEquals(
                response.jsonPath().getInt("userId"),
                userId
        );


    }
}
