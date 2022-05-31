package in.reqres.verifydatafromresponse;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyData {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/";
        response = given()
                .when()
                .get("users?page=2")
                .then().statusCode(200);
    }

    // 1) Extract the value page
    @Test
    public void test001() {
        //return integer
        int page = response.extract().path("page");
        System.out.println("The value of page is : " + page);
    }

    // 2) Extract the value of per page
    @Test
    public void test002() {
        //return integer
        int perPage = response.extract().path("per_page");
        System.out.println("The value of per_page is : " + perPage);
    }

    // 3) Extract the value data[1].id
    @Test
    public void test003() {
        //return integer
        int dataId = response.extract().path("data[1].id");
        System.out.println("The value of data[1].id is : " + dataId);
    }

    // 4) Extract the value of data[3].first_name
    @Test
    public void test004() {
        //return String
        String firstName = response.extract().path("data[3].first_name");
        System.out.println("The value of data[3].first_name is : " + firstName);
    }

    // 5) Extract the value of list of data
    @Test
    public void test005() {
        //return string
        List<String> listData = response.extract().path("data");
        System.out.println("The value of list of data  is : " + listData);
    }

    // 6) Extract the value of data[5].avatar
    @Test
    public void test006() {
        String avatar = response.extract().path("data[5].avatar");
        System.out.println("The value of data[5].avatar is : " + avatar);
        Assert.assertEquals("error", "https://reqres.in/img/faces/11-image.jpg",
                avatar);
    }

    // 7) Extract the value of support.url
    @Test
    public void test007() {
        String url = response.extract().path("support.url");
        System.out.println("The value of support.url is : " + url);
        Assert.assertEquals("error", "https://reqres.in/#support-heading",
                url);
    }

    // 8) Extract the value of support.text
    @Test
    public void test008() {
        String text = response.extract().path("support.text");
        System.out.println("The value of support.txt is : " + text);
        Assert.assertEquals("error", "To keep ReqRes free, contributions towards server costs are appreciated!",
                text);
    }


}
