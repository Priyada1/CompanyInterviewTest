import ApiResponseMethods.ApiResponses;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
        String token = authenticateRespnose.jsonPath().get("token");
        System.out.println(token);

    }


}
