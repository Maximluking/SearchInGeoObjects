package Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateForServices {
    private DateFormat simpleDateFormat;
    private Calendar calendar;


    public DateForServices(DateFormat simpleDateFormate) {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
        calendar = Calendar.getInstance();
    }

    public String nextDay(String tempDate) throws ParseException {
        calendar.setTime(simpleDateFormat.parse(tempDate));
        calendar.add(Calendar.DATE, 1);
        return simpleDateFormat.format(calendar.getTime());
    }


}
