package database;

import calendars.MyBirthdayCalendar;
import user.User;
import java.util.HashMap;
public class BirthdayCalendarDatabase implements CalendarDatabase<MyBirthdayCalendar> {
    private static BirthdayCalendarDatabase birthdayDatabase = null;

    private final HashMap<User, MyBirthdayCalendar> birthdayCalendars = new HashMap<>();
    private BirthdayCalendarDatabase() {}

    public static BirthdayCalendarDatabase getInstance() {
        if (birthdayDatabase == null) {
            birthdayDatabase = new BirthdayCalendarDatabase();
        }
        return birthdayDatabase;
    }



    @Override
    public void createNewCalendarForUser(User user, MyBirthdayCalendar calendar) {
        birthdayCalendars.put(user,calendar);
    }

    @Override
    public MyBirthdayCalendar getCalendar(User user) {
        if(birthdayCalendars.containsKey(user)){
            return birthdayCalendars.get(user);
        }
        return null;
    }
}
