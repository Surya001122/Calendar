package pojo;

import constants.EventType;
import constants.ReminderChoice;
import constants.ReminderType;

public class ReminderListData {
    public final EventType eventType;
    public final ReminderChoice reminderChoice;
    public final ReminderType reminderType;
    public final String message;
    public final int repeatPeriod;

    public ReminderListData(EventType eventType, ReminderChoice reminderChoice, ReminderType reminderType, String message, int repeatPeriod) {
        this.eventType = eventType;
        this.reminderChoice = reminderChoice;
        this.reminderType = reminderType;
        this.message = message;
        this.repeatPeriod = repeatPeriod;
    }
}
