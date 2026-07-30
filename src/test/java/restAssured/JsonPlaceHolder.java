package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceHolder {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void getCommentsForPost() {

        Response response =
                given().
                        when().
                        get("/posts/1/comments").
                        then().
                        assertThat().
                        statusCode(200).
                        body("size()", greaterThan(0)). // Проверяем, что массив комментариев не пустой
                        body("[0].postId", equalTo(1)). // Проверяем, что первый комментарий относится к указанному посту
                        body("[0].id", notNullValue()). // Проверяем, что у первого комментария есть ID
                        body("[0].body", equalTo("laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium")).
                        extract().response();

        System.out.println("Response Body: " + response.asString());
    }
}
