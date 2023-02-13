package calendars;
import events.Birthday;

import java.util.ArrayList;

public interface MyBirthdayCalendar {
    void addBirthday(Birthday birthday);
    Birthday getBirthday(int eventId);
    void removeBirthday(Birthday birthday);
    ArrayList<Birthday> getAllBirthdaysList();
}
