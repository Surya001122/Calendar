package events;
import constants.EventType;
import constants.ReminderChoice;
import constants.ReminderType;
import reminder.NonRecurringNotifier;
import reminder.Notifier;
import reminder.RecurringNotifier;

public abstract class Event{
    private static int Id;
    private final int eventId;
    private String eventTitle;
    private String eventDescription;
    private final String eventStartDate;
    private final EventType eventType; // Recurring or Non_Recurring or No reminder
    private final ReminderChoice reminderChoice;// alarm,notification,both
    private final Notifier notifier;
    public Event(String eventTitle, String eventDescription, String eventStartDate,EventType eventType,ReminderChoice reminderChoice,ReminderType reminderType,String message,int repeatPeriod) {
        this.eventId = Id++;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventType = eventType;
        this.reminderChoice = reminderChoice;// alarm,notification,both
        notifier = eventType == EventType.RECURRING ? new RecurringNotifier(reminderType,repeatPeriod,message): eventType == EventType.NON_RECURRING ? new NonRecurringNotifier(message):null;
    }


    public int getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }
    public EventType getEventType() {
        return eventType;
    }
    public void createReminder(){
        switch(reminderChoice){
            case ALARM:
                notifier.scheduleAlarm(eventStartDate);
                break;
            case NOTIFICATION:
                notifier.scheduleMessage(eventStartDate);
                break;
            case BOTH:
                notifier.scheduleMessage(eventStartDate);
                notifier.scheduleAlarm(eventStartDate);
                break;
        }
    }
    public void cancelReminder(){
        notifier.cancelReminder();
    }
}

