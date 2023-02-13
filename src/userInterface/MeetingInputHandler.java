package userInterface;
import constants.AttendeeType;
import constants.MeetingType;
import events.Meeting;
import pojo.inputPojo.MeetingData;
import pojo.ReminderListData;
import utilities.ValidationUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MeetingInputHandler extends InputHandler<MeetingData, Meeting>{
    @Override
    public MeetingData getInputForCreatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        System.out.print("\nEnter the meeting title : ");
        String meetingTitle = sc.nextLine().trim();
        System.out.print("\nEnter the meeting description : ");
        String meetingDescription = sc.nextLine().trim();
        String meetingStartDate;
        do {
            System.out.print("\nEnter valid meeting startDate (dd/mm/yyyy HH:mm:ss): ");
            meetingStartDate = sc.nextLine().trim();
        } while (ValidationUtilities.validateDate(meetingStartDate));
        String meetingEndDate;
        do {
            System.out.print("\nEnter valid meeting endDate (dd/mm/yyyy HH:mm:ss): ");
            meetingEndDate = sc.nextLine().trim();
        } while (ValidationUtilities.validateDate(meetingEndDate));
        System.out.print("\nEnter the location of the meetingPlace : ");
        String meetingLocation = sc.nextLine().trim();
        MeetingType typeOfMeeting = null;
        while (!bool) {
            System.out.print("\nEnter the type of the meeting : (ONLINE OR OFFLINE)\nEnter 1 for ONLINE\nEnter 2 for OFFLINE\nEnter your choice : ");
            String attenderType = sc.nextLine().trim();
            switch (attenderType){
                case "1":
                    typeOfMeeting = MeetingType.ONLINE;
                    bool = true;
                    break;
                case "2":
                    typeOfMeeting = MeetingType.OFFLINE;
                    bool = true;
                    break;
                default:
                    System.out.println("Enter valid option..Try again");
                    break;
            }
        }
        boolean attenderBool = true;
        int attenderId = 1;
        HashMap<String, AttendeeType> meetingAttendees = new HashMap<>();
        while (attenderBool) {
            bool = false;
            int meetingChoice = 0;
            while (!bool) {
                System.out.print("\nEnter 1 to add attendees\nEnter 2 to exit\nEnter your choice : ");
                try {
                    meetingChoice = Integer.parseInt(sc.nextLine().trim());
                    bool = true;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("\nEnter valid information...Please try again");
                }
            }
            switch (meetingChoice) {
                case 1:
                    boolean b = false;
                    System.out.print("\nEnter the name of the attender : ");
                    String attendeeName = "A"+attenderId+"_"+sc.nextLine().trim();
                    attenderId++;
                    AttendeeType attendeeType = null;
                    while (!b) {
                        System.out.print("\nEnter the type of the attendee(PRESENTER or ORGANIZER)\nEnter 1 for PRESENTER\nEnter 2 for ORGANIZER\nEnter your choice : ");
                        String attenderType = sc.nextLine().trim();
                        switch (attenderType){
                            case "1":
                                attendeeType = AttendeeType.PRESENTER;
                                b = true;
                                break;
                            case "2":
                                attendeeType = AttendeeType.ORGANIZER;
                                b = true;
                                break;
                            default:
                                System.out.println("Enter valid option..Try again");
                                break;
                        }
                    }
                    meetingAttendees.put(attendeeName,attendeeType);
                    break;
                case 2:
                    attenderBool = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
        ReminderListData reminderListData = getInputForSettingReminder();
        return new MeetingData(meetingTitle, meetingDescription, meetingStartDate, meetingEndDate, meetingLocation, typeOfMeeting, meetingAttendees, reminderListData);

    }

    @Override
    public int getInputForFetchingEventId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the meeting id (-1 if not available) to cancel/update : ");
        int meetingId = -1;
        try{
            meetingId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
        }
        return meetingId;
    }

    @Override
    public MeetingData getInputForUpdatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean updateBool = true;
        String meetingTitle = null;
        String meetingDescription = null;
        String meetingLocation = null;
        MeetingType meetingType =  null;
        while(updateBool) {
            System.out.print("\nEnter 1 to change the meeting title\nEnter 2 to change the meeting description\nEnter 3 to change the meeting location\nEnter 4 to change the meeting type (ONLINE or OFFLINE)\nEnter 5 to exit\nEnter your choice : ");
            int updateChoice = 0;
            try {
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid information...Please try again");
            }
            switch (updateChoice) {
                case 1:
                    System.out.print("Enter the new title : ");
                    meetingTitle = sc.nextLine().trim();
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    meetingDescription = sc.nextLine().trim();
                    break;
                case 3:
                    System.out.print("Enter the new location: ");
                    meetingLocation = sc.nextLine().trim();
                    break;
                case 4:
                    boolean bool = false;
                    while (!bool) {
                        System.out.print("\nEnter the type of the meeting : (ONLINE OR OFFLINE)\nEnter 1 for ONLINE\nEnter 2 for OFFLINE\nEnter your choice : ");
                        String attenderType = sc.nextLine().trim();
                        switch (attenderType){
                            case "1":
                                meetingType = MeetingType.ONLINE;
                                bool = true;
                                break;
                            case "2":
                                meetingType = MeetingType.OFFLINE;
                                bool = true;
                                break;
                            default:
                                System.out.println("Enter valid option..Try again");
                                break;
                        }
                    }
                    break;
                case 5:
                    updateBool = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
        return new MeetingData(meetingTitle,meetingDescription,meetingLocation,meetingType);
    }
    public boolean displayAllEvents(ArrayList<Meeting> displayList){
        if(displayList.isEmpty()){
            System.out.println("\nNo meetings available...");
            return false;
        }
        else {
            for(Meeting meeting : displayList){
                System.out.println("\nMeeting ID : "+meeting.getEventId()+"\nMeeting title : "+meeting.getEventTitle()+"\nMeeting description : "+meeting.getEventDescription()+"\nMeeting start date : "+meeting.getEventStartDate()+"\nMeeting end date : "+meeting.getMeetingEndDate()+"\nMeeting location : "+meeting.getMeetingLocation()+"\nMeeting type : "+meeting.getMeetingType()+"\nEvent type : "+meeting.getEventType()+"\n-------------------------------------------------------------------------");
                if(meeting.getAttendees().isEmpty()){
                    System.out.println("No attendees present in this meeting...");
                }
                else{
                    System.out.println("\nAttendees list for this meeting: ");
                    for(String name : meeting.getAttendees().keySet()){
                        System.out.println(name+" "+meeting.getAttendees().get(name));
                    }
                }
                System.out.println("************************");
            }
        }
        return true;
    }
}
