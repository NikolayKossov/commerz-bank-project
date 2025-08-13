package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("simple")
public class FindTestEngineerVacancyTest {
    @Test
    void findVacancy() {
        open("https://commerzbank-poland.breezy.hr/");
        $$(".positions-container li").findBy(text("Test Engineer Intern")).click();
        $("#heroBackgroundColor").shouldHave(text("Test Engineer Intern"));
        String finalUrl = WebDriverRunner.url();
        System.out.println("Final URL: " + finalUrl);

        // Если нужно добавить в Allure
        io.qameta.allure.Allure.addAttachment("Open url", finalUrl);

    }
}
