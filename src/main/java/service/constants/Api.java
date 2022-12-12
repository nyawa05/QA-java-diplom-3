package service.constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Api {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String API_CREATE_USER = "/api/auth/register";
    public static final String API_EDIT_USER = "/api/auth/user";
    public static final String API_LOGIN_USER = "/api/auth/login";
    public static RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json")
            .setBaseUri(BASE_URL)
            .build();
}
