import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
public class UserDatabase {
    private static final UserProfile defaultUser = new UserProfile();
    private static ArrayList<UserProfile> allUsers;

    /**
     * Constructor for the UserDatabase
     * @throws FileNotFoundException
     * @throws IOException
     */
    public UserDatabase() throws FileNotFoundException, IOException{
        ImportUserProfiles importer = new ImportUserProfiles("AllUserProfileData.xml");
        allUsers = importer.retrieveUserList();
    }

    /**
     * Returns the master list of all users
     * @return allUsers
     */
    public static ArrayList<UserProfile> getAllUsers(){
        return allUsers;
    }
    /**
     * Adds a UserProfile to the Database
     */
    public static void addUserProfile(UserProfile newUser){
        allUsers.add(newUser);
    }

    /**
     * Returns the default signed out user
     * @return defaultUser
     */
    public static UserProfile getDefaultUser(){
        defaultUser.setSignInStatus(false);
        return defaultUser;
    }
    /**
     * Exports The Database
     * Sends database to the exporter, printing to a xlm file
     */
    public static void exportDatabase() throws IOException, ParserConfigurationException {
        new ExportUserProfile("AllUserProfileData.xml", allUsers);
    }



}
