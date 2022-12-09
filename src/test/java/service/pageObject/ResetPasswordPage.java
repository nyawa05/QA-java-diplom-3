package service.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.constants.Xpath;

public class ResetPasswordPage {
    private final WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void signInButtonClicked() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Xpath.RESET_PASSWORD_SIGN_IN_BUTTON)).click();
    }
}
