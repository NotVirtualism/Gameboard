import java.io.FileNotFoundException;
import java.io.IOException;

public class DatabaseTest {
      public static void main(String args[]) {
          String inputFile = "bgg90Games.xml";
          try {
              GameDatabase mainGDB = new GameDatabase(inputFile);
              GameCollection master = mainGDB.getMasterList();
              System.out.println(master.size() + " games read in.");
              System.out.println("Tag list: \n");
              for(String s : mainGDB.getTags()){
                  System.out.println(s);
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
