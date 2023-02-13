package utilities;
import constants.ReminderType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReminderUtilities {
    public static long getTotalSecondsForSettingReminder(String eventStartDate){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dummyCurrentDate = formatter.format(date);
        Date currentDate,eventDate;
        try{
            currentDate = formatter.parse(dummyCurrentDate);
            eventDate = formatter.parse(eventStartDate);
            long diffInMillis = Math.abs(eventDate.getTime() - currentDate.getTime());
            return TimeUnit.SECONDS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        }
        catch (ParseException parseException){return -1;}
    }
    public static String getNextDateForSettingReminder(String eventStartDate, ReminderType currentReminderType, int repeatPeriod) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.parse(eventStartDate, formatter);
        LocalDateTime nextDate = null;
        switch (currentReminderType) {
            case DAILY:
                nextDate = currentDate.plusDays(repeatPeriod);
                break;
            case MONTHLY:
                nextDate = currentDate.plusMonths(repeatPeriod);
                break;
            case WEEKLY:
                nextDate = currentDate.plusWeeks(repeatPeriod);
                break;
            case YEARLY:
                nextDate = currentDate.plusYears(repeatPeriod);
                break;
        }
        return formatter.format(nextDate);
    }
}
