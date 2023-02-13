package userInterface;
import events.*;
import themes.Theme;
import utilities.ValidationUtilities;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarHandler {
    public void viewMyCalendar(ArrayList<Meeting>meetingInfoList, ArrayList<Task>taskInfoList, ArrayList<Birthday>birthdayInfoList, ArrayList<Holiday>holidayInfoList, Theme theme){
        Scanner sc = new Scanner(System.in);
        int calendarChoice = 0;
        while(calendarChoice<=0 || calendarChoice>=3){
            System.out.print("\nEnter 1 to view current month's calendar\nEnter 2 to view calendar by entering month and year(Jan->1 to Dec->12)\nEnter your choice : ");
            try {
                calendarChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                calendarChoice = 0;
                System.out.print("\nEnter valid choice. please try again...");
            }
        }
        switch(calendarChoice){
            case 1:
                displayCalendar(meetingInfoList,taskInfoList,birthdayInfoList,holidayInfoList,theme);
                break;
            case 2:
                int fromMonth,fromYear;
                System.out.print("\nEnter the month : ");
                try{
                    fromMonth = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid month. please try again...");
                    return;
                }
                System.out.print("\nEnter the year : ");
                try{
                    fromYear = Integer.parseInt(sc.nextLine().trim());
                }
                catch (NumberFormatException numberFormatException){
                    System.out.print("\nEnter valid year. please try again...");
                    return;
                }
                displayCalendar(fromMonth-1,fromYear,meetingInfoList,taskInfoList,birthdayInfoList,holidayInfoList,theme);
                break;
            default:
                System.out.print("\nEnter valid choice.Please try again...");
                break;
        }
    }
    private void displayCalendar(ArrayList<Meeting>meetingInfoList, ArrayList<Task>taskInfoList, ArrayList<Birthday>birthdayInfoList, ArrayList<Holiday>holidayInfoList,Theme theme){
        Scanner sc = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        GregorianCalendar calendar = new GregorianCalendar(year,month, 1);
        int startingDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // S M T W T F S 1 2 3 4 5 6 7
        int totalDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28,29,30,31
        System.out.println("\n\n");
        System.out.println(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));
        System.out.println(" S  M  T  W  T  F  S");
        for (int i = 0; i < startingDayOfWeek - 1; i++) {
            System.out.print("   ");
        }
        for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
            for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                if(isEventPresentOnThatDay(day,month,year,meetingInfoList)){
                    System.out.printf(theme.getMeetingTheme()+"%2d "+theme.getResetTheme(), day);
                }
                else if(isEventPresentOnThatDay(day,month,year,taskInfoList)){
                    System.out.printf(theme.getTaskTheme()+"%2d "+theme.getResetTheme(), day);
                }
                else if(isEventPresentOnThatDay(day,month,year,birthdayInfoList)){
                    System.out.printf(theme.getBirthdayTheme()+"%2d "+theme.getResetTheme(), day);
                }
                else if(isEventPresentOnThatDay(day,month,year,holidayInfoList)){
                    System.out.printf(theme.getHolidayTheme()+"%2d "+theme.getResetTheme(), day);
                }
                else {
                    System.out.printf("%2d ", day);
                }
                day++;
            }
            System.out.println();
        }
        System.out.println("\n"+theme.getMeetingTheme()+"Meeting"+theme.getResetTheme()+"\n"+theme.getTaskTheme()+"Task"+theme.getResetTheme()+"\n"+theme.getBirthdayTheme()+"Birthday"+theme.getResetTheme()+"\n"+theme.getHolidayTheme()+"Holiday"+theme.getResetTheme());
        int viewChoice = -1;
        while (viewChoice<=0 || viewChoice>=7) {
            System.out.print("\nEnter 1 to view Meetings\nEnter 2 to view tasks\nEnter 3 to view birthdays\nEnter 4 to view holidays\nEnter 5 to view all events\nEnter 6 to exit calendar\nEnter your choice : ");
            try {
                viewChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                viewChoice = -1;
                System.out.print("\nEnter valid choice..try again...");
            }
        }
        System.out.println("\n\n");
        switch(viewChoice){
            case 1:
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,meetingInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No meetings available\n********************");
                }
                break;
            case 2:
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,taskInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No tasks available\n********************");
                }
                break;
            case 3:
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,birthdayInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No birthdays available\n********************");
                }
                break;
            case 4:
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,holidayInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No holidays available\n********************");
                }
                break;
            case 5:
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,meetingInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No meetings available\n********************");
                }
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,taskInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No tasks available\n********************");
                }
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,holidayInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No holidays available\n********************");
                }
                if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,month,year,birthdayInfoList)){
                    System.out.println("\n***************************************************************************");
                }
                else {
                    System.out.println("No birthdays available\n********************");
                }
                break;
            case 6:
                break;
            default:
                System.out.print("\nEnter valid choice..try again...");
                break;
        }
    }
    private void displayCalendar(int fromMonth,int fromYear,ArrayList<Meeting>meetingInfoList, ArrayList<Task>taskInfoList, ArrayList<Birthday>birthdayInfoList, ArrayList<Holiday>holidayInfoList,Theme theme){
        Scanner sc = new Scanner(System.in);
        boolean calendarRun = true;
        while(calendarRun){
            GregorianCalendar calendar = new GregorianCalendar(fromYear,fromMonth,1);
            int startingDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // S M T W T F S 1 2 3 4 5 6 7
            int totalDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28,29,30,31
            System.out.println("\n\n");
            System.out.println(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));
            System.out.println(" S  M  T  W  T  F  S");
            for (int i = 0; i < startingDayOfWeek - 1; i++) {
                System.out.print("   ");
            }
            for (int i = 0, day = 1; day <= totalDaysInMonth; i++)  {
                for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                    if(isEventPresentOnThatDay(day,fromMonth,fromYear,meetingInfoList)){
                        System.out.printf(theme.getMeetingTheme()+"%2d "+theme.getResetTheme(), day);
                    }
                    else if(isEventPresentOnThatDay(day,fromMonth,fromYear,taskInfoList)){
                        System.out.printf(theme.getTaskTheme()+"%2d "+theme.getResetTheme(), day);
                    }
                    else if(isEventPresentOnThatDay(day,fromMonth,fromYear,birthdayInfoList)){
                        System.out.printf(theme.getBirthdayTheme()+"%2d "+theme.getResetTheme(), day);
                    }
                    else if(isEventPresentOnThatDay(day,fromMonth,fromYear,holidayInfoList)){
                        System.out.printf(theme.getHolidayTheme()+"%2d "+theme.getResetTheme(), day);
                    }
                    else {
                        System.out.printf("%2d ", day);
                    }
                    day++;
                }
                System.out.println();
            }
            System.out.println("\n"+theme.getMeetingTheme()+"Meeting"+theme.getResetTheme()+"\n"+theme.getTaskTheme()+"Task"+theme.getResetTheme()+"\n"+theme.getBirthdayTheme()+"Birthday"+theme.getResetTheme()+"\n"+theme.getHolidayTheme()+"Holiday"+theme.getResetTheme());
            int viewChoice = 0;
            while(viewChoice<=0 || viewChoice>=9){
                System.out.print("\nEnter 1 to view Meetings\nEnter 2 to view tasks\nEnter 3 to view birthdays\nEnter 4 to view holidays\nEnter 5 to view all events\nEnter 6 to go for next month\nEnter 7 to go for previous month\nEnter 8 to exit calendar\nEnter your choice : ");
                try {
                    viewChoice = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException numberFormatException) {
                    viewChoice = -1;
                    System.out.print("\nEnter valid choice..try again...");
                }
            }
            System.out.println("\n\n");
            switch(viewChoice){
                case 1:
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,meetingInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No meetings available\n********************");
                    }
                    break;
                case 2:
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,taskInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No tasks available\n********************");
                    }
                    break;
                case 3:
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,birthdayInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No birthdays available\n********************");
                    }
                    break;
                case 4:
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,holidayInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No holidays available\n********************");
                    }
                    break;
                case 5:
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,meetingInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No meetings available\n********************");
                    }
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,taskInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No tasks available\n********************");
                    }
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,holidayInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No holidays available\n********************");
                    }
                    if(displayEventsInCalendar(totalDaysInMonth,startingDayOfWeek,fromMonth,fromYear,birthdayInfoList)){
                        System.out.println("\n***************************************************************************");
                    }
                    else {
                        System.out.println("No birthdays available\n********************");
                    }
                    break;
                case 6:
                    fromMonth++;
                    if (fromMonth > 11) {
                        fromMonth = 0;
                        fromYear++;
                    }
                    break;
                case 7:
                    fromMonth--;
                    if (fromMonth < 0) {
                        fromMonth = 11;
                        fromYear--;
                    }
                    break;
                case 8:
                    calendarRun = false;
                    break;
                default:
                    System.out.print("\nEnter valid choice..Try again...");
                    break;
            }
        }
    }
    private <E> boolean displayEventsInCalendar(int totalDaysInMonth, int startingDayOfWeek, int month, int year, ArrayList<E> eventsInfoList){
        boolean isPresent = false;

        if(eventsInfoList.isEmpty()) {
            return isPresent;
        }
        for (int i = 0, day = 1; day <= totalDaysInMonth; i++) {
            for (int j = ((i == 0) ? startingDayOfWeek - 1 : 0); j < 7 && (day <= totalDaysInMonth); j++) {
                for (E event : eventsInfoList) {
                    if (event instanceof Meeting && ValidationUtilities.isEqual(day, month, year, ((Meeting) event).getEventStartDate())) {
                        System.out.println("\nMeeting ID : "+((Meeting) event).getEventId()+"\nMeeting title : "+((Meeting) event).getEventTitle()+"\nMeeting description : "+((Meeting) event).getEventDescription()+"\nMeeting start date : "+((Meeting) event).getEventStartDate()+"\nEvent type : "+((Meeting) event).getEventType()+"\n-------------------------------------------------------------------------");
                        isPresent = true;
                    }
                    if (event instanceof Task && ValidationUtilities.isEqual(day, month, year, ((Task) event).getEventStartDate())) {
                        System.out.println("\nTask ID : "+((Task) event).getEventId()+"\nTaskTitle : "+((Task) event).getEventTitle()+"\nTask description : "+((Task) event).getEventDescription()+"\ntask start date : "+((Task) event).getEventStartDate()+"\nEvent type : "+((Task) event).getEventType()+"\n-------------------------------------------------------------------------");
                        isPresent = true;
                    }
                    if (event instanceof Birthday && ValidationUtilities.isEqual(day, month, year, ((Birthday) event).getEventStartDate())) {
                        System.out.println("\nBirthday ID : "+((Birthday) event).getEventId()+"\nBirthdayTitle : "+((Birthday) event).getEventTitle()+"\nBirthday description : "+((Birthday) event).getEventDescription()+"\nBirthday start date : "+((Birthday) event).getEventStartDate()+"\nEvent type : "+((Birthday) event).getEventType()+"\n-------------------------------------------------------------------------");
                        isPresent = true;
                    }
                    if (event instanceof Holiday && ValidationUtilities.isEqual(day, month, year, ((Holiday) event).getEventStartDate())) {
                        System.out.println("\nHoliday ID : "+((Holiday) event).getEventId()+"\nHoliday title : "+((Holiday) event).getEventTitle()+"\nHoliday description : "+((Holiday) event).getEventDescription()+"\nHoliday start date : "+((Holiday) event).getEventStartDate()+"\nEvent type : "+((Holiday) event).getEventType()+"\n-------------------------------------------------------------------------");
                        isPresent = true;
                    }
                }
                day++;
            }
        }
        return isPresent;
    }
    private<E>boolean isEventPresentOnThatDay(int day,int month,int year,ArrayList<E> eventsInfoList){
        for (E event : eventsInfoList) {
            if (event instanceof Meeting && ValidationUtilities.isEqual(day, month, year, ((Meeting) event).getEventStartDate())) {
                return true;
            }
            if (event instanceof Task && ValidationUtilities.isEqual(day, month, year, ((Task) event).getEventStartDate())) {
                return true;
            }
            if (event instanceof Birthday && ValidationUtilities.isEqual(day, month, year, ((Birthday) event).getEventStartDate())) {
                return true;
            }
            if (event instanceof Holiday && ValidationUtilities.isEqual(day, month, year, ((Holiday) event).getEventStartDate())) {
                return true;
            }
        }
        return false;
    }
}
