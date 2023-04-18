import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
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

import static base.Const.Urls.BASE_URL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class ConstructorTest {
    private boolean isYandex = false;
    private int index;
    private String expectedName;
    public ConstructorTest(int index, String expectedName) {
        this.index = index;
        this.expectedName = expectedName;
    }

    public void yandexBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Legalbet/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Legalbet/Desktop/qa_java/Diplom/diplom-3/src/main/resources/yandexdriver.exe");

        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }

    @Parameterized.Parameters(name = "Список ингредиентов. Тестовые данные: {0} {1} {2} {3} {4} {5} {6} {7} {8} {9} {10} {11} {12} {13} {14} {15}")
    public static Object[][] getText() {
        return new Object[][] {
                {0, "Флюоресцентная булка R2-D3"},
                {1, "Краторная булка N-200i"},
                {2, "Соус Spicy-X"},
                {3, "Соус фирменный Space Sauce"},
                {4,"Соус традиционный галактический"},
                {5, "Соус с шипами Антарианского плоскоходца"},
                {6, "Мясо бессмертных моллюсков Protostomia"},
                {7, "Говяжий метеорит (отбивная)"},
                {8, "Биокотлета из марсианской Магнолии"},
                {9, "Филе Люминесцентного тетраодонтимформа"},
                {10,"Хрустящие минеральные кольца"},
                {11, "Плоды Фалленианского дерева"},
                {12, "Кристаллы марсианских альфа-сахаридов"},
                {13, "Мини-салат Экзо-Плантаго"},
                {14, "Сыр с астероидной плесенью"},
        };
    }

    @Before
    public void setUp() {
        if(isYandex) {
            yandexBrowser();
        }
    }

    @Test
    @DisplayName("Раздел «Конструктор». Проверь, что работают переходы к разделам: «Булки», «Соусы»,«Начинки».")
    public void checkThatSectionTransitionsWorkTest() {
        open(BASE_URL);
        ElementsCollection el = $$x("//p[@class='BurgerIngredient_ingredient__text__yp3dH']");
        String text = el.get(index).shouldBe(visible).hover().text();
        Assert.assertEquals(expectedName, text);
    }

    @After
    public void clear() {
        if (isYandex) {
            closeWebDriver();
        }
    }
}
