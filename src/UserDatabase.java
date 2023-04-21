import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
public class UserDatabase {
    private static final UserProfile defaultUser = new UserProfile();
    private static ArrayList<UserProfile> allUsers;

    public UserDatabase() throws FileNotFoundException, IOException{
        ImportUserProfiles importer = new ImportUserProfiles("AllUserProfileData.xml");
        allUsers = importer.retrieveUserList();
    }
    public static ArrayList<UserProfile> getAllUsers(){
        return allUsers;
    }

    public static void addUserProfile(UserProfile newUser){
        allUsers.add(newUser);
    }
    public static UserProfile getDefaultUser(){
        defaultUser.setSignInStatus(false);
        return defaultUser;
    }
    public static void exportDatabase() throws IOException, ParserConfigurationException {
        new ExportUserProfile("AllUserProfileData.xml", allUsers);
    }



}
