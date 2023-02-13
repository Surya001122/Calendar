package dbOperators;
import calendars.*;
import user.User;

public class DataManager implements MeetingDataManager, TaskDataManager, HolidayDataManager, BirthdayDataManager {
    @Override
    public void createMeetingCalendarForUser(User user){
        if(meetingCalendarDatabase.getCalendar(user)==null) {
            MyMeetingCalendar calendar = new MyCalendar();
            meetingCalendarDatabase.createNewCalendarForUser(user, calendar);
        }
    }
    @Override
    public void createTaskCalendarForUser(User user){
        if(taskCalendarDatabase.getCalendar(user)==null) {
            MyTaskCalendar calendar = new MyCalendar();
            taskCalendarDatabase.createNewCalendarForUser(user, calendar);
        }
    }
    @Override
    public void createBirthdayCalendarForUser(User user){
        if(birthdayCalendarDatabase.getCalendar(user)==null) {
            MyBirthdayCalendar calendar = new MyCalendar();
            birthdayCalendarDatabase.createNewCalendarForUser(user, calendar);
        }
    }
    @Override
    public void createHolidayCalendarForUser(User user){
        if(holidayCalendarDatabase.getCalendar(user)==null) {
            MyHolidayCalendar calendar = new MyCalendar();
            holidayCalendarDatabase.createNewCalendarForUser(user, calendar);
        }
    }
    @Override
    public MyBirthdayCalendar getBirthdayCalendar(User user) {
        return birthdayCalendarDatabase.getCalendar(user);
    }
    @Override
    public MyHolidayCalendar getHolidayCalendar(User user) {
        return holidayCalendarDatabase.getCalendar(user);
    }
    @Override
    public MyMeetingCalendar getMeetingCalendar(User user) {
        return meetingCalendarDatabase.getCalendar(user);
    }
    @Override
    public MyTaskCalendar getTasksCalendar(User user) {
        return taskCalendarDatabase.getCalendar(user);
    }

}
