import java.io.*;
import java.util.ArrayList;

public class Library {

    ArrayList<GameCollection> gameCollectionList = new ArrayList<GameCollection>();

    /**
     * This is the Library constructor that has an ArrayList of GameCollections
     */
    public Library()
    {
        gameCollectionList = new ArrayList<GameCollection>();
    }

    /**
     * This method adds a GameCollection to a user's Library
     * @param g is a new GameCollection g that is added to the ArrayList of GameCollections
     */
    public void addGameCollection(GameCollection g)
    {
        gameCollectionList.add(g);
    }

    /**
     * This method removes a GameCollection to a user's Library
     * @param g is a GameCollection g that is removed from the ArrayList of GameCollections
     */
    public void removeGameCollection(GameCollection g)
    {
        int gameIndex = -1;
        for (GameCollection items : gameCollectionList) {
            if (gameCollectionList.contains(g)) {
                gameIndex = gameCollectionList.indexOf(g);
            }
        }

        gameCollectionList.remove(gameIndex);
    }

    /**
     * This method returns a GameCollection based on its index in a Library
     * @param i is the index of the game in the GameCollection
     * @return the GameCollection based on its index in the list
     */
    public GameCollection getGameCollectionByIndex(int i){
        return gameCollectionList.get(i);
    }

    /**
     * This method returns a Library or an ArrayList of GameCollections 
     * @return an ArrayList of GameCollections
     */
    public ArrayList<GameCollection> getCollections() {
        return gameCollectionList;
    }
}
