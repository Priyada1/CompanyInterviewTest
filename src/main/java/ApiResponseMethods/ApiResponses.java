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

    public Response getAllUsers(String token)
    {
        RestAssured.baseURI= Constants.URI;
        RestAssured.basePath=Constants.API_V1_USERS;
        Response response = (Response) given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token)
                .log().all().when().get().then().extract();
        System.out.println(response.body().asString());
        return  response;
    }

    public Response getUserbyUsingMobileNumber(String mobile,String token)
    {
        RestAssured.baseURI= Constants.URI;
        RestAssured.basePath=Constants.API_V1_USERS+mobile;
        Response response = (Response) given().contentType(ContentType.JSON).header("Authorization", "Bearer " + token)
                .log().all().when().get().then().extract();
        System.out.println(response.body().asString());
        return  response;
    }

}
