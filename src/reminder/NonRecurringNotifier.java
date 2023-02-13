package reminder;

import utilities.ReminderUtilities;

import java.util.Timer;
import java.util.TimerTask;

public class NonRecurringNotifier extends Notifier{
    public NonRecurringNotifier(String message) {
        super(message);
    }

    @Override
    public void scheduleAlarm(String eventStartDate) {
        alarmTimer = new Timer();
        alarmTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getAlarm().playAlarm();
                alarmTimer.cancel();
            }
        }, ReminderUtilities.getTotalSecondsForSettingReminder(eventStartDate)*1000L);
    }

    @Override
    public void scheduleMessage(String eventStartDate) {
        messageTimer = new Timer();
        messageTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getNotification().playNotification();
                messageTimer.cancel();
            }
        },ReminderUtilities.getTotalSecondsForSettingReminder(eventStartDate)*1000L);
    }

}

