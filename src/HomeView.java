import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class HomeView {

    static UserProfile currentUser = new UserProfile();


    public static void homeView(){
        UserDatabase userDatabase = null;
        try {
            userDatabase = new UserDatabase("AllUserProfileData.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
        UserDatabase finalUserDatabase = userDatabase;

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput;
                String passwordInput;
                usernameInput = usernameField.getText();
                passwordInput = String.valueOf(passwordField.getPassword());
                currentUser = currentUser.logIn(usernameInput, passwordInput, finalUserDatabase);

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
                for (UserProfile user : finalUserDatabase.getAllUsers()) {
                    if (usernameInput.equals(user.getUsername())) {
                        signInError.setText("Username is Taken");
                        dupeAccount = true;
                    }
                }
                if (!dupeAccount) {
                    UserProfile registeredUser = new UserProfile(usernameInput, passwordInput);
                    finalUserDatabase.addUserProfile(registeredUser);
                    usernameField.setText("");
                    passwordField.setText("");
                    signInError.setText("");
                }
            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                signInError.setText("");
                currentUser = finalUserDatabase.getDefaultUser();
                usernameText.setVisible(true);
                usernameField.setVisible(true);
                passwordText.setVisible(true);
                passwordField.setVisible(true);
                createAccountButton.setVisible(true);
                signInButton.setVisible(true);
                signInError.setVisible(true);
                currentUsername.setVisible(false);
                signOutButton.setVisible(false);
            }
        });


    }


    public static void main(String[] args) {
        homeView();
    }

}
