package pojo.inputPojo;

import constants.Gender;
import pojo.ReminderListData;

public class BirthdayData extends Data {
    public final String contactName;
    public final String phoneNumber;
    public final Gender gender;
    public final String jobTitle;
    public final String location;

    public BirthdayData(String eventTitle, String eventDescription, String eventStartDate, String contactName, String phoneNumber, Gender gender, String jobTitle, String location, ReminderListData reminderListData) {
        super(eventTitle, eventDescription, eventStartDate,reminderListData);
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.location = location;
    }

    public BirthdayData(String eventTitle, String eventDescription, String contactName, String phoneNumber, Gender gender, String jobTitle, String location) {
        super(eventTitle, eventDescription);
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.location = location;
    }
}
