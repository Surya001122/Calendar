package calendars;
import events.*;
import java.util.ArrayList;

public class MyCalendar implements MyMeetingCalendar,MyBirthdayCalendar,MyTaskCalendar,MyHolidayCalendar{
    private final ArrayList<Birthday> birthdays = new ArrayList<>();
    private final ArrayList<Holiday> holidays = new ArrayList<>();
    private final ArrayList<Task> myTasks = new ArrayList<>();
    private final ArrayList<Meeting> myMeetings = new ArrayList<>();
    @Override
    public void addMeeting(Meeting meeting) {
        myMeetings.add(meeting);
    }
    @Override
    public void addTask(Task task) {
        myTasks.add(task);
    }
    @Override
    public void addBirthday(Birthday birthday) {
        birthdays.add(birthday);
    }

    @Override
    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }
    @Override
    public Meeting getMeeting(int eventId){
        for(Meeting meeting : myMeetings){
            if(meeting.getEventId() == eventId){
                return meeting;
            }
        }
        return null;
    }
    @Override
    public Task getTask(int eventId){
        for(Task task : myTasks){
            if(task.getEventId() == eventId){
                return task;
            }
        }
        return null;
    }
    @Override
    public Birthday getBirthday(int eventId){
        for(Birthday birthday : birthdays){
            if(birthday.getEventId() == eventId){
                return birthday;
            }
        }
        return null;
    }
    @Override
    public Holiday getHoliday(int eventId){
        for(Holiday holiday : holidays){
            if(holiday.getEventId() == eventId){
                return holiday;
            }
        }
        return null;
    }
    @Override
    public void removeMeeting(Meeting meeting){
        myMeetings.remove(meeting);
    }

    @Override
    public ArrayList<Meeting> getAllMeetingsList() {
        return new ArrayList<>(myMeetings);
    }

    @Override
    public void removeTask(Task task){
        myTasks.remove(task);
    }

    @Override
    public ArrayList<Task> getAllTasksList() {
        return new ArrayList<>(myTasks);
    }

    @Override
    public void removeBirthday(Birthday birthday){
        birthdays.remove(birthday);
    }

    @Override
    public ArrayList<Birthday> getAllBirthdaysList() {
        return new ArrayList<>(birthdays);
    }

    @Override
    public void removeHoliday(Holiday holiday){
        holidays.remove(holiday);
    }

    @Override
    public ArrayList<Holiday> getAllHolidaysList() {
        return new ArrayList<>(holidays);
    }

}
