package dbOperators;

import calendars.MyBirthdayCalendar;
import database.BirthdayCalendarDatabase;
import database.CalendarDatabase;
import user.User;

public interface BirthdayDataManager {
    CalendarDatabase<MyBirthdayCalendar> birthdayCalendarDatabase = BirthdayCalendarDatabase.getInstance();
    void createBirthdayCalendarForUser(User user);
    MyBirthdayCalendar getBirthdayCalendar(User user) ;

}
