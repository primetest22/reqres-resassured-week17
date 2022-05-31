package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {


    //Get all user information
    @Test
    public void getAllUserInfo() {

        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    //Get single user information
    @Test
    public void getSingleUserInfo() {

        Response response = given()
                .when()
                .get("12");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
