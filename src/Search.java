import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Arrays;

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

        GameCollection tempTagList = new GameCollection("TempResults");;
        for (int m = 0; m < results.size(); m++)
        {
            tempTagList.addGame(results.getGameByIndex(m));
        }

        int tempResultsSize = results.size();
        ArrayList<String> tempGameTags = new ArrayList<String>();
        //Narrows down by tag
        boolean check = false;
        if (selectedTags.size() > 0 && results.size() > 0)
        {
            Game tempGame;
            for (int i = 0; i < tempResultsSize; i++)
            {
                tempGame = tempTagList.getGameByIndex(i);
                tempGameTags = tempGame.getTags();
                for (int j = 0; j < tempGameTags.size(); j++)
                {
                    for (int k = 0; k < selectedTags.size(); k++)
                    {
                        if (tempGameTags.get(j).equals(selectedTags.get(k)))
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
