package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;


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
        new MainPage()
                .openPage()
                .acceptCookies()
                .shouldSeeLogo()
                .switchToEnglish()
                .goToCareersPortal()
                .shouldHaveVacancyHeader("Join Commerzbank Team");
    }
}
