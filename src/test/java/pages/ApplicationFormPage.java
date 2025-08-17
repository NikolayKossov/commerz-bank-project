package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationFormPage {

    @Step("Fill personal details: {name}, {email}, {phone}")
    public ApplicationFormPage fillPersonal(String name, String email, String phone) {
        $("[name='cName']").setValue(name);
        $("[name='cEmail']").setValue(email);
        $("[name='cPhoneNumber']").setValue(phone);
        return this;
    }

    @Step("Open application form page directly")
    public ApplicationFormPage openForm() {
        open("https://commerzbank-poland.breezy.hr/p/904b265d84c001-test-engineer-intern-document-lifecycle--talentbank-2025/apply");
        return this;
    }


    @Step("Add work experience: {company} / {title}")
    public ApplicationFormPage addWorkExperience(String company, String title, String summary,
                                                 String startDate, String endDate) {
        $("[name='form']").$(byText("Add Position")).click();
        $("[ng-model='candidatePosition.company_name']").setValue(company);
        $("[ng-model='candidatePosition.title']").setValue(title);
        $("[ng-model='candidatePosition.summary']").setValue(summary);
        $(byText("Start date")).sibling(0).setValue(startDate);
        $(byText("End date")).sibling(0).setValue(endDate);
        return this;
    }

    @Step("Add education: {school} / {fieldOfStudy}")
    public ApplicationFormPage addEducation(String school, String fieldOfStudy, String summary,
                                            String startDate, String endDate) {
        $("[name='form']").$(byText("Add Education")).click();
        $("[ng-model='candidateSchool.school_name']").setValue(school);
        $("[ng-model='candidateSchool.field_of_study']").setValue(fieldOfStudy);
        $("[ng-model='candidateSchool.summary']").setValue(summary);
        $("[ng-model='candidateSchool.date_start']").setValue(startDate);
        $("[ng-model='candidateSchool.date_end']").setValue(endDate);
        return this;
    }

    @Step("Set candidate summary and cover letter")
    public ApplicationFormPage writeTexts(String candidateSummary, String coverLetter) {
        $("[name='cSummary']").setValue(candidateSummary);
        $("[name='cCoverLetter']").setValue(coverLetter);
        return this;
    }

    @Step("Accept GDPR")
    public ApplicationFormPage acceptGdpr() {
        $("[name='gdprAgreement']").setSelected(true);
        return this;
    }

    @Step("Submit application")
    public void submit() {
        // $(".apply-button").closest("button").click();
    }
}
