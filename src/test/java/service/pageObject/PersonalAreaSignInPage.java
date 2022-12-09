package service.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.constants.Xpath;
import service.pojo.User;

public class PersonalAreaSignInPage {
    private final WebDriver driver;

    public PersonalAreaSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrationButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_REGISTRATION_BUTTON_XPATH)).click();
    }

    public void setPasswordField(String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_SIGN_IN_PASSWORD_FIELD));
        driver.findElement(Xpath.PERSONAL_AREA_SIGN_IN_PASSWORD_FIELD).clear();
        driver.findElement(Xpath.PERSONAL_AREA_SIGN_IN_PASSWORD_FIELD).sendKeys(password);
    }

    public void setEmailField(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_SIGN_IN_EMAIL_FIELD));
        driver.findElement(Xpath.PERSONAL_AREA_SIGN_IN_EMAIL_FIELD).clear();
        driver.findElement(Xpath.PERSONAL_AREA_SIGN_IN_EMAIL_FIELD).sendKeys(email);
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_SIGN_IN_BUTTON)).click();
    }

    public void resetPasswordButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_SIGN_IN_RESET_PASSWORD)).click();
    }

    public void authorizationUser(User user) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_SIGN_IN_BUTTON));
        setEmailField(user.getEmail());
        setPasswordField(user.getPassword());
        signInButtonClicked();
    }

    public String getTitleValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.PERSONAL_AREA_SIGN_IN_TITLE));
        return driver.findElement(Xpath.PERSONAL_AREA_SIGN_IN_TITLE).getText();
    }

}
