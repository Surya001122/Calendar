package calendars;
import events.Task;
import java.util.ArrayList;

public interface MyTaskCalendar {
    void addTask(Task task);
    Task getTask(int eventId);
    void removeTask(Task task);
    ArrayList<Task> getAllTasksList();

}
