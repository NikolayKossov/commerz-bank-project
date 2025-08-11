package data;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static data.DateGeneratorForCalendar.dateGenerator;

public class DataFakerBase {
    static Faker faker = new Faker(new Locale("pl"));
    public static String fullName = faker.name().fullName();
    public static String email = faker.internet().emailAddress();
    public static String phoneNumber = faker.phoneNumber().phoneNumber();
    public static String companyName = faker.company().name();
    public static String jobTitle = faker.job().title();
    public static String jobSummary = faker.lorem().paragraph();
    public static String universityName = faker.university().name();
    public static String major = faker.educator().course();
    public static String educationSummary = faker.lorem().paragraph();
    public static String candidateSummary = faker.lorem().paragraph();
    public static String coverLetter = faker.lorem().paragraph();
    public static String[] workDates = dateGenerator();
    public static String workStartDate = workDates[0];
    public static String workEndDate = workDates[1];
    public static String[] educationDates = dateGenerator();
    public static String educationStartDate = educationDates[0];
    public static String educationEndDate = educationDates[1];
}
