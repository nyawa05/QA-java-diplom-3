package service.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.constants.Xpath;

public class PersonalAreaProfilePage {
    private final WebDriver driver;

    public PersonalAreaProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFieldValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.PERSONAL_AREA_PROFILE_NAME_FIELD));
        return driver.findElement(Xpath.PERSONAL_AREA_PROFILE_NAME_FIELD).getAttribute("value");
    }

    public String getEmailFieldValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.PERSONAL_AREA_PROFILE_EMAIL_FIELD));
        return driver.findElement(Xpath.PERSONAL_AREA_PROFILE_EMAIL_FIELD).getAttribute("value");
    }

    public void logOutButtonClicked() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_PROFILE_LOG_OUT_BUTTON)).click();
    }

    public String getMessageValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.PERSONAL_AREA_PROFILE_MESSAGE));
        return driver.findElement(Xpath.PERSONAL_AREA_PROFILE_MESSAGE).getText();
    }
    public void logoClicked() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(Xpath.PERSONAL_AREA_PROFILE_LOGO)).click();
    }
}
