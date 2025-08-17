package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.DataFakerBase.*;
import static io.qameta.allure.Allure.step;

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
                step("Open application form page", () ->
                        open("https://commerzbank-poland.breezy.hr/p/904b265d84c001-test-engineer-intern-document-lifecycle--talentbank-2025/apply")
                );

                step("Fill candidate personal details", () -> {
                        $("[name='cName']").setValue(fullName);
                        $("[name='cEmail']").setValue(email);
                        $("[name='cPhoneNumber']").setValue(phoneNumber);
                });

                step("Add work experience", () -> {
                        $("[name='form']").$(byText("Add Position")).click();
                        $("[ng-model='candidatePosition.company_name']").setValue(companyName);
                        $("[ng-model='candidatePosition.title']").setValue(jobTitle);
                        $("[ng-model='candidatePosition.summary']").setValue(jobSummary);
                        $(byText("Start date")).sibling(0).setValue(workStartDate);
                        $(byText("End date")).sibling(0).setValue(workEndDate);
                });

                step("Add education details", () -> {
                        $("[name='form']").$(byText("Add Education")).click();
                        $("[ng-model='candidateSchool.school_name']").setValue(universityName);
                        $("[ng-model='candidateSchool.field_of_study']").setValue(major);
                        $("[ng-model='candidateSchool.summary']").setValue(educationSummary);
                        $("[ng-model='candidateSchool.date_start']").setValue(educationStartDate);
                        $("[ng-model='candidateSchool.date_end']").setValue(educationEndDate);
                });

                step("Write candidate summary and cover letter", () -> {
                        $("[name='cSummary']").setValue(candidateSummary);
                        $("[name='cCoverLetter']").setValue(coverLetter);
                });

                step("Accept GDPR agreement", () ->
                        $("[name='gdprAgreement']").setSelected(true)
                );

                // Final submission can be enabled later if needed
                // step("Submit the application", () ->
                //    $(".apply-button").closest("button").click()
                // );
        }
}
