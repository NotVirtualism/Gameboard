import java.util.ArrayList;

public class UserProfile {
    private String userName;
    private String password;
    ArrayList<Review> userReviews = new ArrayList<>();

    private Library userLibrary = new Library();

    public UserProfile(){
        userName = "None";
        password = "None";
    }

    public UserProfile(String username1, String password1){
        userName = username1;
        password = password1;
    }

    public void setPassword(String password1){
        password = password1;
    }

    public void setUserName(String userName1){
        userName = userName1;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<Review> getReviews(){
        return userReviews;
    }

    public Library getLibrary(Library library){
        return library;
    }

}
