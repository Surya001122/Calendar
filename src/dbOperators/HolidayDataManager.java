package dbOperators;

import calendars.MyHolidayCalendar;
import database.CalendarDatabase;
import database.HolidayCalendarDatabase;
import user.User;

public interface HolidayDataManager {
    CalendarDatabase<MyHolidayCalendar> holidayCalendarDatabase = HolidayCalendarDatabase.getInstance();
    void createHolidayCalendarForUser(User user);
    MyHolidayCalendar getHolidayCalendar(User user) ;

}
