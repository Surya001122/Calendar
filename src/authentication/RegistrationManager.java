package authentication;
import pojo.inputPojo.LoginData;
import pojo.inputPojo.RegistrationData;
import user.User;

public class RegistrationManager {
    private final RegistrationDatabase registrationDatabase = RegistrationDatabase.getInstance();
    public User userSignUpOperations(RegistrationData registrationData) {
        User user;
        if (registrationDatabase.getUsersLoginInfo().containsKey(registrationData.userId)) {
            return null;
        }
        else {
            user = new User(registrationData.userName, registrationData.userId, registrationData.gender, registrationData.userPassword, registrationData.userWorkType, registrationData.userLocation, registrationData.userPhoneNumber, registrationData.dateOfBirth);
            RegistrationDatabase.getInstance().addUser(user);
            registrationDatabase.addLoginInfo(registrationData.userId, registrationData.userPassword);
            return user;
        }
    }
    public User userLogin(LoginData loginData){
        if((!registrationDatabase.getUsersLoginInfo().containsKey(loginData.loginId) || (!registrationDatabase.getUsersLoginInfo().get(loginData.loginId).equals(loginData.loginPassword)))){
            return null;
        }
        return registrationDatabase.getUser(loginData.loginId);
    }

}
