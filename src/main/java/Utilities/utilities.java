package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class utilities {

    public static void assertApiResponseEmpty(Response response) {

        Assert.assertEquals(response.statusCode(), 200, "Api response is sending Null");
        Assert.assertNotNull(response.body().asString(), "Api response is sending Null");
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNull(jsonPathEvaluator.get("errorCode"));
    }
}
