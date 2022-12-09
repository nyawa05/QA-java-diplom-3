import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import service.UserGenerator;
import service.UserRequests;
import service.constants.Links;
import service.pageObject.*;
import service.pojo.User;

@RunWith(Parameterized.class)
public class LogInTest {
    private final String browser;
    ChromeOptions options = new ChromeOptions();
    WebDriver driver;
    User user;
    UserRequests userRequests = new UserRequests();

    public LogInTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void preSet() {
        if (browser == "Yandex") {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriverYandex\\bin\\chromedriver.exe");
            options.setBinary("C:\\Users\\TvTensina\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\bin\\chromedriver.exe");
            options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        }
        driver = new ChromeDriver(options);
    }

    @Parameterized.Parameters
    public static Object[][] getBrowserData() {
        return new Object[][] {
                {"Yandex"},
                {"Chrome"}
        };
    }

    @Test
    @DisplayName("Check Log In bu using Personal Area button")
    public void logInFromPersonalAreaPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_LINK);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        personalAreaSignInPage.authorizationUser(user);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Log In by using Sign In button in Main Page")
    public void logInFromSignInPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_LINK);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.signInButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        personalAreaSignInPage.authorizationUser(user);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Log From Registration Page")
    public void logInFromRegistrationPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_REGISTER_LINK);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        registrationPage.signInButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Log From Reset Password Page")
    public void logInFromResetPasswordPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_RESET_PASSWORD_LINK);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.signInButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Log Out")
    public void logOutTestPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_SIGN_IN_LINK);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        personalAreaProfilePage.logOutButtonClicked();
        String actual = personalAreaSignInPage.getTitleValue();
        Assert.assertEquals("Вход", actual);
    }

    @After
    public void teardown() {
        this.driver.quit();
        userRequests.deleteUser(user);
    }
}
