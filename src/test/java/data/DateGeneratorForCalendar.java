package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static data.DataFakerBase.faker;

public class DateGeneratorForCalendar {
    public static String[] dateGenerator() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date startDate = faker.date().past(1825, TimeUnit.DAYS);
        Date endDate = faker.date().future(180, TimeUnit.DAYS, startDate);
        String startDateStr = sdf.format(startDate);
        String endDateStr = sdf.format(endDate);
        return  new String[]{startDateStr, endDateStr};
    }
}
