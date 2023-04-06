import java.io.*;
import java.util.ArrayList;

public class Library {

    ArrayList<GameCollection> gameCollectionList = new ArrayList<GameCollection>();

    public Library()
    {
        gameCollectionList = new ArrayList<GameCollection>();
    }

    public void addGameCollection(GameCollection g)
    {
        gameCollectionList.add(g);
    }
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

}
