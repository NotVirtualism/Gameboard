import java.io.FileNotFoundException;
import java.io.IOException;

public class UserDatabaseTest {
    public static void main(String[] args) {
        String inputFile = "AllUserProfileData.xml";
        try {
            UserDatabase mainUDB = new UserDatabase(inputFile);
            System.out.println(mainUDB.getAllUsers().size() + " Users read in.");
            System.out.println("User List: \n");
            for(UserProfile user : mainUDB.getAllUsers()) {
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
                System.out.println(user.getReviews().size() + " Reviews");
                for (Review review : user.getReviews()) {
                    System.out.println(review.getScore());
                    System.out.println(review.getText());
                }

            }
        } catch (FileNotFoundException e1) {
            System.err.println("Unable to open file: " + inputFile);
            System.err.println("Exiting program.");
            System.exit(1);
        } catch (IOException e2) {
            System.err.println("Unable to parse the XML document contained in: " + inputFile);
            System.err.println("Exiting program.");
            System.exit(2);
        }
    }
}