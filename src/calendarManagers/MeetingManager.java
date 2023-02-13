package calendarManagers;
import calendars.MyMeetingCalendar;
import constants.EventType;
import constants.MeetingType;
import dbOperators.DataManager;
import dbOperators.MeetingDataManager;
import events.Meeting;
import user.User;
import pojo.inputPojo.MeetingData;
import java.util.ArrayList;

public class MeetingManager implements Manager<MeetingData,Meeting>{

    MeetingDataManager meetingDataManager = new DataManager();
    @Override
    public void addEvent(MeetingData meetingData, User user) {
        Meeting meeting = new Meeting(meetingData.eventTitle, meetingData.eventDescription,meetingData.eventStartDate, meetingData.meetingEndDate, meetingData.meetingLocation,meetingData.meetingType,meetingData.attendees,meetingData.reminderListData.eventType, meetingData.reminderListData.reminderChoice, meetingData.reminderListData.reminderType, meetingData.reminderListData.message, meetingData.reminderListData.repeatPeriod);
        MyMeetingCalendar meetingCalendar = meetingDataManager.getMeetingCalendar(user);
        if(meetingCalendar!=null){
            meetingCalendar.addMeeting(meeting);
            if (!meeting.getEventType().equals(EventType.NO_REMINDER)) {
                meeting.createReminder();
            }
        }
    }

    @Override
    public boolean removeEvent(int eventId,User user) {
        Meeting meeting = getEvent(eventId,user);
        if(meeting != null) {
            meetingDataManager.getMeetingCalendar(user).removeMeeting(meeting);
            if (!meeting.getEventType().equals(EventType.NO_REMINDER)) {
                meeting.cancelReminder();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyEvent(int eventId,MeetingData meetingData,User user) {
        Meeting meeting = getEvent(eventId,user);
        if(meeting!=null) {
            String meetingTitle = meetingData.eventTitle == null ? meeting.getEventTitle() : meetingData.eventTitle;
            String meetingDescription = meetingData.eventDescription == null ? meeting.getEventDescription() : meetingData.eventDescription;
            String meetingLocation = meetingData.meetingLocation == null ? meeting.getMeetingLocation() : meetingData.meetingLocation;
            MeetingType meetingType = meetingData.meetingType == null ? meeting.getMeetingType() : meetingData.meetingType;
            meeting.setEventTitle(meetingTitle);
            meeting.setEventDescription(meetingDescription);
            meeting.setMeetingLocation(meetingLocation);
            meeting.setMeetingType(meetingType);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Meeting> getAllEventsInfo(User user) {
        return meetingDataManager.getMeetingCalendar(user).getAllMeetingsList();
    }


    private Meeting getEvent(int eventId, User user) {
        return meetingDataManager.getMeetingCalendar(user).getMeeting(eventId);
    }
}
