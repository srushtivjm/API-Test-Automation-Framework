package tests;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePostTest extends BaseTest {
    @Test
    public void deletePost(){
        Response response =
                given()
                        .when()
                        .delete(Routes.DELETE_POST);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

    }

}
