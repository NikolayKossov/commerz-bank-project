package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ApplicationFormPage;
import static data.DataFakerBase.*;


@Epic("Job Application")
@Feature("Application Form")
@Story("Fill in the candidate details and experience")
@Owner("Nikolay Kossov")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Fill out and validate Commerzbank job application form")
@Tag("simple")
public class FillTheFormTest extends TestBase {

        @Test
        void fillTest() {
                new ApplicationFormPage()
                        .fillPersonal(fullName, email, phoneNumber)
                        .addWorkExperience(companyName, jobTitle, jobSummary, workStartDate, workEndDate)
                        .addEducation(universityName, major, educationSummary, educationStartDate, educationEndDate)
                        .writeTexts(candidateSummary, coverLetter)
                        .acceptGdpr();
        }
}
