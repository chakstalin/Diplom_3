package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.UserPOJO;

import static io.restassured.RestAssured.given;

public class UserClient {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String REGISTER_PATH = BASE_URL + "/api/auth/register";
    private static final String LOGIN_PATH = BASE_URL + "/api/auth/login";
    private static final String USER_PATH = BASE_URL + "/api/auth/user";

    public UserClient() {
        RestAssured.baseURI = BASE_URL;
    }

    @Step("Регистрация пользователя")
    public static Response registerUser(UserPOJO user) {
        return given()
                .contentType("application/json")
                .body(user)
                .post(REGISTER_PATH);
    }

    @Step("Удаление пользователя с токеном")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .delete(USER_PATH);
    }

    @Step("Получить токен пользователя")
    public static String getUserToken(UserPOJO loginUser) {
        Response response = loginUser(loginUser);
        if (response.getStatusCode() == 200) {
        String accessToken = response.jsonPath().get("accessToken");
        return accessToken.replace("Bearer ", "");
        } else { return null; }
    }

    @Step("Авторизация пользователя")
    public static Response loginUser(UserPOJO user) {
        return given()
                .contentType("application/json")
                .body(user)
                .post(LOGIN_PATH);
    }
}
