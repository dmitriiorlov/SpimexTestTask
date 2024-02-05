package rest.feature;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FeatureTask {

    @Test
    public void getFirstPostTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/1");
        Assertions.assertEquals(200, response.getStatusCode());
        ResponseBody responseBody = response.getBody();
        Assertions.assertEquals("""
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto"
                }""", responseBody.asString());
    }

    @Test
    public void allFields() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/1");
        Assertions.assertEquals(200, response.getStatusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer userId = jsonPathEvaluator.get("userId");
        Integer id = jsonPathEvaluator.get("id");
        String Title = jsonPathEvaluator.get("title");
        String Body = jsonPathEvaluator.get("body");
        Assertions.assertEquals(1, userId);
        Assertions.assertEquals(1, id);
        Assertions.assertEquals(Title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        Assertions.assertEquals(Body, "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }

    @Test
    void user1Posts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts");
        Assertions.assertEquals(200, response.getStatusCode());
        Post[] posts = response.getBody().as(Post[].class);
        ArrayList<Post> user1Posts = new ArrayList<>();
        for (var post : posts) {
            if (post.userId == 1) {
                user1Posts.add(post);
            }
        }
        Assertions.assertEquals(10, user1Posts.size());
    }

    @Test
    void user5Posts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts");
        Assertions.assertEquals(200, response.getStatusCode());
        Post[] posts = response.getBody().as(Post[].class);
        ArrayList<Post> user1Posts = new ArrayList<>();
        for (var post : posts) {
            if (post.userId == 5) {
                user1Posts.add(post);
            }
        }
        Assertions.assertEquals(10, user1Posts.size());
    }

    @Test
    public void testFirstTitle() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/1");
        Assertions.assertEquals(200, response.getStatusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        String Title = jsonPathEvaluator.get("title");
        boolean isTrue = false;
        if (Title == "sunt aut facere repellat provident occaecati excepturi optio reprehenderit") {
            isTrue = true;
        }
        Assertions.assertTrue(isTrue);
    }
}
