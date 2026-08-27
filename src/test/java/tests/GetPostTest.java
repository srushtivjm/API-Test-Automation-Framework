package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import endpoints.Routes;
import utils.ApiValidator;


public class GetPostTest extends BaseTest {
    @Test
    public void getPost(){
        Response response =
                         given()
                        .when()
                        .get(Routes.GET_POST);
        System.out.println("Status Code:" + response.getStatusCode());
        System.out.println(response.asPrettyString());

        ApiValidator.validateStatusCode(response, 200);
    }
}
