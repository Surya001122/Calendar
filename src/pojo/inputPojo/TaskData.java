package pojo.inputPojo;

import pojo.ReminderListData;

public class TaskData extends Data {

    public TaskData(String eventTitle, String eventDescription, String eventStartDate, ReminderListData reminderListData) {
        super(eventTitle, eventDescription, eventStartDate,reminderListData);
    }

    public TaskData(String eventTitle, String eventDescription) {
        super(eventTitle, eventDescription);
    }
}
