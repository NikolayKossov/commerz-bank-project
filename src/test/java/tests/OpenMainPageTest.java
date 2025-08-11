package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenMainPageTest extends TestBase {
    @Test
    void openPageAndFindVacancy() {
            open("https://lodz.commerzbank.pl/");
            $(byText("Zaakceptuj wszystko")).click();
            $("#Commerzbank").shouldBe(Condition.visible);
            $("button").$(byText("EN")).click();
            $(byText("Apply")).click();
            switchTo().window(1);
            $("#heroBackgroundColor").shouldHave(text("Join Commerzbank Team"));
    }
}
