package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("Job Application")
@Feature("Main Page")
@Story("Navigate from Commerzbank main page to careers portal")
@Owner("Nikolay Kossov")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Open Commerzbank main page and switch to job application site")
@Tag("simple")
public class OpenMainPageTest extends TestBase {

    @Test
    void openPageAndFindVacancy() {
        step("Open Commerzbank Lodz homepage", () ->
                open("https://lodz.commerzbank.pl/")
        );

        step("Accept cookies", () ->
                $(byText("Zaakceptuj wszystko")).click()
        );

        step("Check that Commerzbank logo is visible", () ->
                $("#Commerzbank").shouldBe(Condition.visible)
        );

        step("Switch site language to English", () ->
                $("button").$(byText("EN")).click()
        );

        step("Click on 'Apply' and switch to new tab", () -> {
            $(byText("Apply")).click();
            switchTo().window(1);
        });

        step("Verify the careers portal page opened", () ->
                $("#heroBackgroundColor").shouldHave(text("Join Commerzbank Team"))
        );
    }
}
