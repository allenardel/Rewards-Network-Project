package githubTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test6 {

    // verifying name, id, status code and status line with using sort and pagination

    @Test
    public void verifyName6() {

        // Specify base URI

        RestAssured.baseURI = "https://api.github.com";

        // Specify data format

        given().header("Accept", "application/json");


        /* Response object
           2 page and each page has 9 element

         */


        Response response = when().get("/search/repositories?q=autor_name&page=2&per_page=9&sort=updated&order=asc");

        // Status Code verification ( should return status code 200)

        int statusCode = response.statusCode();
        Assert.assertEquals(response.statusCode(), 200);

        // Status Line verification ( should return HTTP/1.1 200 OK)

        String statusLine = response.statusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        // Name verification  (1. name is = "p" )

        String name = response.path("items.name[0]");
        Assert.assertEquals(name, "p");

        // id Verification (1. id is =108482539)

        int id = response.path("items.id[0]");
        Assert.assertEquals(id, 108482539);

           }
    }