import java.io.*;
import java.util.ArrayList;

public class Search {

    ArrayList<String> selectedTags = new ArrayList<String>();
    private GameCollection results = new GameCollection("Results");
    private String searchString;
    private GameCollection searchPool;
    public Search(String text, ArrayList<String> tags, GameCollection pool)
    {
        searchString = text; // Se
        selectedTags = new ArrayList<String>(); //list of tags
        searchPool = pool;
    }


    public GameCollection search()
    {
        for (int i = 0; i < searchPool.size(); i++)
        {
            String tempGameName = searchPool.getGameByIndex(i).getTitle(); //converts to lowercase?
            if (tempGameName.contains(searchString) && tempGameName.indexOf(searchString) == 0)
            {
                results.addGame(searchPool.getGameByIndex(i));
            }
        }

        ArrayList<String> tempTagList = new ArrayList<String>();
        for (int m = 0; m < selectedTags.size(); m++)
        {
            tempTagList.add(selectedTags.get(m));
        }


        for (int i = 0; i < searchPool.size(); i++)
        {
            ArrayList<String> tempGameTagList = new ArrayList<String>();
            int tagSize = searchPool.getGameByIndex(i).getTags().size();

            for (String items : searchPool.getGameByIndex(i).getTags())
            {
                tempGameTagList.add(items);
            }

            for (int j = 0; j < tagSize; j++)
            {
                if (tempTagList.get(i).equals(tempGameTagList.get(j)))
                {
                    results.addGame(searchPool.getGameByIndex(i));
                }
            }
        }

        return results;
    }

}


