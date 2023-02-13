package calendarManagers;
import calendars.MyTaskCalendar;
import constants.EventType;
import dbOperators.DataManager;
import dbOperators.TaskDataManager;
import events.Task;
import user.User;
import pojo.inputPojo.TaskData;
import java.util.ArrayList;

public class TaskManager implements Manager<TaskData,Task>{
    TaskDataManager taskDataManager = new DataManager();

    @Override
    public void addEvent(TaskData taskData, User user) {
        Task task = new Task(taskData.eventTitle, taskData.eventDescription, taskData.eventStartDate,taskData.reminderListData.eventType, taskData.reminderListData.reminderChoice, taskData.reminderListData.reminderType, taskData.reminderListData.message, taskData.reminderListData.repeatPeriod);
        MyTaskCalendar taskCalendar = taskDataManager.getTasksCalendar(user);
        if(taskCalendar!=null){
            taskCalendar.addTask(task);
            if (!task.getEventType().equals(EventType.NO_REMINDER)) {
                task.createReminder();
            }
        }
    }

    @Override
    public boolean removeEvent(int eventId,User user) {
        Task task = getEvent(eventId,user);
        if(task != null) {
            taskDataManager.getTasksCalendar(user).removeTask(task);
            if (!task.getEventType().equals(EventType.NO_REMINDER)) {
                task.cancelReminder();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyEvent(int eventId,TaskData taskData,User user) {
        Task task = getEvent(eventId,user);
        if(task!=null) {
            String taskTitle = taskData.eventTitle == null ? task.getEventTitle() : taskData.eventTitle;
            String taskDescription = taskData.eventDescription == null ? task.getEventDescription() : taskData.eventDescription;
            task.setEventTitle(taskTitle);
            task.setEventDescription(taskDescription);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Task> getAllEventsInfo(User user) {
        return taskDataManager.getTasksCalendar(user).getAllTasksList();
    }


    private Task getEvent(int eventId, User user) {
        return taskDataManager.getTasksCalendar(user).getTask(eventId);
    }
}
