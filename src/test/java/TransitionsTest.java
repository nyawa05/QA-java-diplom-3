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
import service.pojo.User;

@RunWith(Parameterized.class)
public class TransitionsTest {
    private final String browser;
    ChromeOptions options = new ChromeOptions();
    WebDriver driver;
    User user;
    UserRequests userRequests = new UserRequests();

    public TransitionsTest(String browser) {
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
    @DisplayName("Check Transition from Main Page to Personal Area Page")
    public void transitionToPersonalArea() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_SIGN_IN_LINK);
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        String actual = personalAreaProfilePage.getMessageValue();
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", actual);
    }

    @Test
    @DisplayName("Check Transition from Personal Area to Main Page bz using logo")
    public void transitionToMainPage() {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_SIGN_IN_LINK);
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.personalAreaButtonClicked();
        PersonalAreaProfilePage personalAreaProfilePage = new PersonalAreaProfilePage(driver);
        personalAreaProfilePage.logoClicked();
        String actual = mainPageStellarBurgers.getTitleValue();
        Assert.assertEquals("Соберите бургер", actual);
    }

    @Test
    @DisplayName("Check Transition from tabs in Main Page")
    public void transitionTabs() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Links.STELLAR_BURGERS_SIGN_IN_LINK);
        PersonalAreaSignInPage personalAreaSignInPage = new PersonalAreaSignInPage(driver);
        user = UserGenerator.randomUser();
        userRequests.createUser(user);
        personalAreaSignInPage.authorizationUser(user);
        MainPageStellarBurgers mainPageStellarBurgers = new MainPageStellarBurgers(driver);
        mainPageStellarBurgers.sousTabClicked();
        String bunTabActualStyle = mainPageStellarBurgers.getBunTabStyle();
        String sousTabActualStyle = mainPageStellarBurgers.getSousTabStyle();
        String fillingTabActualStyle = mainPageStellarBurgers.getFillingTabStyle();
        Assert.assertEquals("auto", bunTabActualStyle);
        Assert.assertEquals("none", sousTabActualStyle);
        Assert.assertEquals("auto", fillingTabActualStyle);
        mainPageStellarBurgers.fillingTabClicked();
        bunTabActualStyle = mainPageStellarBurgers.getBunTabStyle();
        sousTabActualStyle = mainPageStellarBurgers.getSousTabStyle();
        fillingTabActualStyle = mainPageStellarBurgers.getFillingTabStyle();
        Assert.assertEquals("auto", bunTabActualStyle);
        Assert.assertEquals("auto", sousTabActualStyle);
        Assert.assertEquals("none", fillingTabActualStyle);
        mainPageStellarBurgers.bunTabClicked();
        bunTabActualStyle = mainPageStellarBurgers.getBunTabStyle();
        sousTabActualStyle = mainPageStellarBurgers.getSousTabStyle();
        fillingTabActualStyle = mainPageStellarBurgers.getFillingTabStyle();
        Assert.assertEquals("none", bunTabActualStyle);
        Assert.assertEquals("auto", sousTabActualStyle);
        Assert.assertEquals("auto", fillingTabActualStyle);
    }

    @After
    public void teardown() {
        this.driver.quit();
        userRequests.deleteUser(user);
    }
}
