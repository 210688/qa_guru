
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        Configuration.pageLoadStrategy="eager";
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://ru.selenide.org"));
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
