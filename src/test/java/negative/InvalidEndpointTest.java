package negative;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InvalidEndpointTest extends BaseTest {

    @Test
    public void getInvalidEndpoint(){

        Response response =
                given()
                        .when()
                        .get("/invalid-endpoint");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 404);
    }
}
