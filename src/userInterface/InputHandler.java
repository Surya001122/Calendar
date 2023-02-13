package userInterface;
import constants.EventType;
import constants.ReminderChoice;
import constants.ReminderType;
import events.Event;
import pojo.inputPojo.Data;
import pojo.ReminderListData;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class InputHandler<T extends Data,U extends Event>{
    public abstract T getInputForCreatingEvent();
    public abstract int getInputForFetchingEventId();
    public abstract T getInputForUpdatingEvent();
    public abstract boolean displayAllEvents(ArrayList<U> eventList);

    ReminderListData getInputForSettingReminder(){
        Scanner sc = new Scanner(System.in);
        EventType eventType = null; // RECURRING OR NON_RECURRING or NO_REMINDER
        ReminderChoice reminderChoice = null; // ALARM,NOTIFICATION,BOTH
        ReminderType reminderType = null; //HOURLY,WEEKLY etc
        String message = null; // message to display during event start time
        int repeatPeriod = 0;// number of weeks, years etc
        boolean reminderChoiceBoolean = true;
        boolean reminderTypeBoolean = true;
        boolean eventBool = false;
        while (!eventBool){
            String choice;
            System.out.println("\nDo you want to set the reminder(yes or no) : ");
            choice = sc.nextLine().trim();
            switch (choice) {
                case "yes":
                    while(!eventBool) {
                        System.out.print("\nEnter the Event type:\n1->RECURRING(Repeating Alarm)\n2->NON_RECURRING(Non Repeating Alarm)\nEnter your choice : ");
                        String currentEventType = sc.nextLine().trim();
                        switch (currentEventType) {
                            case "1":
                                eventType = EventType.RECURRING;
                                eventBool = true;
                                break;
                            case "2":
                                eventType = EventType.NON_RECURRING;
                                eventBool = true;
                                break;
                            default:
                                System.out.println("Enter valid choice...");
                                break;
                        }
                    }
                    break;
                case "no":
                    eventType = EventType.NO_REMINDER;
                    eventBool = true;
                    break;
            }
        }
        if(!eventType.equals(EventType.NO_REMINDER)) {
            if (eventType.equals(EventType.RECURRING)) {
                do {
                    System.out.print("\nEnter the Reminder type : 1->DAILY\n2->WEEKLY\n3->MONTHLY\n4->YEARLY\nEnter your choice : ");
                    String currentReminderType = sc.nextLine().trim();
                    switch (currentReminderType){
                        case "1":
                            reminderType = ReminderType.DAILY;
                            try {
                                System.out.print("\nEnter the repeatPeriod : ");
                                repeatPeriod = Integer.parseInt(sc.nextLine().trim());
                                reminderTypeBoolean = false;
                            } catch (Exception ignored) {}
                            break;
                        case "2":
                            reminderType = ReminderType.WEEKLY;
                            try {
                                System.out.print("\nEnter the repeatPeriod : ");
                                repeatPeriod = Integer.parseInt(sc.nextLine().trim());
                                reminderTypeBoolean = false;
                            } catch (Exception ignored) {}
                            break;
                        case "3":
                            reminderType = ReminderType.MONTHLY;
                            try {
                                System.out.print("\nEnter the repeatPeriod : ");
                                repeatPeriod = Integer.parseInt(sc.nextLine().trim());
                                reminderTypeBoolean = false;
                            } catch (Exception ignored) {}
                            break;
                        case "4":
                            reminderType = ReminderType.YEARLY;
                            try {
                                System.out.print("\nEnter the repeatPeriod : ");
                                repeatPeriod = Integer.parseInt(sc.nextLine().trim());
                                reminderTypeBoolean = false;
                            } catch (Exception ignored) {}
                            break;
                        default:
                            System.out.println("Enter valid choice...");
                            break;
                    }
                } while (reminderTypeBoolean);
            }
            do {
                System.out.print("\nEnter the reminder choice\nPress the number : \n1->ALARM\n2->NOTIFICATION\n3->BOTH\nEnter your choice : ");
                String currentReminderChoice = sc.nextLine().trim();
                switch (currentReminderChoice){
                    case "3":
                        reminderChoice = ReminderChoice.BOTH;
                        System.out.print("\nEnter the message to display : ");
                        message = sc.nextLine().trim();
                        reminderChoiceBoolean = false;
                        break;
                    case "2":
                        reminderChoice = ReminderChoice.NOTIFICATION;
                        System.out.print("\nEnter the message to display : ");
                        message = sc.nextLine().trim();
                        reminderChoiceBoolean = false;
                        break;
                    case "1":
                        reminderChoice = ReminderChoice.ALARM;
                        reminderChoiceBoolean = false;
                        break;
                    default:
                        System.out.println("Enter valid choice...");
                        break;
                }
            } while (reminderChoiceBoolean);
        }

        return new ReminderListData(eventType,reminderChoice,reminderType,message,repeatPeriod);
    }
}
