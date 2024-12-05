package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    // Create board api ye istek atma metodu
    public static Response sendPostRequest(String endpoint, String name, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", name)
                .header("Content-Type", "application/json")
                .when()
                .post(endpoint);
    }

    // delete board api ye istek atma metodu
    public static Response sendDeleteBoardRequest(String endpoint, String boardId, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete(endpoint + "/" + boardId);
    }

    // delete card api ye istek atma metodu
    public static Response sendDeleteCardRequest(String endpoint, String cardId, String key, String token){
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete(endpoint + "/" + cardId);

    }

    // board a ait list id leri listeleyen api ye istek atma metodu
    public static Response getListRequest(String endpoint, String boardId, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get(endpoint + "/" + boardId + "/lists");
    }

    // create card api ye istek atma metodu
    public static Response sendPostRequestCard(String endpoint, String idList, String key, String token){
        return given()
                .queryParam("idList", idList)
                .queryParam("key", key)
                .queryParam("token", token)
                .header("Content-Type", "application/json")
                .when()
                .post(endpoint);
    }

    // card update api ye istek atma metodu
    public static Response sendPutRequestCard(String endpoint, String cardId, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .header("Content-Type", "application/json")
                .when()
                .put(endpoint + "/" + cardId);
    }
}
