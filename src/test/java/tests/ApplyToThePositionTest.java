package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("simple")
public class ApplyToThePositionTest {
    @Test
    void applyTest() {
        open("https://commerzbank-poland.breezy.hr/p/904b265d84c001-test-engineer-intern-document-lifecycle--talentbank-2025");
        $(".sidebar-container").$(byText("Откликнуться на вакансию")).click();
    }
}
