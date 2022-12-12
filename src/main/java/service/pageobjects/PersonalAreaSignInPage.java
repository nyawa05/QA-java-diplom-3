package service.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.pojo.User;

public class PersonalAreaSignInPage {
    private final By registrationButton= new By.ByXPath(".//a[text()='Зарегистрироваться']");
    private final By emailField = new By.ByXPath(".//input[@name='name']");
    private final By passwordField = new By.ByXPath(".//input[@name='Пароль']");
    private final By signInButton = new By.ByXPath(".//button[text()='Войти']");
    private final By resetPassword = new By.ByXPath(".//a[text()='Восстановить пароль']");
    private final By title = new By.ByXPath(".//h2[text()='Вход']");
    private final WebDriver driver;

    public PersonalAreaSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }

    public void setPasswordField(String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setEmailField(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void resetPasswordButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(resetPassword)).click();
    }

    public void authorizationUser(User user) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        setEmailField(user.getEmail());
        setPasswordField(user.getPassword());
        signInButtonClicked();
    }

    public String getTitleValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

}
