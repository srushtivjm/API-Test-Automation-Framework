package negative;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class InvalidPostTest extends BaseTest {

    @Test
    public void getInvalidPost(){
        Response response =
                given()
                        .when()
                        .get("/posts/999999");

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 404);
    }

}
