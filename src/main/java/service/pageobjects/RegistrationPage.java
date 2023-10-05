package service.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.pojo.User;

public class RegistrationPage {
    private final By nameField = new By.ByXPath(".//fieldset[1]//input");
    private final By emailField = new By.ByXPath(".//fieldset[2]//input");
    private final By passwordField = new By.ByXPath(".//fieldset[3]//input");
    private final By messageField = new By.ByXPath(".//p[@class='input__error text_type_main-default']");
    private final By registrationButton = new By.ByXPath(".//button[text()='Зарегистрироваться']");
    private final By signInButton = new By.ByXPath(".//a[text()='Войти']");
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void registrationButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(registrationButton)).click();
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public String getMessageFromMessageField() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(messageField));
        return driver.findElement(messageField).getText();
    }

    public void registrationUser(User user){
        setNameField(user.getName());
        setEmailField(user.getEmail());
        setPasswordField(user.getPassword());
        registrationButtonClicked();
    }

}
