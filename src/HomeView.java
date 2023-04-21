import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;




public class HomeView {
    private static final JTabbedPane homeTabbedWindow = new JTabbedPane();
    private static JPanel gameTab = new JPanel();
    private static JScrollPane recGamesTab = new JScrollPane();
    private static JScrollPane resultsTab = new JScrollPane();
    private static JPanel libraryTab = new JPanel();
    private static boolean gameOpened;
    private static boolean resultsOpened;
    private static UserProfile currentUser = new UserProfile();
    private static JPanel reviewTab = new JPanel();


    /**
     * Class Constructor for HomeView Screen
     * The HomeView hold's the objects related to signing in
     * The HomeView also holds a tabbed pane that displays the other views
     */
    public static void homeView() throws IOException {
        new UserDatabase();

        //Buttons and Text Fields

        JButton signInButton = new JButton("Sign In");
        JButton signOutButton = new JButton("Sign Out");
        JButton createAccountButton = new JButton("Create Account");
        JButton homeButton = new JButton("GAMEBOARD");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel signInError = new JLabel();
        JLabel usernameText = new JLabel("Username:");
        JLabel passwordText = new JLabel("Password:");
        JLabel currentUsername = new JLabel();

        //HomeBar

        JPanel homeBar = new JPanel();
        homeBar.setLayout(new GridBagLayout());
        GridBagConstraints homeBarRestraints = new GridBagConstraints();

        //HomeButton Formatting

        homeBarRestraints.fill = GridBagConstraints.HORIZONTAL;
        homeBarRestraints.ipady = 80;
        homeBarRestraints.weightx = 0.75;
        homeBarRestraints.gridwidth = 2;
        homeBarRestraints.gridheight = 2;
        homeBarRestraints.gridx = 0;
        homeBarRestraints.gridy = 0;
        homeBar.add(homeButton, homeBarRestraints);

        //Username Text Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.005;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 3;
        homeBarRestraints.gridy = 0;
        homeBar.add(usernameText, homeBarRestraints);

        //Password Text Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.005;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 3;
        homeBarRestraints.gridy = 1;
        homeBar.add(passwordText, homeBarRestraints);

        //Username Field Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 0;
        homeBar.add(usernameField, homeBarRestraints);

        //Password Field Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 1;
        homeBar.add(passwordField, homeBarRestraints);

        //Sign In Button Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.weightx = 0.05;
        homeBarRestraints.gridx = 5;
        homeBarRestraints.gridy = 0;
        homeBar.add(signInButton, homeBarRestraints);

        //Create Account Button Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.weightx = 0.05;
        homeBarRestraints.gridx = 5;
        homeBarRestraints.gridy = 1;
        homeBar.add(createAccountButton, homeBarRestraints);

        //Login Related Error Messages

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 3;
        homeBar.add(signInError, homeBarRestraints);

        //Sign Out Button Formatting

        homeBarRestraints.ipady = 80;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 2;
        homeBarRestraints.weightx = 0.25;
        homeBarRestraints.gridx = 5;
        homeBarRestraints.gridy = 0;
        homeBar.add(signOutButton, homeBarRestraints);
        signOutButton.setVisible(false);

        //Current Username Field Formatting

        homeBarRestraints.ipady = 80;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 2;
        homeBarRestraints.weightx = 0.25;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 0;
        homeBar.add(currentUsername, homeBarRestraints);
        signOutButton.setVisible(false);

        //Recommended Games Tab

        GameDatabase mainGDB = new GameDatabase("bgg90Games.xml");
        recGamesTab = new RecommendedGames(currentUser).getRecommendView().view();
        homeTabbedWindow.add("Recommended Games", recGamesTab);

        //Search Tab

        SearchView sv = new SearchView(mainGDB.getTags());
        homeTabbedWindow.add("Search",sv.view());

        //Game Tab

        Game game = new Game("title", "thumbnailUrl", "imageUrl", "description", 0, "id", 0, 0, 0, 0);
        Review gameReview = new Review(0, "text", currentUser, "game name");
        for (int counter = 0; counter < 20; counter++)
        {
            game.addReview(gameReview);
        }

        //The Entire Frame

        JFrame homeFrame = new JFrame();
        homeFrame.setBounds(0,0,1920,1080);
        homeFrame.add(homeBar, BorderLayout.NORTH);
        homeFrame.add(homeTabbedWindow, BorderLayout.CENTER);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setVisible(true);

        //Sign In Button Handling

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput;
                String passwordInput;
                usernameInput = usernameField.getText();
                passwordInput = String.valueOf(passwordField.getPassword());
                currentUser = currentUser.logIn(usernameInput, passwordInput);

                if (currentUser.getSignInStatus()) {
                    usernameText.setVisible(false);
                    usernameField.setVisible(false);
                    passwordText.setVisible(false);
                    passwordField.setVisible(false);
                    createAccountButton.setVisible(false);
                    signInButton.setVisible(false);
                    signInError.setVisible(false);
                    currentUsername.setText(currentUser.getUsername());
                    currentUsername.setVisible(true);
                    signOutButton.setVisible(true);
                    openUserProfileTabs();
                    homeTabbedWindow.remove(recGamesTab);
                    try {
                        recGamesTab = new RecommendedGames(currentUser).getRecommendView().view();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    homeTabbedWindow.add("Recommended Games", recGamesTab);
                    try {
                        UserDatabase.exportDatabase();
                    } catch (IOException | ParserConfigurationException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                else {
                    signInError.setText("Information Entered is Incorrect or the Account Does Not Exist");
                }


            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean dupeAccount = false;
                String usernameInput;
                String passwordInput;
                usernameInput = usernameField.getText();
                passwordInput = String.valueOf(passwordField.getPassword());
                for (UserProfile user : UserDatabase.getAllUsers()) {
                    if (usernameInput.equals(user.getUsername())) {
                        signInError.setText("Username is Taken");
                        dupeAccount = true;
                    }
                }
                if (!dupeAccount) {
                    UserProfile registeredUser = new UserProfile(usernameInput, passwordInput);
                    UserDatabase.addUserProfile(registeredUser);
                    signInError.setText("");
                    try {
                        UserDatabase.exportDatabase();
                    } catch (IOException | ParserConfigurationException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                signInError.setText("");
                currentUser = UserDatabase.getDefaultUser();
                usernameText.setVisible(true);
                usernameField.setVisible(true);
                passwordText.setVisible(true);
                passwordField.setVisible(true);
                createAccountButton.setVisible(true);
                signInButton.setVisible(true);
                signInError.setVisible(true);
                currentUsername.setVisible(false);
                signOutButton.setVisible(false);
                removeUserProfileTabs();
                homeTabbedWindow.remove(recGamesTab);
                try {
                    recGamesTab = new RecommendedGames(currentUser).getRecommendView().view();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                homeTabbedWindow.add("Recommended Games", recGamesTab);
                try {
                    UserDatabase.exportDatabase();
                } catch (IOException | ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


    }

    /**
     * Opens tabs that are related to the signed in UserProfile
     * Method is called after a user successfully signs in
     * Calls the constructors of the other views with the currentUser information
     * Adds the views to the tabbed panel
     */
    public static void openUserProfileTabs(){

        reviewTab = ReviewView.reviewView(currentUser);
        homeTabbedWindow.add("Your Reviews", reviewTab);
        LibraryView userLibrary = new LibraryView(currentUser.getLibrary());
        libraryTab = userLibrary.view();
        homeTabbedWindow.add("Your library", libraryTab);
    }

    /**
     * Closes tabs that are related to the previously signed-in user
     */
    public static void removeUserProfileTabs(){
        homeTabbedWindow.remove(libraryTab);
        homeTabbedWindow.remove(reviewTab);
    }

    /**
     * Adds a Game View to the Tabbed Pane
     * Method is called when clicking a game in a GameCollection
     * if a game is already open, closes the last game tab
     */

    public static void openGameTab() throws IOException {
        if(gameOpened) {
            homeTabbedWindow.remove(gameTab);
        }
        Game selectedGame = GameCollectionView.getSelectedGame();

        gameTab = GameView.gameView(selectedGame, currentUser);
        homeTabbedWindow.add(selectedGame.getTitle(), gameTab);
        gameOpened = true;
    }

    /**
     * Open Search results tab
     */
    public static void openSearchResults() throws IOException {
        System.out.println(resultsOpened);
        if(resultsOpened) {
            homeTabbedWindow.remove(resultsTab);
        }

        GameCollection searchResults = SearchView.getResults();
        GameCollectionView resultsCol = new GameCollectionView(searchResults);
        resultsTab = resultsCol.view();
        homeTabbedWindow.add("Results", resultsTab);
        resultsOpened = true;
    }


    public static void main(String[] args) throws IOException {
        homeView();
    }

}
