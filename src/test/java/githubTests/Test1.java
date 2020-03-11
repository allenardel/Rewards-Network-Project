package githubTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Test1 {

     // verifying name, id, status code and status line with using sort and pagination

     @Test
     public void verifyName1() {

          // Specify base URI

          RestAssured.baseURI = "https://api.github.com";

          // Specify data format

          given().header("Accept", "application/json");

          /*
          Response object
          pagination 1 page and each page has 13 element

         */

          Response response = when().get("/search/repositories?q=autor_name&page=1&per_page=13&sort=stars&order=desc");

          // Status Code verification

          int statusCode = response.statusCode();
          Assert.assertEquals(response.statusCode(), 200);

          // Status Line verification (should return HTTP/1.1 200 OK)

          String statusLine = response.statusLine();
          Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

          // Name verification  (first name is = "github_url" )

          String name = response.path("items.name[0]");
          Assert.assertEquals(name, "github_url");

          // id verification (first id is =24922317)

          int id = response.path("items.id[0]");
          Assert.assertEquals(id, 24922317);

     }
}





