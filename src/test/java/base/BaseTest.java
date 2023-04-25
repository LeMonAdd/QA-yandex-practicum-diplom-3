package base;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static base.Const.Urls.BASE_URL;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    public String accessToken;
    public BasePage basePage;

    public Faker faker;
    public User user;

    public boolean isYandex = true;

    public void yandexBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Legalbet/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Legalbet/Desktop/qa_java/Diplom/diplom-3/src/main/resources/yandexdriver.exe");

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        basePage = new BasePage();
        faker = new Faker();
        user = new User(
                faker.name().username(),
                faker.name().firstName() + faker.number().digits(4) + "@yandex.ru",
                faker.number().digits(10));

        if(isYandex) {
            yandexBrowser();
        }
    }

    @After
    public void clear() {
        if (accessToken != null) {
            ValidatableResponse delete = basePage.deleteUser(accessToken);
            delete.statusCode(202);
            boolean success = delete.extract().path("success");
            Assert.assertTrue(success);
        }

        if (isYandex) {
            closeWebDriver();
        }
    }
}
