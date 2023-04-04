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
        rank = r;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public Integer getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "[" + title + ", "+ pubYear + ", BGG Rank: " + rank + ", BGG ID: " + id + "]";
    }
}
