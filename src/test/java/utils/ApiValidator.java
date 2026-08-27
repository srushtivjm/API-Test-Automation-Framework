package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiValidator {
    public static void validateStatusCode(Response response, int expectedStatuseCode){
        Assert.assertEquals(response.getStatusCode(),expectedStatuseCode);
    }

    public static void validateStringField(Response response, String field, String expectedValue){
        Assert.assertEquals(
                response.jsonPath().getString(field),
                expectedValue
        );
    }

    public static void validateIntField(Response response, String field, int expectedValue){
        Assert.assertEquals(
                response.jsonPath().getInt(field),
                expectedValue
        );
    }
}
