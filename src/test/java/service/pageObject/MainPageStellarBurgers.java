package service.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.constants.Xpath;

public class MainPageStellarBurgers {
    private final WebDriver driver;

    public MainPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }

    public void personalAreaButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.MAIN_PAGE_PERSONAL_AREA_BUTTON_XPATH)).click();
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.MAIN_PAGE_SIGN_IN_BUTTON_XPATH)).click();
    }

    public String getTitleValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.MAIN_PAGE_TITLE));
        return driver.findElement(Xpath.MAIN_PAGE_TITLE).getText();
    }

    public String getBunTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.MAIN_PAGE_TAB_BUN));
        return driver.findElement(Xpath.MAIN_PAGE_TAB_BUN).getCssValue("pointer-events");
    }
    public String getSousTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.MAIN_PAGE_TAB_SOUS));
        return driver.findElement(Xpath.MAIN_PAGE_TAB_SOUS).getCssValue("pointer-events");
    }
    public String getFillingTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(Xpath.MAIN_PAGE_TAB_FILLING));
        return driver.findElement(Xpath.MAIN_PAGE_TAB_FILLING).getCssValue("pointer-events");
    }

    public void bunTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.MAIN_PAGE_TAB_BUN)).click();
        Thread.sleep(2000);
    }

    public void sousTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.MAIN_PAGE_TAB_SOUS)).click();
        Thread.sleep(2000);
    }

    public void fillingTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.MAIN_PAGE_TAB_FILLING)).click();
        Thread.sleep(2000);
    }
}
