package database;

import calendars.MyTaskCalendar;
import user.User;

import java.util.HashMap;
public class TaskCalendarDatabase implements CalendarDatabase<MyTaskCalendar> {
    private static TaskCalendarDatabase taskDatabase = null;
    private final HashMap<User, MyTaskCalendar> taskCalendars = new HashMap<>();

    private TaskCalendarDatabase() {}

    public static TaskCalendarDatabase getInstance() {
        if (taskDatabase == null) {
            taskDatabase = new TaskCalendarDatabase();
        }
        return taskDatabase;
    }
    @Override
    public void createNewCalendarForUser(User user, MyTaskCalendar calendar) {
        taskCalendars.put(user,calendar);
    }

    @Override
    public MyTaskCalendar getCalendar(User user) {
        if(taskCalendars.containsKey(user)){
            return taskCalendars.get(user);
        }
        return null;
    }

}
