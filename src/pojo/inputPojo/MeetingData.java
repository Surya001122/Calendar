package pojo.inputPojo;

import constants.AttendeeType;
import constants.MeetingType;
import pojo.ReminderListData;

import java.util.HashMap;

public class MeetingData extends Data {
    public HashMap<String, AttendeeType> attendees;
    public String meetingEndDate;
    public final String meetingLocation;
    public final MeetingType meetingType;
    public MeetingData(String eventTitle, String eventDescription, String eventStartDate, String meetingEndDate, String meetingLocation, MeetingType meetingType, HashMap<String,AttendeeType> attendees, ReminderListData reminderListData) {
        super(eventTitle, eventDescription, eventStartDate,reminderListData);
        this.meetingEndDate = meetingEndDate;
        this.meetingLocation = meetingLocation;
        this.meetingType = meetingType;
        this.attendees = attendees;
    }

    public MeetingData(String eventTitle, String eventDescription, String meetingLocation, MeetingType meetingType) {
        super(eventTitle, eventDescription);
        this.meetingLocation = meetingLocation;
        this.meetingType = meetingType;
    }

}
