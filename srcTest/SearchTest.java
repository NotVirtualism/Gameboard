import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SearchTest {

    public static void main(String[] args)
    {
        String inputFile = "bgg90Games.xml";
        try {
            ImportGames importer = new ImportGames(inputFile);
            GameCollection master = importer.retrieveGameList();
            System.out.println(master.size() + " games read in.");
            String test = "Ca";
            ArrayList<String> testTags = new ArrayList<String>();
            testTags.add("Card Game");
            testTags.add("Science Fiction");
            testTags.add("Sports");

            Search search1 = new Search(test, testTags, master);

            GameCollection results = search1.search();

            for (int i = 0; i < results.size(); i++)
            {
                System.out.print(results.getGameByIndex(i).getTitle());
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
