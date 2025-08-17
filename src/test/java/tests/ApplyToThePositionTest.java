package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("Job Application")
@Feature("Application form")
@Story("Open application form from vacancy page")
@Owner("Nikolay Kossov")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Open application form from vacancy page")
@Tag("simple")
public class ApplyToThePositionTest extends TestBase {

    @Test
    void applyTest() {
        step("Open vacancy page", () ->
                open("https://commerzbank-poland.breezy.hr/p/904b265d84c001-test-engineer-intern-document-lifecycle--talentbank-2025")
        );

        step("Click 'Apply To Position' button", () ->
                $(".sidebar-container").$(byText("Apply To Position")).click()
        );
    }
}
