package userInterface;
import constants.Gender;
import events.Birthday;
import pojo.inputPojo.BirthdayData;
import pojo.ReminderListData;
import utilities.ValidationUtilities;
import java.util.ArrayList;
import java.util.Scanner;

public class BirthdayInputHandler extends InputHandler<BirthdayData, Birthday>{
    @Override
    public BirthdayData getInputForCreatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        System.out.print("\nEnter the contact name : ");
        String contactName = sc.nextLine().trim();
        System.out.print("\nEnter the birthday event title : ");
        String birthdayTitle = sc.nextLine().trim();
        System.out.print("\nEnter the birthday event description : ");
        String birthdayDescription = sc.nextLine().trim();
        String dateOfBirth;
        do{
            System.out.print("\nEnter valid dateOfBirth (dd/mm/yyyy HH:mm:ss): ");
            dateOfBirth = sc.nextLine().trim();
        }while(ValidationUtilities.validateDate(dateOfBirth));
        String phoneNumber;
        do {
            System.out.print("\nEnter mobileNumber : ");
            phoneNumber = sc.nextLine().trim();
        } while (ValidationUtilities.validatePhoneNumber(phoneNumber));
        Gender gender = null;
        String genderType;
        while (!bool) {
            System.out.print("\nEnter the type of the gender(MALE or FEMALE or OTHERS)\nEnter 1 for MALE\nEnter 2 for FEMALE\nEnter 3 for OTHERS\nEnter your choice : ");
            genderType = sc.nextLine().trim();
            switch (genderType){
                case "1":
                    gender = Gender.MALE;
                    bool = true;
                    break;
                case "2":
                    gender = Gender.FEMALE;
                    bool = true;
                    break;
                case "3":
                    gender = Gender.OTHERS;
                    bool = true;
                    break;
                default:
                    System.out.println("Enter valid option..Try again");
                    break;
            }
        }
        System.out.print("\nEnter the job title : ");
        String jobTitle = sc.nextLine().trim();
        System.out.print("\nEnter the location : ");
        String location = sc.nextLine().trim();
        ReminderListData reminderListData = getInputForSettingReminder();
        return new BirthdayData(birthdayTitle,birthdayDescription,dateOfBirth,contactName,phoneNumber,gender,jobTitle,location,reminderListData);
    }

    @Override
    public int getInputForFetchingEventId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the birthday id (-1 if not available) to cancel/update : ");
        int birthdayId = -1;
        try{
            birthdayId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
        }
        return birthdayId;

    }

    @Override
    public BirthdayData getInputForUpdatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean updateBool = true;
        String birthdayTitle = null;
        String birthdayDescription = null;
        String contactName = null;
        String mobileNumber = null;
        Gender gender = null;
        String jobTitle = null;
        String location = null;
        while(updateBool) {
            System.out.print("\nEnter 1 to change the eventTitle\nEnter 3 to change the eventDescription\nEnter 3 to change the contact name\nEnter 4 to change the mobileNumber\nEnter 5 to change the gender\nEnter 6 to change the jobTitle\nEnter 7 to change the location\nEnter 8 to exit\nEnter your choice : ");
            int updateChoice = 0;
            try {
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid information...Please try again");
            }
            switch (updateChoice) {
                case 1:
                    System.out.print("Enter the new title : ");
                    birthdayTitle = sc.nextLine().trim();
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    birthdayDescription = sc.nextLine().trim();
                    break;
                case 3:
                    System.out.print("Enter the new contact Name : ");
                    contactName = sc.nextLine().trim();
                    break;
                case 4:
                    System.out.print("Enter the new mobileNumber: ");
                    mobileNumber = sc.nextLine().trim();
                    break;
                case 5:
                    boolean b = false;
                    String genderType;
                    while (!b) {
                        System.out.print("\nEnter the type of the gender(MALE or FEMALE or OTHERS)\nEnter 1 for MALE\nEnter 2 for FEMALE\nEnter 3 for OTHERS\nEnter your choice : ");
                        genderType = sc.nextLine().trim();
                        switch (genderType){
                            case "1":
                                gender = Gender.MALE;
                                b = true;
                                break;
                            case "2":
                                gender = Gender.FEMALE;
                                b = true;
                                break;
                            case "3":
                                gender = Gender.OTHERS;
                                b = true;
                                break;
                            default:
                                System.out.println("Enter valid option..Try again");
                                break;
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter the new jobTitle: ");
                    jobTitle = sc.nextLine().trim();
                    break;
                case 7:
                    System.out.print("Enter the new location: ");
                    location = sc.nextLine().trim();
                    break;
                case 8:
                    updateBool = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
        return new BirthdayData(birthdayTitle,birthdayDescription,contactName,mobileNumber,gender,jobTitle,location);
    }
    public boolean displayAllEvents(ArrayList<Birthday> displayList){
        if(displayList.isEmpty()){
            System.out.println("\nNo events available...");
            return false;
        }
        else {
            for(Birthday birthday : displayList){
                System.out.println("\nBirthday ID : "+birthday.getEventId()+"\nBirthday title : "+birthday.getEventTitle()+"\nBirthday description : "+birthday.getEventDescription()+"\nDate of Birth : "+birthday.getEventStartDate()+"\nContact name : "+birthday.getContactName()+"\nPhone Number : "+birthday.getPhoneNumber()+"\n Gender : "+birthday.getGender()+"\nJob title : "+birthday.getJobTitle()+"\nLocation : "+birthday.getLocation()+"\nEvent type : "+birthday.getEventType()+"\n-------------------------------------------------------------------------");
            }
        }
        return true;
    }
}
