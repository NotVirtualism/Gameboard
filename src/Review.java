import java.io.*;
import java.util.ArrayList;

public class Review {

    private int reviewScore;
    private String reviewText;
    private UserProfile user;
    private String gameName;


    public Review(int score, String text, UserProfile user, String gameName)
    {
        reviewScore = score;
        reviewText = text;
        this.user = user;
        this.gameName = gameName;
    }

    public void setScore(int score)
    {
        reviewScore = score;
    }

    public int getScore()
    {
        return reviewScore;
    }

    public void setText(String text)
    {
        reviewText = text;
    }

    public String getText()
    {
        return reviewText;
    }
    
    public String getGameName()
    {
        return gameName;
    }

    public void setGameName(String name) 
    { 
        gameName = name; 
    }

    public void setUser(UserProfile user)
    {
        this.user = user;
    }

    public UserProfile getUser()
    {
        return user;
    }


}
