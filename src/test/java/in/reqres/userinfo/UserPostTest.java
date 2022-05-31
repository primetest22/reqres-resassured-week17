package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    //Create user
    @Test
    public void createUser() {

        UserPojo userPojo = new UserPojo();

        userPojo.setFirst_name("Mahendra");
        userPojo.setLast_name("Dhoni");
        userPojo.setEmail("mahendradhoni@gmail.com");
        userPojo.setAvatar("https://reqres.in/img/faces/1-image.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

       //Login successful
       @Test
       public void loginSuccessful(){

        UserPojo userPojo = new UserPojo();

        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");

           Response response = given()
                   .header("Content-Type","application/json")
                   .body(userPojo)
                   .when()
                   .post("login");
           response.then().statusCode(200);
           response.prettyPrint();

       }


}
