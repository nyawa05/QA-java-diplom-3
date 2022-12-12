package service.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageStellarBurgers {
    private final By personalAreaButton = new By.ByXPath(".//a[@href='/account']");
    private final By signInButton = new By.ByXPath(".//button[text()='Войти в аккаунт']");
    private final By title = new By.ByXPath(".//h1[text()='Соберите бургер']");
    private final By tabBun = new By.ByXPath(".//span[text()='Булки']");
    private final By tabSous = new By.ByXPath(".//span[text()='Соусы']");
    private final By tabFilling = new By.ByXPath(".//span[text()='Начинки']");

    private final WebDriver driver;

    public MainPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }

    public void personalAreaButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(personalAreaButton)).click();
    }

    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public String getTitleValue() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public String getBunTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(tabBun));
        return driver.findElement(tabBun).getCssValue("pointer-events");
    }
    public String getSousTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(tabSous));
        return driver.findElement(tabSous).getCssValue("pointer-events");
    }
    public String getFillingTabStyle() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(tabFilling));
        return driver.findElement(tabFilling).getCssValue("pointer-events");
    }

    public void bunTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(tabBun)).click();
        Thread.sleep(2000);
    }

    public void sousTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(tabSous)).click();
        Thread.sleep(2000);
    }

    public void fillingTabClicked() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(tabFilling)).click();
        Thread.sleep(2000);
    }
}
