import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationOnMosRuTest {
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void userAuthorizationOnMosRu()  {
        open("https://www.mos.ru/");
        $("#mos-header-title").shouldBe(visible);
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
        $("[name='login']").setValue("79449440798");
        $("[name='password']").setValue("434ПВОЫ\"!ffggghh");
        $(".form-login__submit").click();
        $("#mos-dropdown-user").shouldHave(text("Олег Гордиенко"), Duration.ofSeconds(7));
        $("#mos-dropdown-user").shouldHave(visible, Duration.ofSeconds(5)).hover();
        $(".User_logout__Eg_Es").click();
        $(byText("Войти")).shouldHave(text("Войти"));
    }
    @Test
    void openingTheUserRegistrationPage() {
        open("https://www.mos.ru/");
        $("#mos-header-title").shouldBe(visible);
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
        $("#regEnter").click();
        $(".page-title").shouldHave(text("Регистрация"));
    }
    @Test
    void openingPasswordRecoveryPage() {
        open("https://www.mos.ru/");
        $("#mos-header-title").shouldBe(visible);
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
        $("#recoveryEnter").click();
        $(".page-title").shouldHave(text("Восстановление пароля"));
    }
    @Test
    void authorizationWithEmptyFields() {
        open("https://www.mos.ru/");
        $("#mos-header-title").shouldBe(visible);
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
        $(".form-login__submit").click();
        $(".mForm").shouldHave(text("Введите пароль"));
    }
}
