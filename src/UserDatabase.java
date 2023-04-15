import java.io.*;
import java.util.ArrayList;
public class UserDatabase {
    private final UserProfile defaultUser = new UserProfile();
    private ArrayList<UserProfile> allUsers;

    public UserDatabase(String inFile) throws FileNotFoundException, IOException{
        ImportUserProfiles importer = new ImportUserProfiles(inFile);
        allUsers = importer.retrieveUserList();
    }
    public ArrayList<UserProfile> getAllUsers(){
        return allUsers;
    }

    public void addUserProfile(UserProfile newUser){
        allUsers.add(newUser);
    }
    public UserProfile getDefaultUser(){
        defaultUser.setSignInStatus(false);
        return defaultUser;
    }




}
