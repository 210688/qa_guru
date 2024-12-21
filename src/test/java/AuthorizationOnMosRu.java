import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationOnMosRu {

    @Test
    void userAuthorizationOnMosRu()  {
        open("https://www.mos.ru/");
        $(byText("Войти")).click();
        $(".page-title").shouldHave(text("Вход"));
        $("[name='login']").setValue("79449440798");
        $("[name='password']").setValue("434ПВОЫ\"!ffggghh");
        $(".form-login__submit").click();
        $("#mos-dropdown-user").shouldHave(text("Олег Гордиенко"), Duration.ofSeconds(7));
        $("#mos-dropdown-user").shouldHave(visible, Duration.ofSeconds(5)).click();
        $(".User_mobileLogout__3PVhu").shouldBe(visible, Duration.ofSeconds(5)).click();
    }
}
