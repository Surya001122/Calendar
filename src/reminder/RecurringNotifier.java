package reminder;
import constants.ReminderType;
import utilities.ReminderUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class RecurringNotifier extends Notifier{
    private final ReminderType currentReminderType; // Daily,Weekly,Hourly,etc
    private final int repeatPeriod; // number of weeks,hours,years in weekly,hourly,yearly,etc

    public RecurringNotifier(ReminderType currentReminderType, int repeatPeriod,String message) {
        super(message);
        this.currentReminderType = currentReminderType;
        this.repeatPeriod = repeatPeriod;
        alarmTimer = new Timer();
        messageTimer = new Timer();
    }

    @Override
    public void scheduleAlarm(String eventStartDate) {
        alarmTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getAlarm().playAlarm();
                scheduleAlarm(ReminderUtilities.getNextDateForSettingReminder(eventStartDate,currentReminderType,repeatPeriod));
            }
        },ReminderUtilities.getTotalSecondsForSettingReminder(eventStartDate)*1000L);
    }

    @Override
    public void scheduleMessage(String eventStartDate) {
        messageTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getNotification().playNotification();
                scheduleMessage(ReminderUtilities.getNextDateForSettingReminder(eventStartDate,currentReminderType,repeatPeriod));
            }
        },ReminderUtilities.getTotalSecondsForSettingReminder(eventStartDate)*1000L);
    }


}

