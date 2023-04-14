import java.io.*;
import java.util.ArrayList;

public class Game {
    private String title;
    private String thumbnailUrl;
    private String imageUrl;
    private String description;
    private Integer pubYear;
    private String id;
    private ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private ArrayList<String> authors = new ArrayList<String>();
    private ArrayList<String> publishers = new ArrayList<String>();
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer minPlayTime;
    private Integer maxPlayTime;

    public Game(String t, String tnUrl, String iUrl, String desc, Integer pYear, String id, Integer mP, Integer MP, Integer mPT, Integer MPT){
        title = t;
        description = desc;
        thumbnailUrl = tnUrl;
        imageUrl = iUrl;
        pubYear = pYear;
        this.id = id;
        minPlayers = mP;
        maxPlayers = MP;
        minPlayTime = mPT;
        maxPlayTime = MPT;
    }
    
    public Game(String t) {
        title = t;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public void addAuthor(String aut){
        authors.add(aut);
    }

    public void addPublisher(String pub){
        publishers.add(pub);
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

    public String getId() {
        return id;
    }

    public ArrayList<String> getTags(){
        return tags;
    }
    public ArrayList<Review> getReviews() { return reviews; }
    public ArrayList<String> getAuthors() { return authors; }
    public ArrayList<String> getPublishers() { return publishers; }
    public Integer getMinPlayers() { return minPlayers; }
    public Integer getMaxPlayers() { return maxPlayers; }
    public Integer getMinPlayTime() { return minPlayTime; }
    public Integer getMaxPlayTime() { return maxPlayTime; }
    public String toString() {
        return "[" + title + ", "+ pubYear + ", BGG ID: " + id + "]";
    }
}
