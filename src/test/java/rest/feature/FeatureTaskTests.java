package rest.feature;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FeatureTaskTests {

    /*
    * Необходимо написать тест, который забирает все данные по endpoint: /posts/1
    * и сверяет данные с ожидаемым результатом.
    * В качестве ожидаемоего результата выступают следующие данные:
    *    userId = 1
    *    id = 1
    *    title = sunt aut facere repellat provident occaecati excepturi optio reprehenderit
    *    body = quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto
    *
    * Задания:
    *    - Тест должен запускаться в любой день недели, кроме дня, когда происходит собеседование (если сегодня вторник, то отключаем вторник)
    *    - Тест должен быть помечен как smoke
    *
    * Данный тест можно писать под любой тестовый фреймворк: JUnit, TestNG ...
    * (при использовании отличного инструмента от JUnit потребуется подключение данного инструмента к проекту)
    */

    @Test
    @Tag("regress")
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
    @Tag("regress")
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
    @Tag("regress")
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
