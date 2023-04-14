import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class HomeView {

    static UserProfile currentUser = new UserProfile();
    private static final ArrayList<UserProfile> AllUsers = new ArrayList<>();

    public static void homeView(){




        //Buttons and Text Fields


        JButton signInButton = new JButton("Sign In");
        JButton createAccountButton = new JButton("Create Account");
        JButton homeButton = new JButton("GAMEBOARD");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel signInError = new JLabel();
        JLabel usernameText = new JLabel("Username:");
        JLabel passwordText = new JLabel("Password:");


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


        //HomeTabbedWindow

        JTabbedPane homeTabbedWindow = new JTabbedPane();

        //Recommended Games Tab

        JPanel recGamesTab = new JPanel();
        homeTabbedWindow.add("Recommended Games", recGamesTab);

        //Search Tab

        JPanel searchTab = new JPanel();
        homeTabbedWindow.add("Search",searchTab);


        //Game Tab

        Game game = new Game("title", "thumbnailUrl", "imageUrl", "description", 0, "id", 0, 0, 0, 0);
        GameView gv = new GameView(game);
        JPanel gameTab = new JPanel();
        gameTab = GameView.gameView(game);
        homeTabbedWindow.add("Game", gameTab);


        //Library Tab

        JPanel libraryTab = new JPanel();
        homeTabbedWindow.add("Your Library",libraryTab);


        //Your Reviews Tab

        JPanel reviewTab = new JPanel();
        homeTabbedWindow.add("Your Reviews",reviewTab);


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
                passwordInput = passwordField.getText();

                UserProfile.logIn(usernameInput, passwordInput);
                currentUser = UserProfile.logIn(usernameInput, passwordInput);
                signInError.setText(currentUser.getUsername()); //For Testing Purposes to see if signed in correctly
                if (!currentUser.getSignInStatus()) {
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
                passwordInput = passwordField.getText();
                for(UserProfile user: getUsers()){
                    if (usernameInput.equals(user.getUsername())){
                        signInError.setText("Username is Taken");
                        dupeAccount = true;
                    }
                }
                if(!dupeAccount) {
                    UserProfile registeredUser = new UserProfile(usernameInput, passwordInput);
                    AllUsers.add(registeredUser);
                    currentUser = registeredUser;

                }

            }
        });


    }
    //Dummy List of Users for testing
    public static ArrayList<UserProfile> getUsers(){
        UserProfile user1 = new UserProfile("Bob", "smith");
        UserProfile user2 = new UserProfile("John", "smite");
        UserProfile user3 = new UserProfile("Joe", "King");
        UserProfile user4 = new UserProfile("Bill", "Lee");
        AllUsers.add(user1);
        AllUsers.add(user2);
        AllUsers.add(user3);
        AllUsers.add(user4);
        return AllUsers;
    }

    public static void main(String[] args) {
        homeView();
    }

}
