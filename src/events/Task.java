package events;

import constants.EventType;
import constants.ReminderChoice;
import constants.ReminderType;

public class Task extends Event {

    public Task(String taskTitle, String taskDescription, String taskStartDate, EventType eventType, ReminderChoice reminderChoice, ReminderType reminderType,String message,int repeatPeriod) {
        super(taskTitle, taskDescription, taskStartDate, eventType, reminderChoice, reminderType, message, repeatPeriod);
    }

}
