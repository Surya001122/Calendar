package reminder;
import java.util.Timer;

public abstract class Notifier {
    Timer alarmTimer = null;
    Timer messageTimer = null;
    private final Alarm alarm;
    private final Notification notification;
    public Notifier(String message) {
        alarm = new Alarm();
        notification = new Notification(message);
    }
    public Alarm getAlarm() {
        return alarm;
    }

    public Notification getNotification() {
        return notification;
    }

    public abstract void scheduleAlarm(String eventStartDate);
    public abstract void scheduleMessage(String eventStartDate);
    public void cancelReminder() {
        if(messageTimer!=null) {
            messageTimer.cancel();
        }
        if(alarmTimer!=null) {
            alarmTimer.cancel();
        }
    }

}
