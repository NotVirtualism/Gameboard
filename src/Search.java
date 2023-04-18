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
        //Searches by string inputted
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

        ArrayList<String> tempGameTags = new ArrayList<String>();
        //Narrows down by tag
        boolean check = false;
        if (selectedTags.size() > 0 && results.size() > 0)
        {
            Game tempGame;
            for (int i = 0; i < results.size(); i++)
            {
                tempGame = results.getGameByIndex(i);
                tempGameTags = tempGame.getTags();
                for (int j = 0; j < selectedTags.size(); j++)
                {
                    for (int k = 0; k < tempGameTags.size(); k++)
                    {
                        if (selectedTags.get(j).equals(tempGameTags.get(k)))
                        {
                            check = true;
                        }
                    }
                }

                if (check == false)
                {
                    results.removeGame(tempGame);
                }

                check = false;
            }
        }

        //search just by tag
        String emptyString = "";
        if (searchString.equals(emptyString))
        {
            boolean checkGameIn = false;
            for (int i = 0; i < searchPool.size(); i++)
            {
                ArrayList<String> tempGameTagList = new ArrayList<String>();
                System.out.println("Game " + (i + 1) + " checked");

                for (String items : searchPool.getGameByIndex(i).getTags())
                {
                    tempGameTagList.add(items);
                }

                for (int m = 0; m < selectedTags.size(); m++)
                {

                    for (int j = 0; j < tempGameTagList.size(); j++)
                    {
                        if (selectedTags.get(m).equals(tempGameTagList.get(j)))
                        {
                            checkGameIn = true;
                        }
                    }

                }

                if (checkGameIn == true)
                {
                    results.addGame(searchPool.getGameByIndex(i));
                }

                checkGameIn = false;
            }
        }

        return results;
    }

}