package calendarManagers;
import calendars.MyHolidayCalendar;
import constants.EventType;
import constants.HolidayType;
import dbOperators.DataManager;
import dbOperators.HolidayDataManager;
import events.Holiday;
import user.User;
import pojo.inputPojo.HolidayData;
import java.util.ArrayList;

public class HolidayManager implements Manager<HolidayData,Holiday>{
    HolidayDataManager holidayDataManager = new DataManager();

    @Override
    public void addEvent(HolidayData holidayData, User user) {
        Holiday holiday = new Holiday(holidayData.eventTitle, holidayData.eventDescription, holidayData.eventStartDate, holidayData.holidayType,holidayData.reminderListData.eventType, holidayData.reminderListData.reminderChoice, holidayData.reminderListData.reminderType, holidayData.reminderListData.message, holidayData.reminderListData.repeatPeriod);
        MyHolidayCalendar holidayCalendar = holidayDataManager.getHolidayCalendar(user);
        if(holidayCalendar!=null){
            holidayCalendar.addHoliday(holiday);
            if (!holiday.getEventType().equals(EventType.NO_REMINDER)) {
                holiday.createReminder();
            }
        }
    }

    @Override
    public boolean removeEvent(int eventId,User user) {
        Holiday holiday = getEvent(eventId,user);
        if(holiday != null) {
            holidayDataManager.getHolidayCalendar(user).removeHoliday(holiday);
            if (!holiday.getEventType().equals(EventType.NO_REMINDER)) {
                holiday.cancelReminder();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyEvent(int eventId,HolidayData holidayData,User user) {
        Holiday holiday = getEvent(eventId,user);
        if(holiday!=null) {
            HolidayType holidayType = holidayData.holidayType == null ? holiday.getHolidayType() : holidayData.holidayType;
            holiday.setHolidayType(holidayType);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Holiday> getAllEventsInfo(User user) {
        return holidayDataManager.getHolidayCalendar(user).getAllHolidaysList();
    }

    private Holiday getEvent(int eventId, User user) {
        return holidayDataManager.getHolidayCalendar(user).getHoliday(eventId);
    }
}
