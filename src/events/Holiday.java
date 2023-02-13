package events;
import constants.EventType;
import constants.HolidayType;
import constants.ReminderChoice;
import constants.ReminderType;


public class Holiday extends Event {

    private HolidayType holidayType;
    public Holiday(String eventTitle, String eventDescription, String eventStartDate, HolidayType holidayType, EventType eventType, ReminderChoice reminderChoice, ReminderType reminderType,String message,int repeatPeriod) {
        super(eventTitle, eventDescription, eventStartDate,eventType, reminderChoice, reminderType, message, repeatPeriod);
        this.holidayType = holidayType;
    }
    public HolidayType getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }

}

