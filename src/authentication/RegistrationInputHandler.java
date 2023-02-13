package authentication;

import constants.Gender;
import pojo.inputPojo.LoginData;
import pojo.inputPojo.RegistrationData;
import utilities.ValidationUtilities;

import java.util.Scanner;


public class RegistrationInputHandler {
    private static int loginId = 1;
    public RegistrationData getInputForSignUpOperations(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your name : ");
        String name = sc.nextLine().trim();
        System.out.println("\nGenerated LoginId : ");
        String loginId = generateUserLoginId(name);
        Gender gender = null;
        String genderType;
        while (gender == null) {
            try {
                System.out.print("\nEnter your gender (MALE,FEMALE,OTHERS): ");
                genderType = sc.nextLine().trim();
                gender = Gender.valueOf(genderType);
            } catch (IllegalArgumentException illegalArgumentException) {
                gender = null;
                System.out.print("\nEnter valid option..please try again");
            }
        }
        String dateOfBirth;
        do {
            System.out.print("\nEnter your DateOfBirth (MM/DD/YYYY): ");
            dateOfBirth = sc.nextLine().trim();
        } while (!ValidationUtilities.validateDOB(dateOfBirth));
        System.out.print("\nEnter your location : ");
        String location = sc.nextLine().trim();
        String phoneNumber;
        do {
            System.out.print("\nEnter your mobileNumber : ");
            phoneNumber = sc.nextLine().trim();
        } while (ValidationUtilities.validatePhoneNumber(phoneNumber));
        System.out.print("\nEnter your work description : ");
        String workType = sc.nextLine().trim();
        String password;
        do {
            System.out.print("\nPassword must contain at least one digit [0-9].\n\nPassword must contain at least one lowercase character [a-z].\n\nPassword must contain at least one uppercase character [A-Z].\n\nPassword must contain at least one special character like ! @ # & ( ).\n\nPassword must contain a length of at least 8 characters and a maximum of 20 characters.\n\n\nEnter your password : ");
            password = sc.nextLine().trim();
        } while (!ValidationUtilities.validatePassword(password));
        return new RegistrationData(name, loginId, gender, password, workType, location, phoneNumber, dateOfBirth);
    }
    public LoginData getInputForLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your loginID : ");
        String loginId = sc.nextLine().trim();
        System.out.print("\nEnter your password : ");
        String loginPassWord = sc.nextLine().trim();
        return new LoginData(loginId,loginPassWord);
    }
    private String generateUserLoginId(String name){
        String id = "U"+loginId+"_"+name;
        System.out.println("Your generated UserID is "+id);
        loginId += 1;
        return id;
    }
}
