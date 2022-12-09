package service.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.constants.Xpath;
import service.pojo.User;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String name) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.REGISTRATION_NAME_FIELD));
        driver.findElement(Xpath.REGISTRATION_NAME_FIELD).clear();
        driver.findElement(Xpath.REGISTRATION_NAME_FIELD).sendKeys(name);
    }

    public void setEmailField(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.REGISTRATION_EMAIL_FIELD));
        driver.findElement(Xpath.REGISTRATION_EMAIL_FIELD).clear();
        driver.findElement(Xpath.REGISTRATION_EMAIL_FIELD).sendKeys(email);
    }

    public void setPasswordField(String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.REGISTRATION_PASSWORD_FIELD));
        driver.findElement(Xpath.REGISTRATION_PASSWORD_FIELD).clear();
        driver.findElement(Xpath.REGISTRATION_PASSWORD_FIELD).sendKeys(password);
    }

    public void registrationButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.REGISTRATION_REGISTRATION_BUTTON)).click();
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.REGISTRATION_SIGN_IN_BUTTON)).click();
    }

    public String getMessageFromMessageField() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.REGISTRATION_MESSAGE_FIELD));
        return driver.findElement(Xpath.REGISTRATION_MESSAGE_FIELD).getText();
    }

    public void registrationUser(User user){
        setNameField(user.getName());
        setEmailField(user.getEmail());
        setPasswordField(user.getPassword());
        registrationButtonClicked();
    }

}
