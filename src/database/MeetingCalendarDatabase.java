package database;

import calendars.MyMeetingCalendar;
import user.User;
import java.util.HashMap;
public class MeetingCalendarDatabase implements CalendarDatabase<MyMeetingCalendar> {
    private static MeetingCalendarDatabase meetingDatabase = null;

    private final HashMap<User, MyMeetingCalendar> meetingCalendars = new HashMap<>();
    private MeetingCalendarDatabase() {}

    public static MeetingCalendarDatabase getInstance() {
        if (meetingDatabase == null) {
            meetingDatabase = new MeetingCalendarDatabase();
        }
        return meetingDatabase;
    }

    @Override
    public void createNewCalendarForUser(User user, MyMeetingCalendar calendar) {
        meetingCalendars.put(user,calendar);
    }

    @Override
    public MyMeetingCalendar getCalendar(User user) {
        if(meetingCalendars.containsKey(user)) {
            return meetingCalendars.get(user);
        }
        return null;
    }
}
