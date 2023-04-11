import java.io.*;
import java.util.ArrayList;

public class GameDatabase {

    static ArrayList<String> tags = new ArrayList<String>();

    protected static void tags(String tagtxt)
    {
        tags.add(tagtxt);
    }

    public ArrayList<String> getTags()
    {
        return tags;
    }
}
