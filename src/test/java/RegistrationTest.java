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
import service.pageobjects.MainPageStellarBurgers;
import service.pageobjects.PersonalAreaProfilePage;
import service.pageobjects.PersonalAreaSignInPage;
import service.pageobjects.RegistrationPage;
import service.pojo.User;

@RunWith(Parameterized.class)
public class RegistrationTest {
    private final String browser;
    ChromeOptions options = new ChromeOptions();
    WebDriver driver;
    User user;
    UserRequests userRequests = new UserRequests();

    public RegistrationTest(String browser) {
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
    @DisplayName("Check Registration by using Personal Area button")
    public void registrationFromPersonalAreaPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_LINK);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.registrationButtonClicked();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = UserGenerator.randomUser();
        registrationPage.registrationUser(user);
        personalAreaSignInPage.authorizationUser(user);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Registration by using Sign In button")
    public void registrationFromSignInPositive() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_LINK);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.signInButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.registrationButtonClicked();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = UserGenerator.randomUser();
        registrationPage.registrationUser(user);
        personalAreaSignInPage.authorizationUser(user);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actualName = personalAreaProfilePage.getNameFieldValue();
        String actualEmail = personalAreaProfilePage.getEmailFieldValue();
        Assert.assertEquals(user.getName(), actualName);
        Assert.assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("Check Error Message when using less then 6 letters in Password")
    public void registrationFromPersonalAreaNegative() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_LINK);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        personalAreaSignInPage.registrationButtonClicked();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = UserGenerator.randomWrongPasswordUser();
        registrationPage.registrationUser(user);
        String actual = registrationPage.getMessageFromMessageField();
        Assert.assertEquals("Некорректный пароль", actual);
    }

    @After
    public void teardown() {
        this.driver.quit();
        if (user.getPassword().length() > 5) {
            userRequests.deleteUser(user);
        }
    }
}
