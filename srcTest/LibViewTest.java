import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LibViewTest {
    public static void main(String args[]) {
        String inputFile = "bgg90Games.xml";
        try {
            GameDatabase mainGDB = new GameDatabase(inputFile);
            GameCollection master = mainGDB.getMasterList();
            Library lib = new Library();
            Search s = new Search("Ca", new ArrayList<String>(), master);
            GameCollection gc = s.search();
            lib.addGameCollection(gc);
            LibraryView viewTest = new LibraryView(lib);
            viewTest.view();
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
