package calendarManagers;
import events.Event;
import user.User;
import pojo.inputPojo.Data;

import java.util.ArrayList;

public interface Manager<T extends Data,U extends Event>{
    void addEvent(T input, User user);
    boolean removeEvent(int eventId,User user);
    boolean modifyEvent(int eventId,T input,User user);
    ArrayList<U> getAllEventsInfo(User user);
}
