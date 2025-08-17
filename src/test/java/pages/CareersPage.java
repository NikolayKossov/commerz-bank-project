package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    private static final String HOME_URL = "https://commerzbank-poland.breezy.hr/";

    private final SelenideElement
            header = $("#heroBackgroundColor");

    @Step("Open careers home")
    public CareersPage openHome() {
        open(HOME_URL);
        return this;
    }

    @Step("Open vacancy by title: {title}")
    public CareersPage openVacancy(String title) {
        $$(".positions-container li").findBy(text(title)).click();
        return this;
    }

    @Step("Verify vacancy header contains: {expected}")
    public CareersPage shouldHaveVacancyHeader(String expected) {
        header.shouldHave(text(expected));
        return this;
    }

    @Step("Click 'Apply To Position' on vacancy page")
    public ApplicationFormPage clickApplyToPosition() {
        $(".sidebar-container").shouldHave(text("Apply To Position"))
                .click();
        return new ApplicationFormPage();
    }
}
