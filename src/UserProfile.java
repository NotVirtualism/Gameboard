import java.util.ArrayList;

public class UserProfile {
    private String username;
    private String password;
    ArrayList<Review> userReviews = new ArrayList<>();

    private Library userLibrary = new Library();

    public UserProfile(){
        username = "None";
        password = "None";
    }

    public UserProfile(String usernameInput, String passwordInput){
       /* for(UserProfile user: PUT USER ARRAYLIST FROM DATABASE HERE){
            if(username1.equals(user.getUserName()){

            }
        } */
        username = usernameInput;
        password = passwordInput;
    }

    public void setPassword(String passwordInput){
        password = passwordInput;
    }

    public void setUserName(String usernameInput){
        username = usernameInput;
    }

    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void addReview(Review review){
        userReviews.add(review);
    }

    public ArrayList<Review> getReviews(){
        return userReviews;
    }

    public Library getLibrary(Library library){
        return library;
    }
  /*  public void logIn(){
        if username
    }*/

}
