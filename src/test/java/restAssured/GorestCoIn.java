package restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GorestCoIn {

    private static final String TOKEN = "93ed492a5bee72fd9ab9b2e2f96b4fa9c0956d59f38a40f99701bb871e2b7fe3";
    private static int postId;
    private static RequestSpecification requestSpec;

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
    void postRequest() {
        String requestBody = "{\"user_id\": 8364711, \"title\" : \"New post\", \"body\" : \"This is a test post\"}";

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

        System.out.println("Response Body: " + response.asString());

        postId = response.jsonPath().getInt("id");
        System.out.println("Created Post ID: " + postId);
    }

    @Test(priority = 2)
    void patchRequest() {
        String patchBody = "{ \"title\" : \"Updated test post\"}";

        given().
                spec(requestSpec).
                body(patchBody).
                when().
                patch("/public/v2/posts/" + postId).
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo("Updated test post"));
    }

    @Test(priority = 3)
    void getRequest() {
        given().
                spec(requestSpec).
                when().
                get("/public/v2/posts/" + postId).
                then().
                assertThat().
                statusCode(200).
                body("title", equalTo("Updated test post"));
    }
}
