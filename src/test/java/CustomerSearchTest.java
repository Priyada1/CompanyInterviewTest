import ApiResponseMethods.ApiResponses;
import Utilities.Constants;
import Utilities.utilities;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomerSearchTest {

    JsonObject jsonObject;
    ApiResponses apiResponses = new ApiResponses();
    Gson gson= new Gson();

    @BeforeClass
    public void initTestData() throws FileNotFoundException
    {
        FileReader file= new FileReader(".\\src\\main\\resources\\CustomerSearchTest.json");
        JsonParser jsonParser = new JsonParser();
        jsonObject = (JsonObject)jsonParser.parse(file);
    }

    @Test
    public void CustomerSearchTest()
    {
        Response authenticateRespnose = apiResponses.postAuthToken(jsonObject.get("bodyParams"));
        utilities.assertApiResponseEmpty(authenticateRespnose);
        String token = authenticateRespnose.jsonPath().get("token");
        Response userRespnose = apiResponses.getAllUsers(token);
        Assert.assertEquals(userRespnose.statusCode(), 200, "Api response is sending Null");
        Assert.assertNotNull(userRespnose.body().asString(), "Api response is sending Null");
    }

    @Test
    public void CustomerSearchTestByUsingMobileNumber()
    {
        Response authenticateRespnose = apiResponses.postAuthToken(jsonObject.get("bodyParams"));
        utilities.assertApiResponseEmpty(authenticateRespnose);
        String token = authenticateRespnose.jsonPath().get("token");

        Response userRespnoseByUsingMobilenumber = apiResponses.getUserbyUsingMobileNumber(Constants.MOBILE,token);
        Assert.assertEquals(userRespnoseByUsingMobilenumber.statusCode(), 200, "Api response is sending Null");
        Assert.assertNotNull(userRespnoseByUsingMobilenumber.body().asString(), "Api response is sending Null");
    }

    @Test
    public void CustomerSearchTestByUsingInvalidMobileNumber()
    {
        Response authenticateRespnose = apiResponses.postAuthToken(jsonObject.get("bodyParams"));
        utilities.assertApiResponseEmpty(authenticateRespnose);
        String token = authenticateRespnose.jsonPath().get("token");

        Response userRespnoseByUsingMobilenumber = apiResponses.getUserbyUsingMobileNumber(Constants.INVALIDMOBILE,token);
        Assert.assertEquals(userRespnoseByUsingMobilenumber.statusCode(), 400, "Api Status code is not Matching");
        Assert.assertNotNull(userRespnoseByUsingMobilenumber.body().asString(), "Api response is sending Null");
    }


}
