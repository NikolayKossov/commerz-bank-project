package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("Job Application")
@Feature("Vacancies")
@Story("Find 'Test Engineer Intern' vacancy")
@Owner("Nikolay Kossov")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Open vacancy page 'Test Engineer Intern'")
@Tag("simple")
public class FindTestEngineerVacancyTest extends TestBase {

    @Test
    void findVacancy() {
        step("Open career page", () ->
                open("https://commerzbank-poland.breezy.hr/")
        );

        step("Click on 'Test Engineer Intern'", () ->
                $$(".positions-container li").findBy(text("Test Engineer Intern")).click()
        );

        step("Verify vacancy page is opened", () ->
                $("#heroBackgroundColor").shouldHave(text("Test Engineer Intern"))
        );

    }
}
