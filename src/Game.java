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

    /**
     * Constructs a game from the parameters.
     * @param t the game's title.
     * @param tnUrl the game's Thumbnail URL.
     * @param iUrl the game's Image URL.
     * @param desc the game's description.
     * @param pYear the year the game was published.
     * @param id the game's ID.
     * @param mP the minimum number of players for the game.
     * @param MP the maximum number of players for the game.
     * @param mPT the minimum play time of the game.
     * @param MPT the maximum play time of the game.
     */
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

    /**
     * Constructs a game with only the title.
     * @param t the title of the game.
     */
    public Game(String t) {
        title = t;
    }

    /**
     * Adds a tag to the game's Array List of tags.
     * @param tag the tag to be added to the game's Array List of tags.
     */
    public void addTag(String tag){
        tags.add(tag);
    }

    /**
     * Adds a review to the game's Array List of reviews
     * @param review the review to be added to the game's Array List of reviews.
     */
    public void addReview(Review review){
        reviews.add(review);
    }

    /**
     * Adds an author to the game's Array List of authors
     * @param aut the author to be added to the game's Array List of authors.
     */
    public void addAuthor(String aut){
        authors.add(aut);
    }

    /**
     * Adds a publisher to the game's Array List of publishers
     * @param pub the publisher to be added to the game's Array List of publishers.
     */
    public void addPublisher(String pub){
        publishers.add(pub);
    }

    /**
     * Returns the title of the game for use elsewhere in the project.
     * @return the title of the game.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the string for the game's thumbnail URL for use elsewhere in the project.
     * @return the game's thumbnail URL.
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * Returns the string for the game's image URL for use elsewhere in the project.
     * @return the game's image URL.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Returns the game's description for use elsewhere in the project.
     * @return the game's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the game's publication year for use elsewhere in the project.
     * @return the game's publication year.
     */
    public Integer getPubYear() {
        return pubYear;
    }

    /**
     * Returns the game's ID for use elsewhere in the project.
     * @return the game's ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the Array List of the game's tags for use elsewhere in the project.
     * @return the Array List of the game's tags.
     */
    public ArrayList<String> getTags(){
        return tags;
    }

    /**
     * Returns the Array List of the game's reviews for use elsewhere in the project.
     * @return the Array List of the game's reviews.
     */
    public ArrayList<Review> getReviews() { return reviews; }

    /**
     * Returns the Array List of the game's authors for use elsewhere in the project.
     * @return the Array List of the game's authors.
     */
    public ArrayList<String> getAuthors() { return authors; }

    /**
     * Returns the Array List of the game's publishers for use elsewhere in the project.
     * @return the Array List of the game's publishers.
     */
    public ArrayList<String> getPublishers() { return publishers; }

    /**
     * Returns the minimum number of players for the game for use elsewhere in the project.
     * @return the minimum number of players for the game.
     */
    public Integer getMinPlayers() { return minPlayers; }

    /**
     * Returns the maximum number of players for the game for use elsewhere in the project.
     * @return the maximum number of players for the game.
     */
    public Integer getMaxPlayers() { return maxPlayers; }

    /**
     * Returns the minimum play time for the game for use elsewhere in the project.
     * @return the minimum play time for the game.
     */
    public Integer getMinPlayTime() { return minPlayTime; }

    /**
     * Returns the maximum play time for the game for use elsewhere in the project.
     * @return the maximum play time for the game.
     */
    public Integer getMaxPlayTime() { return maxPlayTime; }

    /**
     * Gives a string representation of the game contents.
     * @return a string with the game's information.
     */
    public String toString() {
        return "[" + title + ", "+ pubYear + ", BGG ID: " + id + "]";
    }
}
