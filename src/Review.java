import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Review {

    private int reviewScore;
    private String reviewText;
    private UserProfile user;
    private String gameName;


    /**
     * This is the Review constructor
     * @param score is the input integer score of the game from 1-10
     * @param text is the input String left by the user
     * @param user is the UserProfile user that left the review
     * @param gameName is the String of the gameName
     */
    public Review(int score, String text, UserProfile user, String gameName)
    {
        reviewScore = score;
        reviewText = text;
        this.user = user;
        this.gameName = gameName;
    }

    /**
     * This method sets the inputted score of a game
     * @param score is the inputted number 1-10
     */
    public void setScore(int score)
    {
        reviewScore = score;
    }

    /**
     * This method returns the inputted score of a game
     * @return an integer reviewScore for a game
     */
    public int getScore()
    {
        return reviewScore;
    }

    /**
     * This method sets the inputted text of a game
     * @param text is the inputted String description
     */
    public void setText(String text)
    {
        reviewText = text;
    }

    /**
     * This method returns the inputted name of a game
     * @return String gameName indicating the name of a game
     */
    public String getGameName()
    {
        return gameName;
    }

    /**
     * This method sets the inputted name of a game
     * @param name is the inputted String of a game's name
     */
    public void setGameName(String name) { gameName = name; }

    /**
     * This method returns the inputted String text description
     * @return String reviewText for a game 
     */
    public String getText()
    {
        return reviewText;
    }

    /**
     * This method sets the user based on the logged-in user
     * @param user is the inputted UserProfile user
     */
    public void setUser(UserProfile user)
    {
        this.user = user;
    }

    /**
     * This method returns the logged-in user entering the review 
     * @return the user that inputted the review
     */
    public UserProfile getUser()
    {
        return user;
    }

    /**
     * This method helps to read a html String of all the inputted data and display the data in ReviewView
     * @return a html String of all the review's information
     */
    public String toString() {
        return "<html>" + Integer.toString(reviewScore) + " " + gameName + "<br/>" + reviewText + "<br/>" + user.getUsername();
    }


}
