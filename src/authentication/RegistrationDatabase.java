package authentication;
import user.User;
import java.util.ArrayList;
import java.util.HashMap;
class RegistrationDatabase {
    private static RegistrationDatabase registrationDatabase = null;

    private RegistrationDatabase() {}

    public static RegistrationDatabase getInstance() {
        if (registrationDatabase == null) {
            registrationDatabase = new RegistrationDatabase();
        }
        return registrationDatabase;
    }
    private final ArrayList<User> signedUsersList = new ArrayList<>(); // stores the user obj and gives the user after login operation
    private final HashMap<String, String> usersLoginInfo = new HashMap<>(); // stores the loginId and password of the user...Used to check if the user has entered correct id and password...
    public void addUser(User user){
        signedUsersList.add(user);
    }
    User getUser(String userId){
        for(User user : signedUsersList){
            if(user.getUserId().equals(userId))
                return user;
        }
        return null; 
    }

    public HashMap<String, String> getUsersLoginInfo() {
        return usersLoginInfo;
    }

    void addLoginInfo(String id, String password){
        usersLoginInfo.put(id,password);
    }
}
