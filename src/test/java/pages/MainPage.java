package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String URL = "https://lodz.commerzbank.pl/";

    private final SelenideElement
            logo = $("#Commerzbank");

    @Step("Open Commerzbank Lodz homepage")
    public MainPage openPage() {
        open(URL);
        return this;
    }

    @Step("Accept cookies")
    public MainPage acceptCookies() {
        $(byText("Zaakceptuj wszystko")).click();
        return this;
    }

    @Step("Ensure logo is visible")
    public MainPage shouldSeeLogo() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Switch language to English")
    public MainPage switchToEnglish() {
        $("button").$(byText("EN")).click();
        return this;
    }

    @Step("Open 'Apply' and switch to the new tab (Careers portal)")
    public CareersPage goToCareersPortal() {
        $(byText("Apply")).click();
        switchTo().window(1);
        return new CareersPage();
    }
}
