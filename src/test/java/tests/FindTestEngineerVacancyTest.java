package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CareersPage;


@Epic("Job Application")
@Feature("Vacancies")
@Story("Find 'Test Engineer Intern' vacancy")
@Owner("Nikolay Kossov")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Open vacancy page 'Test Engineer Intern'")
@Tag("simple")
public class FindTestEngineerVacancyTest extends TestBase {

    @Test
    void findVacancyTest() {
        new CareersPage()
                .openHome()
                .openVacancy("Test Engineer Intern")
                .shouldHaveVacancyHeader("Test Engineer Intern");

    }
}
