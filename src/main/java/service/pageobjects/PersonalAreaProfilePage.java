package service.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAreaProfilePage {

    private final By nameField = new By.ByXPath(".//input[@name='Name']");
    private final By emailField= new By.ByXPath(".//input[@name='name' and @type='text']");
    private final By logOutButton = new By.ByXPath(".//button[text()='Выход']");
    private final By message = new By.ByXPath(".//p[@class='Account_text__fZAIn text text_type_main-default']");
    private final By logo = new By.ByXPath(".//div[@class='AppHeader_header__logo__2D0X2']");

    private final WebDriver driver;

    public PersonalAreaProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFieldValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        return driver.findElement(nameField).getAttribute("value");
    }

    public String getEmailFieldValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return driver.findElement(emailField).getAttribute("value");
    }

    public void logOutButtonClicked() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
    }

    public String getMessageValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(message));
        return driver.findElement(message).getText();
    }
    public void logoClicked() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(logo)).click();
    }
}
