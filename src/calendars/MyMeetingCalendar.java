package calendars;
import events.Meeting;
import java.util.ArrayList;

public interface MyMeetingCalendar {
    void addMeeting(Meeting meeting);

    Meeting getMeeting(int eventId);

    void removeMeeting(Meeting meeting);

    ArrayList<Meeting> getAllMeetingsList();

}
