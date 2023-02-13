package userInterface;
import constants.HolidayType;
import events.Holiday;
import pojo.inputPojo.HolidayData;
import pojo.ReminderListData;
import utilities.ValidationUtilities;

import java.util.ArrayList;
import java.util.Scanner;

public class HolidayInputHandler extends InputHandler<HolidayData,Holiday>{
    @Override
    public HolidayData getInputForCreatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        System.out.print("\nEnter the holiday event title : ");
        String holidayTitle = sc.nextLine().trim();
        System.out.print("\nEnter the holiday event description : ");
        String holidayDescription = sc.nextLine().trim();
        String holidayDate;
        do{
            System.out.print("\nEnter valid date (dd/mm/yyyy HH:mm:ss): ");
            holidayDate = sc.nextLine().trim();
        }while(ValidationUtilities.validateDate(holidayDate));
        HolidayType holidayType = null;
        String type;
        while (!bool) {
            System.out.print("\nEnter the type of holiday (PUBLIC,RELIGIOUS,NATIONAL)\nEnter 1 for PUBLIC\nEnter 2 for RELIGIOUS\nEnter 3 for NATIONAL\nEnter your choice : ");
            type = sc.nextLine().trim();
            switch (type){
                case "1":
                    holidayType = HolidayType.PUBLIC;
                    bool = true;
                    break;
                case "2":
                    holidayType = HolidayType.RELIGIOUS;
                    bool = true;
                    break;
                case "3":
                    holidayType = HolidayType.NATIONAL;
                    bool = true;
                    break;
                default:
                    System.out.println("Enter valid option..Try again");
                    break;
            }
        }
        ReminderListData reminderListData = getInputForSettingReminder();
        return new HolidayData(holidayTitle,holidayDescription,holidayDate,holidayType,reminderListData);
    }

    @Override
    public int getInputForFetchingEventId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the holiday id (-1 if not available) to cancel/update : ");
        int holidayId = -1;
        try{
            holidayId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
        }
        return holidayId;
    }

    @Override
    public HolidayData getInputForUpdatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean updateBool = true;
        String holidayTitle = null;
        String holidayDescription = null;
        HolidayType holidayType = null;
        while(updateBool) {
            System.out.print("\nEnter 1 to change the holiday title\nEnter 2 to change the holiday description\nEnter 3 to change the holiday type\nEnter 4 to exit\nEnter your choice : ");
            int updateChoice = 0;
            try {
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid information...Please try again");
            }
            switch (updateChoice) {
                case 1:
                    System.out.print("Enter the new title : ");
                    holidayTitle = sc.nextLine().trim();
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    holidayDescription = sc.nextLine().trim();
                    break;
                case 3:
                    boolean b = false;
                    String type;
                    while (!b) {
                        System.out.print("\nEnter the type of holiday (PUBLIC,RELIGIOUS,NATIONAL)\nEnter 1 for PUBLIC\nEnter 2 for RELIGIOUS\nEnter 3 for NATIONAL\nEnter your choice : ");
                        type = sc.nextLine().trim();
                        switch (type){
                            case "1":
                                holidayType = HolidayType.PUBLIC;
                                b = true;
                                break;
                            case "2":
                                holidayType = HolidayType.RELIGIOUS;
                                b = true;
                                break;
                            case "3":
                                holidayType = HolidayType.NATIONAL;
                                b = true;
                                break;
                            default:
                                System.out.println("Enter valid option..Try again");
                                break;
                        }
                    }
                    break;
                case 4:
                    updateBool = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
        return new HolidayData(holidayTitle,holidayDescription,holidayType);
    }
    public boolean displayAllEvents(ArrayList<Holiday> displayList){
        if(displayList.isEmpty()){
            System.out.println("\nNo events available...");
            return false;
        }
        else {
            for(Holiday holiday : displayList){
                System.out.println("\nHoliday ID : "+holiday.getEventId()+"\nHoliday title : "+holiday.getEventTitle()+"\nHoliday description : "+holiday.getEventDescription()+"\nHoliday start date : "+holiday.getEventStartDate()+"\nHoliday type : "+holiday.getHolidayType()+"\nEvent type : "+holiday.getEventType()+"\n-------------------------------------------------------------------------");
            }
        }
        return true;
    }
}
