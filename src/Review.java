import java.io.*;
import java.util.ArrayList;

public class Review {

    private int reviewScore;
    private String reviewText;
    private UserProfile user;


    public Review(int score, String text, UserProfile user)
    {
        reviewScore = score;
        reviewText = text;
        this.user = user;
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

    public void setUser(UserProfile user)
    {
        this.user = user;
    }

    public UserProfile getUser()
    {
        return user;
    }


}
