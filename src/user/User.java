package user;
import constants.*;
public class User {

    private final String userName;
    private final String userId;
    private final Gender gender;
    private final String userPassword;
    private final String userWorkType;
    private final String userLocation;
    private final String userPhoneNumber;
    private final String dateOfBirth;

    public User(String userName,String userId,Gender gender, String userPassword, String userWorkType, String userLocation, String userPhoneNumber, String dateOfBirth) {
        this.userName = userName;
        this.userId = userId;
        this.gender = gender;
        this.userPassword = userPassword;
        this.userWorkType = userWorkType;
        this.userLocation = userLocation;
        this.userPhoneNumber = userPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUserWorkType() {
        return userWorkType;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
