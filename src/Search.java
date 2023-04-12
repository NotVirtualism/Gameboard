import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Search {

    ArrayList<String> selectedTags = new ArrayList<String>();
    private GameCollection results = new GameCollection("Results");
    private String searchString;
    private GameCollection searchPool;
    public Search(String text, ArrayList<String> tags, GameCollection pool)
    {
        searchString = text; // Se
        selectedTags = tags; //list of tags
        searchPool = pool;
    }


    public GameCollection search()
    {
        for (int i = 0; i < searchPool.size(); i++)
        {

            String tempGameName = searchPool.getGameByIndex(i).getTitle(); //converts to lowercase?
            tempGameName = tempGameName.toLowerCase();
            searchString = searchString.toLowerCase();
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
            boolean checkGameIn = false;
            System.out.println("Game " + (i + 1) + " checked");

            for (String items : searchPool.getGameByIndex(i).getTags())
            {
                tempGameTagList.add(items);
            }

            for (int m = 0; m < tempTagList.size(); m++)
            {

                for (int j = 0; j < tempGameTagList.size(); j++)
                {
                    int tempSize = results.size();
                    for (int r = 0; r < tempSize; r++)
                    {
                        if (tempTagList.get(m).equals(tempGameTagList.get(j)))
                        {
                            if (searchPool.getGameByIndex(i).equals(results.getGameByIndex(r)))
                            {
                                checkGameIn = true;
                            }
                        }
                    }
                }

            }

            if (!checkGameIn)
            {
                results.addGame(searchPool.getGameByIndex(i));
            }
        }

        return results;
    }

}





