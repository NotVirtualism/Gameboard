import java.io.*;
import java.util.ArrayList;

public class GameCollection {

    ArrayList<Game> list = new ArrayList<Game>();
    private String listname;

    /* Constructor */
    public GameCollection(String name) {
        listname = name;
    }
    
    public String getGameCollectionName() { return listname; }

    /* Add a game to a GameCollection */
    public void addGame(Game g) {
        list.add(g);
    }

    /* Remove a game from a game collection */
    public void removeGame(Game g) {
        int gameIndex = -1;
        for (Game items : list) {
            if (list.contains(g)) {
                gameIndex = list.indexOf(g);
            }
        }

        list.remove(gameIndex);
    }

    /* Get a game from a game collection */
    public Game getGame(Game g) {
        int gameIndex = -1;
        for (Game items : list) {
            if (list.contains(g)) {
                gameIndex = list.indexOf(g);
            }
        }

        return list.get(gameIndex);
    }

    public Game getGameByIndex(int i){
        return list.get(i);
    }

    public int size(){
        return list.size();
    }

}
