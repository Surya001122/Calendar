package calendars;

import events.Holiday;

import java.util.ArrayList;

public interface MyHolidayCalendar {
    void addHoliday(Holiday holiday);
    Holiday getHoliday(int eventId);
    void removeHoliday(Holiday holiday);
    ArrayList<Holiday> getAllHolidaysList();
}
