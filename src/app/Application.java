package app;
import authentication.RegistrationInputHandler;
import authentication.RegistrationManager;
import calendarManagers.*;
import constants.Gender;
import dbOperators.*;
import events.*;
import pojo.inputPojo.*;
import themes.ThemeOperator;
import user.User;
import userInterface.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Application {
    public void run(){

//        default Users
        MeetingDataManager defaultMeetingDataManager = new DataManager();
        TaskDataManager defaultTaskDataManager = new DataManager();
        BirthdayDataManager defaultBirthdayDataManager = new DataManager();
        HolidayDataManager defaultHolidayDataManager = new DataManager();
        ThemeOperator defaultThemeOperator = new ThemeOperator();
        RegistrationData registrationData1 = new RegistrationData("user1","U1_user1", Gender.MALE,"Test@123","nil","nil","9876543210","01/08/2002");
        RegistrationData registrationData2 = new RegistrationData("user2","U2_user2", Gender.FEMALE,"Test@123","nil","nil","9876543210","01/08/2002");
        User u1 = new RegistrationManager().userSignUpOperations(registrationData1);
        User u2 = new RegistrationManager().userSignUpOperations(registrationData2);
        defaultMeetingDataManager.createMeetingCalendarForUser(u1);
        defaultTaskDataManager.createTaskCalendarForUser(u1);
        defaultBirthdayDataManager.createBirthdayCalendarForUser(u1);
        defaultHolidayDataManager.createHolidayCalendarForUser(u1);
        defaultThemeOperator.createThemesForUserCalendar(u1.getUserId());
        defaultMeetingDataManager.createMeetingCalendarForUser(u2);
        defaultTaskDataManager.createTaskCalendarForUser(u2);
        defaultBirthdayDataManager.createBirthdayCalendarForUser(u2);
        defaultHolidayDataManager.createHolidayCalendarForUser(u2);
        defaultThemeOperator.createThemesForUserCalendar(u2.getUserId());




        // Declarations
        User user;
        RegistrationManager registrationManager; // handles the signup and login operations for user
        RegistrationInputHandler registrationInputHandler; // handles the input from the user
        MeetingDataManager meetingDataManager; // holds the meeting database to store user and meeting calendar
        TaskDataManager taskDataManager;// holds the task database to store user and task calendar
        BirthdayDataManager birthdayDataManager;// holds the birthday database to store user and birthday calendar
        HolidayDataManager holidayDataManager;// holds the holiday database to store user and holiday calendar
        ThemeOperator themeOperator; // holds the userThemes obj
        InputHandler <MeetingData,Meeting> meetingInputHandler; // handles the input for meeting
        Manager<MeetingData, Meeting> meetingManager;// handles the operations like adding, removing and updating, viewing for meetings.
        InputHandler <TaskData,Task> taskInputHandler; // handles the input for task
        Manager<TaskData, Task> taskManager;// handles the operations like adding, removing and updating, viewing for tasks.
        InputHandler <BirthdayData,Birthday> birthdayInputHandler; // handles the input for birthday
        Manager<BirthdayData, Birthday> birthdayManager;// handles the operations like adding, removing and updating, viewing for birthdays.
        InputHandler <HolidayData,Holiday> holidayInputHandler; // handles the input for holiday
        Manager<HolidayData, Holiday> holidayManager;// handles the operations like adding, removing and updating, viewing for holidays.
        CalendarHandler calendarHandler; // handles the displaying of calendar and its related operations
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while (bool){
            System.out.print("\n\nDashboard\n*********\n\n1.SignUp\n2.Login\n3.Exit\n\n\nEnter your choice : ");
            int login;
            try {
                login = Integer.parseInt(sc.nextLine().trim());
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("\nEnter valid option...");
                continue;
            }
            switch(login){
                case 1:
                    registrationManager  = new RegistrationManager();
                    registrationInputHandler  = new RegistrationInputHandler();
                    meetingDataManager = new DataManager();
                    taskDataManager = new DataManager();
                    birthdayDataManager = new DataManager();
                    holidayDataManager = new DataManager();
                    themeOperator = new ThemeOperator();
                    signUpOperations(registrationManager,registrationInputHandler,meetingDataManager,taskDataManager,birthdayDataManager,holidayDataManager,themeOperator);
                    break;
                case 2:
                    registrationManager  = new RegistrationManager();
                    registrationInputHandler  = new RegistrationInputHandler();
                    user = loginOperations(registrationInputHandler,registrationManager);
                    boolean userRun = user!= null;
                    if(userRun){
                        System.out.println("\nUser logged in successfully...");
                        System.out.println("\n**************************************************************"+
                                "\nUser Details : "+
                                "\nID : "+user.getUserId()+
                                "\nName : "+user.getUserName()+
                                "\nGender : "+user.getGender()+
                                "\nDOB : "+user.getDateOfBirth()+
                                "\nPhone Number : "+user.getUserPhoneNumber()+
                                "\nWork : "+user.getUserWorkType()+
                                "\nLocation : "+user.getUserLocation()+
                                "\n**************************************************************");                    }
                    else{
                        System.out.println("\nEnter valid id and password...");
                    }
                    while(userRun)
                    {
                        System.out.print("\n\nOperations page\n***************\nEnter 1 for meeting operations\nEnter 2 for task operations\nEnter 3 for birthday operations\nEnter 4 for holiday operations\nEnter 5 to set themes\nEnter 6 to view calendar operations\nEnter 7 to logout\nEnter your choice : ");
                        int choice;
                        try {
                            choice = Integer.parseInt(sc.nextLine().trim());
                        }
                        catch(NumberFormatException numberFormatException) {
                            System.out.println("\nEnter valid option...");
                            continue;
                        }
                        switch(choice){
                            case 1:
                                meetingInputHandler = new MeetingInputHandler();
                                meetingManager = new MeetingManager();
                                operations(meetingInputHandler,meetingManager,user);
                                break;
                            case 2:
                                taskInputHandler = new TaskInputHandler();
                                taskManager= new TaskManager();
                                operations(taskInputHandler,taskManager,user);

                                break;
                            case 3:
                                birthdayInputHandler = new BirthdayInputHandler();
                                birthdayManager = new BirthdayManager();
                                operations(birthdayInputHandler,birthdayManager,user);
                                break;
                            case 4:
                                holidayInputHandler = new HolidayInputHandler();
                                holidayManager = new HolidayManager();
                                operations(holidayInputHandler,holidayManager,user);
                                break;
                            case 5:
                                themeOperator = new ThemeOperator();
                                themeOperations(themeOperator,user);
                                break;
                            case 6:
                                birthdayManager = new BirthdayManager();
                                holidayManager = new HolidayManager();
                                taskManager = new TaskManager();
                                meetingManager = new MeetingManager();
                                calendarHandler = new CalendarHandler();
                                themeOperator = new ThemeOperator();
                                calendarHandler.viewMyCalendar(meetingManager.getAllEventsInfo(user),taskManager.getAllEventsInfo(user),birthdayManager.getAllEventsInfo(user),holidayManager.getAllEventsInfo(user),themeOperator.getUserThemeList(user.getUserId()));
                                break;
                            case 7:
                                userRun = false;
                                break;
                            default:
                                System.out.println("\nEnter valid option...");
                                break;
                        }
                    }
                    break;
                case 3:
                    bool = false;
                    break;
            }
        }
    }
    private void signUpOperations(RegistrationManager registrationManager,RegistrationInputHandler registrationInputHandler,MeetingDataManager meetingDataManager,TaskDataManager taskDataManager,BirthdayDataManager birthdayDataManager,HolidayDataManager holidayDataManager,ThemeOperator themeOperator){
        RegistrationData registrationData = registrationInputHandler.getInputForSignUpOperations();
        User user = registrationManager.userSignUpOperations(registrationData);
        if(user!=null) {
            System.out.println("User signed up successfully...");
            meetingDataManager.createMeetingCalendarForUser(user);
            taskDataManager.createTaskCalendarForUser(user);
            birthdayDataManager.createBirthdayCalendarForUser(user);
            holidayDataManager.createHolidayCalendarForUser(user);
            themeOperator.createThemesForUserCalendar(user.getUserId());
        }
    }
    private User loginOperations(RegistrationInputHandler registrationInputHandler,RegistrationManager registrationManager){
        LoginData loginData = registrationInputHandler.getInputForLogin();
        return registrationManager.userLogin(loginData);
    }


    // Event related operations
    private<T extends Data,U extends Event> void operations(InputHandler<T,U>inputHandler,Manager<T,U> manager,User user){
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while(bool) {
            int choice;
            System.out.print("\n\nEvent page\n************\n\nEnter 1 to create event\nEnter 2 to cancel event\nEnter 3 to update event\nEnter 4 to view event\nEnter 5 to go back to Operations page\nEnter your choice : ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid option...");
                continue;
            }
            switch (choice) {
                case 1:
                    T eventCreationData = inputHandler.getInputForCreatingEvent();
                    manager.addEvent(eventCreationData, user);
                    System.out.println("\nEvent added");
                    break;
                case 2:
                    ArrayList<U> eventsListForDeletion = manager.getAllEventsInfo(user);
                    if (inputHandler.displayAllEvents(eventsListForDeletion)) {
                        int eventId = inputHandler.getInputForFetchingEventId();
                        if(eventId!=-1) {
                            if (manager.removeEvent(eventId, user)) {
                                System.out.println("\nEvent removed");
                            }
                            else{
                                System.out.println("No Event present with that id");
                            }
                        }
                    }
                    break;
                case 3:
                    ArrayList<U> eventsListForModification = manager.getAllEventsInfo(user);
                    if (inputHandler.displayAllEvents(eventsListForModification)) {
                        int toUpdateEventId = inputHandler.getInputForFetchingEventId();
                        if(toUpdateEventId != -1) {
                            T eventModificationData = inputHandler.getInputForUpdatingEvent();
                            if (manager.modifyEvent(toUpdateEventId, eventModificationData, user)) {
                                System.out.println("\nEvent updated");
                            }
                            else{
                                System.out.println("No Event present with that id");
                            }
                        }
                    }
                    break;
                case 4:
                    ArrayList<U> eventsListForViewing = manager.getAllEventsInfo(user);
                    inputHandler.displayAllEvents(eventsListForViewing);
                    break;
                case 5:
                    bool = false;
                    break;
                default:
                    System.out.println("\nEnter valid option...");
                    break;
            }
        }
    }

    private void themeOperations(ThemeOperator themeOperator,User user){
        themeOperator.setThemes(user.getUserId());
    }
}
