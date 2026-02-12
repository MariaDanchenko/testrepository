package restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {

    private static RequestSpecification requestSpec;
    private static final String TOKEN = "93ed492a5bee72fd9ab9b2e2f96b4fa9c0956d59f38a40f99701bb871e2b7fe3";

    private int userId;
    private int postId;

    @BeforeClass
    void initParam() {
        // Установка базового URL
        RestAssured.baseURI = "https://gorest.co.in/";

        requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test(priority = 1)
    void getUsers() {
        Response response =
                given().
                        spec(requestSpec).
                        when().
                        get("/public/v2/users").
                        then().
                        assertThat().
                        statusCode(200).
                        extract().response();

        userId = response.jsonPath().getInt("[0].id");

        System.out.println("First user ID: " + userId);
    }

    @Test(priority = 2)
    void postRequest() {
        int userId = 8364712;
        String requestBody = String.format(
                "{ \"user_id\": %d, \"title\": \"New Post\", \"body\": \"Test body\" }",
                userId);

        Response response =
                given().
                        spec(requestSpec).
                        body(requestBody).
                        when().
                        post("/public/v2/posts").
                        then().
                        assertThat().
                        statusCode(201).
                        extract().response();

        postId = response.jsonPath().getInt("id");

        System.out.println("Created post ID: " + postId);
    }

    @Test(priority = 3)
    void getUserPosts() {

        Response response =
                given().
                        spec(requestSpec).
                        when().
                        get("/public/v2/users/" + userId + "/posts").
                        then().
                        statusCode(200).
                        extract().response();

        List<Integer> postIds = response.jsonPath().getList("id");

        Assert.assertTrue(postIds.contains(postId));

        System.out.println("Post successfully verified");
    }

    @Test(priority = 4)
    void deletePost() {

        given().
                spec(requestSpec).
                when().
                delete("/public/v2/posts/" + postId).
                then().
                statusCode(204);

        System.out.println("Post deleted successfully");
    }

    @Test(priority = 5)
    void verifyPostDeleted() {

        Response response =
                given().
                        spec(requestSpec).
                        when().
                        get("/public/v2/users/" + userId + "/posts").
                        then().
                        statusCode(200).
                        extract().response();

        List<Integer> postIds = response.jsonPath().getList("id");

        Assert.assertFalse(postIds.contains(postId));

        System.out.println("Post deleted");
    }
}
