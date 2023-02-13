package database;

import calendars.MyHolidayCalendar;
import user.User;
import java.util.HashMap;

public class HolidayCalendarDatabase implements CalendarDatabase<MyHolidayCalendar> {
    private static HolidayCalendarDatabase holidayDatabase = null;

    private final HashMap<User, MyHolidayCalendar> holidayCalendars = new HashMap<>();
    private HolidayCalendarDatabase() {}

    public static HolidayCalendarDatabase getInstance() {
        if (holidayDatabase == null) {
            holidayDatabase = new HolidayCalendarDatabase();
        }
        return holidayDatabase;
    }
    @Override
    public void createNewCalendarForUser(User user, MyHolidayCalendar calendar) {
        holidayCalendars.put(user,calendar);
    }

    @Override
    public MyHolidayCalendar getCalendar(User user) {
        if(holidayCalendars.containsKey(user)){
            return holidayCalendars.get(user);
        }
        return null;
    }

}
