import java.util.ArrayList;

public class UserProfile {
    private String username;
    private String password;
    ArrayList<Review> userReviews = new ArrayList<>();
    private static UserProfile defaultUser = new UserProfile();
    private static boolean isSignedIn;

    private Library userLibrary = new Library();

    public UserProfile(){
        username = "None";
        password = "None";
        isSignedIn = false;
    }

   public UserProfile(String usernameInput, String passwordInput) {
             {
                username = usernameInput;
                password = passwordInput;
            }
    }
    public boolean getSignInStatus(){
        return isSignedIn;
    }
    public void setSignInStatus(boolean TorF){
        if (TorF) {
            isSignedIn = true;
        }
        else
            isSignedIn = false;
    }

    public void setPassword(String passwordInput){
        password = passwordInput;
    }

    public void setUsername(String usernameInput){
        username = usernameInput;
    }

    public String getUsername(){
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

    public Library getLibrary(){
        return userLibrary;
    }
    public  UserProfile logIn(String username1, String password1, UserDatabase uDatabase){

        for (UserProfile user: uDatabase.getAllUsers()){

            if (username1.equals(user.getUsername())){
                if (password1.equals(user.getPassword())){
                    isSignedIn = true;

                    return user;
                }
            }
        }
        return uDatabase.getDefaultUser();
    }

}
