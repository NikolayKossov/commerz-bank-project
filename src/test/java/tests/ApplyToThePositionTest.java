package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CareersPage;



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
        new CareersPage()
                .openVacancy("Test Engineer Intern")
                .clickApplyToPosition();
    }
}
