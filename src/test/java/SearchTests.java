import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"), Duration.ofSeconds(35));
    }
    @Test
    void successfulSearchMosRu() {
        open("https://www.google.com/");
        $("[name=q]").setValue("mos ru").pressEnter();
        $("[id=search]").shouldHave(text("Официальный сайт Мэра Москвы"), Duration.ofSeconds(35));
    }
    @Test
    void successfulSearchMosRuViaYandex() {
        open("https://ya.ru/");
        $("[name=text]").setValue("mos ru").pressEnter();
        $("[id=search-result]").shouldHave(text("Официальный сайт Мэра Москвы"));
    }
}
