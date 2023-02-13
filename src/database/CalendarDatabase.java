package database;
import user.User;

public interface CalendarDatabase<T>{

    void createNewCalendarForUser(User user, T calendar);
    T getCalendar(User user);

}
