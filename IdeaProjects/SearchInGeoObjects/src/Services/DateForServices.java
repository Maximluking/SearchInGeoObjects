package Services;

import DAO.TrackingPointDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateForServices {
    private DateFormat simpleDateFormat;
    private Calendar calendar;


    public DateForServices() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
        calendar = Calendar.getInstance();
    }

    public boolean ifEndOfSearch(String date) throws ParseException {
        if ((simpleDateFormat.parse(date)).getTime() >= (simpleDateFormat.parse(TrackingPointDAO.endPoint)).getTime()) {
            return false;
        } else return true;
    }

    public String nextDay(String date) throws ParseException {
        calendar.setTime(simpleDateFormat.parse(date));
        calendar.add(Calendar.HOUR, 6);
        TrackingPointDAO.tempDate = simpleDateFormat.format(calendar.getTime());
        return simpleDateFormat.format(calendar.getTime());
    }
}
