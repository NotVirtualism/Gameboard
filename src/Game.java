import java.io.*;
import java.util.ArrayList;

public class Game {
    private String title;
    private String thumbnailUrl;
    private String imageUrl;
    private String description;
    private Integer pubYear;
    private Integer rank;
    private String id;

    public Game(String t, String tnUrl, String iUrl, String desc, Integer pYear, Integer r, String id){
        title = t;
        description = desc;
        thumbnailUrl = tnUrl;
        imageUrl = iUrl;
        pubYear = pYear;
        this.id = id;
    }

    public String toString() {
        return "[" + title + ", "+ publicationYear + ", BGG Rank: " + rank + ", BGG ID: " + id + "]";
    }
}
