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

    public void setTitle(String t) {
        title = t;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String tnUrl) {
        thumbnailUrl = tnUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String iUrl) {
        imageUrl = iUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public void setPubYear(Integer pYear) {
        pubYear = pYear;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer r) {
        rank = r;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String toString() {
        return "[" + title + ", "+ pubYear + ", BGG Rank: " + rank + ", BGG ID: " + id + "]";
    }
}
