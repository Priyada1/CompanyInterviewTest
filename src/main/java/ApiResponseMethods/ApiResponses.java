package ApiResponseMethods;

import Utilities.Constants;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiResponses {


public Response postAuthToken(Object bodyParams)
{
    RestAssured.baseURI= Constants.URI;
    RestAssured.basePath=Constants.AUTHENTICATE;

    Response response=(Response) given().contentType(ContentType.JSON).body(bodyParams).log()
            .all().when().post().then().extract();

    System.out.println(response.body().asString());

    return  response;
}

}
