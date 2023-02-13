package dbOperators;
import calendars.MyTaskCalendar;
import database.CalendarDatabase;
import database.TaskCalendarDatabase;
import user.User;
public interface TaskDataManager {
    CalendarDatabase<MyTaskCalendar> taskCalendarDatabase = TaskCalendarDatabase.getInstance();
    void createTaskCalendarForUser(User user);
    MyTaskCalendar getTasksCalendar(User user) ;

}
