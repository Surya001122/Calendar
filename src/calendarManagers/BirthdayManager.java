package calendarManagers;
import calendars.MyBirthdayCalendar;
import constants.EventType;
import constants.Gender;
import dbOperators.BirthdayDataManager;
import dbOperators.DataManager;
import events.Birthday;
import user.User;
import pojo.inputPojo.BirthdayData;
import java.util.ArrayList;

public class BirthdayManager implements Manager<BirthdayData,Birthday>{

    BirthdayDataManager birthdayDataManager = new DataManager();
    @Override
    public void addEvent(BirthdayData birthdayData, User user) {
        Birthday birthday = new Birthday(birthdayData.eventTitle, birthdayData.eventDescription, birthdayData.eventStartDate, birthdayData.contactName, birthdayData.phoneNumber, birthdayData.gender, birthdayData.jobTitle, birthdayData.location,birthdayData.reminderListData.eventType, birthdayData.reminderListData.reminderChoice, birthdayData.reminderListData.reminderType, birthdayData.reminderListData.message, birthdayData.reminderListData.repeatPeriod);
        MyBirthdayCalendar birthdayCalendar = birthdayDataManager.getBirthdayCalendar(user);
        if(birthdayCalendar!=null){
            birthdayCalendar.addBirthday(birthday);
            if (!birthday.getEventType().equals(EventType.NO_REMINDER)) {
                birthday.createReminder();
            }
        }
    }

    @Override
    public boolean removeEvent(int eventId,User user) {
        Birthday birthday = getEvent(eventId, user);
        if(birthday != null) {
            birthdayDataManager.getBirthdayCalendar(user).removeBirthday(birthday);
            if (!birthday.getEventType().equals(EventType.NO_REMINDER)) {
                birthday.cancelReminder();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyEvent(int eventId,BirthdayData birthdayData,User user) {
        Birthday birthday = getEvent(eventId,user);
        if(birthday!=null) {
            String birthdayTitle = birthdayData.eventTitle == null ? birthday.getEventTitle() : birthdayData.eventTitle;
            String birthdayDescription = birthdayData.eventDescription == null ? birthday.getEventDescription() : birthdayData.eventDescription;
            String contactName = birthdayData.contactName == null ? birthday.getContactName() : birthdayData.contactName;
            String phoneNumber = birthdayData.phoneNumber == null ? birthday.getPhoneNumber() : birthdayData.phoneNumber;
            Gender gender = birthdayData.gender == null ? birthday.getGender() : birthdayData.gender;
            String jobTitle = birthdayData.jobTitle == null ? birthday.getJobTitle() : birthdayData.jobTitle;
            String location = birthdayData.location == null ? birthday.getLocation() : birthdayData.location;

            birthday.setEventTitle(birthdayTitle);
            birthday.setEventDescription(birthdayDescription);
            birthday.setContactName(contactName);
            birthday.setPhoneNumber(phoneNumber);
            birthday.setGender(gender);
            birthday.setJobTitle(jobTitle);
            birthday.setLocation(location);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Birthday> getAllEventsInfo(User user) {
        return birthdayDataManager.getBirthdayCalendar(user).getAllBirthdaysList();
    }

    private Birthday getEvent(int eventId, User user) {
        return birthdayDataManager.getBirthdayCalendar(user).getBirthday(eventId);
    }
}
