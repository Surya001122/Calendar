package pojo.inputPojo;

import constants.Gender;

public class RegistrationData {
    public final String userName;
    public final String userId;
    public final Gender gender;
    public final String userPassword;
    public final String userWorkType;
    public final String userLocation;
    public final String userPhoneNumber;
    public final String dateOfBirth;

    public RegistrationData(String userName, String userId, Gender gender, String userPassword, String userWorkType, String userLocation, String userPhoneNumber, String dateOfBirth) {
        this.userName = userName;
        this.userId = userId;
        this.gender = gender;
        this.userPassword = userPassword;
        this.userWorkType = userWorkType;
        this.userLocation = userLocation;
        this.userPhoneNumber = userPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
