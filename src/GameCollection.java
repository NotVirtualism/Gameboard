import java.io.*;
import java.util.ArrayList;

public class GameCollection {

    ArrayList<Game> list = new ArrayList<Game>();
    private String listname;
    

    /**
     * This is the constructor for the GameCollection class
     * @param name takes in a String for the name of a GameCollection
     */
    public GameCollection(String name) {
        listname = name;
    }

    /**
     * This class simply returns the name of the GameCollection
     * @return listname (which is a String name of a GameCollection)
     */
    public String getName() { return listname; }
    

    /**
     * This class will add a Game g to the GameCollection 
     * @param g is a Game that will be added to the GameCollection
     */
    public void addGame(Game g) {
        list.add(g);
    }

    /* Remove a game from a game collection */

    /**
     * This class removes a game from a GameCollection
     * @param g is a Game that will be removed from the GameCollection
     */
    public void removeGame(Game g) {
        int gameIndex = -1;
        for (Game items : list) {
            if (list.contains(g)) {
                gameIndex = list.indexOf(g);
            }
        }

        if (gameIndex > -1)
        {
            list.remove(gameIndex);
        }
    }

    /* Get a game from a game collection */

    /**
     * This method returns a game g from a GameCollection
     * @param g is a game being searched for in a GameCollection
     * @return the game if it is in the list
     */
    public Game getGame(Game g) {
        int gameIndex = -1;
        for (Game items : list) {
            if (list.contains(g)) {
                gameIndex = list.indexOf(g);
            }
        }

        return list.get(gameIndex);
    }

    /**
     * This method returns a game based on its index in a GameCollection
     * @param i is the index of the game in the GameCollection
     * @return the game based on its index in the list
     */
    public Game getGameByIndex(int i){
        Game game = list.get(i);
        return game;
    }

    /**
     * This class returns the size of the GameCollection
     * @return an int representing the size of a GameCollection 
     */
    public int size(){
        return list.size();
    }

}
