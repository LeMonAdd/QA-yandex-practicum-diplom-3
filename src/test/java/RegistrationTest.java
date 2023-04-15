import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import page.Registration;

import static base.Const.Urls.BASE_URL;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class NewTestblabla {
    Registration registration;

    @Before
    public void setup() {

    }

    @Test
    public void test2() {
        registration = open(BASE_URL, Registration.class)
                .btnRegClick();
    }
}
