package events;

import constants.*;

import java.util.HashMap;

public class Meeting extends Event {
    static int attenderID = 1;
    private final HashMap<String, AttendeeType> attendees;
    private final String meetingEndDate;
    private String meetingLocation;
    private MeetingType meetingType;

    public Meeting(String eventTitle, String eventDescription, String eventStartDate, String meetingEndDate, String meetingLocation, MeetingType meetingType,HashMap<String,AttendeeType> attendees,EventType eventType, ReminderChoice reminderChoice, ReminderType reminderType,String message,int repeatPeriod) {
        super(eventTitle, eventDescription, eventStartDate,eventType, reminderChoice, reminderType, message, repeatPeriod);
        this.meetingEndDate = meetingEndDate;
        this.meetingLocation = meetingLocation;
        this.meetingType = meetingType;
        this.attendees = attendees;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    public MeetingType getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(MeetingType meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingEndDate() {
        return meetingEndDate;
    }

    public HashMap<String, AttendeeType> getAttendees() {
        return attendees;
    }
}
