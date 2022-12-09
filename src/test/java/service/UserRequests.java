package service;

import io.restassured.response.Response;
import service.pojo.User;
import service.pojo.UserAuth;
import service.pojo.UserAuthCredentials;

import static io.restassured.RestAssured.given;
import static service.constants.Api.*;

public class UserRequests {
    public Response createUser(User user) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .and()
                .body(user)
                .when()
                .post(API_CREATE_USER);
    }

    public void deleteUser(User user) {
        UserAuth userAuth = authUser(user)
                .getBody()
                .as(UserAuth.class);
        given()
                .spec(REQUEST_SPECIFICATION)
                .auth().oauth2(userAuth.getAccessToken())
                .delete(API_EDIT_USER);

    }

    public Response authUser(User user) {
        UserAuthCredentials userAuth = new UserAuthCredentials(user.getEmail(), user.getPassword());
        return given()
                .spec(REQUEST_SPECIFICATION)
                .and()
                .body(userAuth)
                .when()
                .post(API_LOGIN_USER);
    }
}
