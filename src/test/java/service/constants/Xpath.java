package service.constants;

import org.openqa.selenium.By;

public class Xpath {
    public static final By MAIN_PAGE_PERSONAL_AREA_BUTTON_XPATH = new By.ByXPath("//*[@id=\"root\"]/div/header/nav/a");
    public static final By MAIN_PAGE_SIGN_IN_BUTTON_XPATH = new By.ByXPath(".//button[text()='Войти в аккаунт']");
    public static final By MAIN_PAGE_TITLE = new By.ByXPath("//*[@id=\"root\"]/div/main/section[1]/h1");
    public static final By MAIN_PAGE_TAB_BUN = new By.ByXPath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    public static final By MAIN_PAGE_TAB_SOUS = new By.ByXPath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    public static final By MAIN_PAGE_TAB_FILLING = new By.ByXPath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");
    public static final By PERSONAL_AREA_REGISTRATION_BUTTON_XPATH = new By.ByXPath(".//a[text()='Зарегистрироваться']");
    public static final By PERSONAL_AREA_SIGN_IN_EMAIL_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    public static final By PERSONAL_AREA_SIGN_IN_PASSWORD_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    public static final By PERSONAL_AREA_SIGN_IN_BUTTON = new By.ByXPath(".//button[text()='Войти']");
    public static final By PERSONAL_AREA_SIGN_IN_RESET_PASSWORD = new By.ByXPath(".//a[text()='Восстановить пароль']");
    public static final By PERSONAL_AREA_SIGN_IN_TITLE = new By.ByXPath("//*[@id=\"root\"]/div/main/div/h2");
    public static final By PERSONAL_AREA_PROFILE_NAME_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[1]/div/div/input");
    public static final By PERSONAL_AREA_PROFILE_EMAIL_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[2]/div/div/input");
    public static final By PERSONAL_AREA_PROFILE_LOG_OUT_BUTTON = new By.ByXPath(".//button[text()='Выход']");
    public static final By PERSONAL_AREA_PROFILE_MESSAGE = new By.ByXPath("//*[@id=\"root\"]/div/main/div/nav/p");
    public static final By PERSONAL_AREA_PROFILE_LOGO = new By.ByXPath("//*[@id=\"root\"]/div/header/nav/div");
    public static final By REGISTRATION_NAME_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    public static final By REGISTRATION_EMAIL_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    public static final By REGISTRATION_PASSWORD_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    public static final By REGISTRATION_MESSAGE_FIELD = new By.ByXPath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    public static final By REGISTRATION_REGISTRATION_BUTTON = new By.ByXPath(".//button[text()='Зарегистрироваться']");
    public static final By REGISTRATION_SIGN_IN_BUTTON = new By.ByXPath(".//a[text()='Войти']");
    public static final By RESET_PASSWORD_SIGN_IN_BUTTON = new By.ByXPath(".//a[text()='Войти']");
}
