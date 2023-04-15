package page;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.restassured.response.ValidatableResponse;
import model.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static base.Const.Urls.*;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class Registration extends BasePage {
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2' and contains(text(), 'Личный Кабинет')]")
    private SelenideElement btnPersonalArea;
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement linkReg;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default' and contains(text(), 'Имя')]/../input")
    private SelenideElement inputName;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default' and contains(text(), 'Email')]/../input")
    private SelenideElement inputEmail;

    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement btnReg;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Войти')]")
    private SelenideElement btnAuth;

    public Registration btnPersonalAreaClick() {
        btnPersonalArea.shouldBe(Condition.enabled).click();
        return Selenide.page(Registration.class);
    }

    public Registration linkRegClick() {
        linkReg.shouldBe(Condition.enabled).click();
        return Selenide.page(Registration.class);
    }

    public Registration setInputName(String name) {
        inputName.shouldBe(Condition.enabled).setValue(name);
        return Selenide.page(Registration.class);
    }

    public Registration setInputEmail(String email) {
        inputEmail.shouldBe(Condition.enabled).setValue(email);
        return Selenide.page(Registration.class);
    }

    public Registration setInputPassword(String password) {
        inputPassword.shouldBe(Condition.enabled).setValue(password);
        return Selenide.page(Registration.class);
    }

    public Registration registration(String name, String email, String password) {
        setInputName(name);
        setInputEmail(email);
        setInputPassword(password);
        btnReg.shouldBe(Condition.enabled).click();
        return Selenide.page(Registration.class);
    }

    public Registration authorization(String email, String password) {
        open(BASE_URL + AUTH_URL);
        setInputEmail(email);
        setInputPassword(password);
        btnAuth.shouldBe(Condition.enabled).click();
        sleep(2);
        return Selenide.page(Registration.class);
    }

    public Registration sleep(int sec) {
        Selenide.sleep(sec * 1000);
        return Selenide.page(Registration.class);
    }

}
