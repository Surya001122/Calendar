package pojo.inputPojo;

import pojo.ReminderListData;

public class Data {
    public final String eventTitle;
    public final String eventDescription;
    public String eventStartDate;
    public ReminderListData reminderListData;


    public Data(String eventTitle, String eventDescription, String eventStartDate,ReminderListData reminderListData) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.reminderListData = reminderListData;
    }

    public Data(String eventTitle, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
    }
}
