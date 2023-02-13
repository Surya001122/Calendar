package dbOperators;

import calendars.MyMeetingCalendar;
import database.CalendarDatabase;
import database.MeetingCalendarDatabase;
import user.User;

public interface MeetingDataManager {
    CalendarDatabase<MyMeetingCalendar> meetingCalendarDatabase = MeetingCalendarDatabase.getInstance();
    void createMeetingCalendarForUser(User user);
    MyMeetingCalendar getMeetingCalendar(User user) ;
}
