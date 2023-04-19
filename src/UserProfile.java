import java.util.ArrayList;

public class UserProfile {
    private String username;
    private String password;
    ArrayList<Review> userReviews = new ArrayList<>();
    private static UserProfile defaultUser = new UserProfile();
    private static boolean isSignedIn;

    private Library userLibrary = new Library();

    /**
     * Class Constructor for UserProfile
     */
    public UserProfile(){
        username = "None";
        password = "None";
        isSignedIn = false;
    }

    /**
     * Creates a user from inputted Username and password
     * @param usernameInput
     * @param passwordInput
     */
   public UserProfile(String usernameInput, String passwordInput) {
             {
                username = usernameInput;
                password = passwordInput;
            }
    }

    /**
     * Checks if a user is signed in
     * used by the HomeView to determine if a user is signed into a created account or a default account
     * to open the user's library and reviews
     * @return
     */
    public boolean getSignInStatus(){
        return isSignedIn;
    }

    /**
     * Changes a user's sign in status
     * Is used when a user signs out to set their status back to false
     * @param TorF
     */
    public void setSignInStatus(boolean TorF){
        if (TorF) {
            isSignedIn = true;
        }
        else
            isSignedIn = false;
    }

    /**
     * Set method for password
     * unused but would be used in the future for a change password method
     * @param passwordInput
     */
    public void setPassword(String passwordInput){
        password = passwordInput;
    }

    /**
     * Set method for username
     * unused but would be used in the future for a change username method
     * @param usernameInput
     */
    public void setUsername(String usernameInput){
        username = usernameInput;
    }

    /**
     * Returns the user's username
     * @return
     */
    public String getUsername(){
        return username;
    }

    /**
     * Returns the user's password
     * @return
     */
    public String getPassword(){
        return password;
    }

    /**
     * Adds a review to the user
     * @param review
     */
    public void addReview(Review review){
        userReviews.add(review);
    }

    /**
     * Returns all of a user's reviews
     * @return
     */
    public ArrayList<Review> getReviews(){
        return userReviews;
    }

    /**
     * Returns the user's library
     * @return
     */
    public Library getLibrary(){
        return userLibrary;
    }

    /**
     * Method Used for logging in a user
     * Checks the input information to find the user with a matching username and password
     * @param username1
     * @param password1
     * @param uDatabase
     * @return
     */
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
