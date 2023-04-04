import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportTest {
      public static void main(String args[]) {
          String inputFile = "bgg90Games.xml";
          try {
              ImportGames importer = new ImportGames(inputFile);
              GameCollection master = importer.retrieveGameList();
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
