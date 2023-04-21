import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.util.ArrayList;

public class UserbaseTest {
        public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {
            String outputFile = "Test2.xml";
            try {
                ArrayList<Review> reviewListings = new ArrayList<Review>();
                UserProfile testBot = new UserProfile("Bip", "123");
                Review testReview = new Review(6, "This game was aight ig", testBot, "CATAN");
                Review testReview2 = new Review(10, "This game was awesome ig", testBot, "Star Wars");
                Review testReview3 = new Review(1, "Garbo", testBot, "Monopoly");

                reviewListings.add(testReview);
                reviewListings.add(testReview2);
                reviewListings.add(testReview3);

                GameCollection testGameCollection1 = new GameCollection("AllGames");
                GameCollection testGameCollection2 = new GameCollection("IHateCatan");
                GameCollection testGameCollection3 = new GameCollection("NotCatan");

                Library testLibrary = new Library();
                testLibrary.addGameCollection(testGameCollection1);
                testLibrary.addGameCollection(testGameCollection2);
                testLibrary.addGameCollection(testGameCollection3);

                Game testGame1 = new Game("Catan");
                Game testGame2 = new Game("Monopoly");
                Game testGame3 = new Game("Tic-Tac-Toe");

                testGameCollection1.addGame(testGame1);
                testGameCollection1.addGame(testGame2);
                testGameCollection1.addGame(testGame3);

                testGameCollection2.addGame(testGame1);

                testGameCollection3.addGame(testGame2);
                testGameCollection3.addGame(testGame3);

                //String outputFileName, String user, String pass, ArrayList<Review> reviews, Library library

                new ExportUserProfile(outputFile, UserDatabase.getAllUsers());
                System.out.println("Check Test File");


            } catch (FileNotFoundException e1) {
                System.err.println("Unable to open file: " + outputFile);
                System.err.println("Exiting program.");
                System.exit(1);
            } catch (IOException e2) {
                System.err.println("Unable to parse the XML document contained in: " + outputFile);
                System.err.println("Exiting program.");
                System.exit(2);
            }
        }
    }

