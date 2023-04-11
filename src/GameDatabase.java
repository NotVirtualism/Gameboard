import java.io.*;
import java.util.ArrayList;

public class GameDatabase {


    static ArrayList<String> tags = new ArrayList<String>();
    private GameCollection master;
    private String fileName;

    /**
     * Instantiates a Game Database by reading in the XML file at the given location.
     * Game Database will hold the master list of all games in the program as well as all tags a game can have for the
     * Search class.
     * @param inFile - The XML file location
     * @throws FileNotFoundException
     * @throws IOException
     */
    public GameDatabase(String inFile) throws FileNotFoundException, IOException{
        ImportGames importer = new ImportGames(inFile);
        master = importer.retrieveGameList();
        Game current;
        for(int i = 0; i < master.size(); i++){
            current = master.getGameByIndex(i);
            for(String s: current.getTags())
                addTag(s);
        }
    }

    /**
     * Adds a tag to the universal search tag list (stored here).
     * First checks if tagtxt is not already in the list and adds if not.
     * @param tagtxt - the tag to add to the list
     */
    protected static void addTag(String tagtxt)
    {
        boolean in = false;
        for(String t : tags) {
            if(!in)
                in = t.equals(tagtxt);
        }
        if(!in)
            tags.add(tagtxt);
    }

    /**
     * Returns the master GameCollection.
     * @return Collection of all Games in program.
     */
    public GameCollection getMasterList(){
        return master;
    }

    /**
     * Returns all possible search tags.
     * @return ArrayList of game tags.
     */
    public ArrayList<String> getTags()
    {
        return tags;
    }
}
