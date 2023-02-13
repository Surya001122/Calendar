package pojo.inputPojo;

import constants.HolidayType;
import pojo.ReminderListData;

public class HolidayData extends Data {
    public final HolidayType holidayType;

    public HolidayData(String eventTitle, String eventDescription, String eventStartDate, HolidayType holidayType, ReminderListData reminderListData) {
        super(eventTitle, eventDescription, eventStartDate,reminderListData);
        this.holidayType = holidayType;
    }

    public HolidayData(String eventTitle, String eventDescription, HolidayType holidayType) {
        super(eventTitle, eventDescription);
        this.holidayType = holidayType;
    }

}
