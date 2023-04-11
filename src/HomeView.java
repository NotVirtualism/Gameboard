import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class HomeView {

    public static void homeView(){

        //Buttons and Text Fields


        JButton signInButton = new JButton("Sign In");
        JButton createAccountButton = new JButton("Create Account");
        JButton homeButton = new JButton("GAMEBOARD");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField failedLoginMessage = new JTextField("Information Entered is Incorrect or the Account Does Not Exist");
        JTextField accountDuplicateMessage = new JTextField("Username is Taken");
        JTextField accountInformationInvalid = new JTextField("The Entered Username or Password Cannot Have Spaces");
        JLabel usernameText = new JLabel("Username:");
        JLabel passwordText = new JLabel("Password:");


        //HomeBar

        JPanel homeBar = new JPanel();
        homeBar.setLayout(new GridBagLayout());
        GridBagConstraints homeBarRestraints = new GridBagConstraints();

        //HomeButton Formatting

        homeBarRestraints.fill = homeBarRestraints.HORIZONTAL;
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
        failedLoginMessage.setEditable(false);
        accountDuplicateMessage.setEditable(false);
        accountInformationInvalid.setEditable(false);
        failedLoginMessage.setVisible(false);
        accountDuplicateMessage.setVisible(false);
        accountInformationInvalid.setVisible(false);
        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 3;
        homeBar.add(failedLoginMessage, homeBarRestraints);
        homeBar.add(accountInformationInvalid, homeBarRestraints);
        homeBar.add(accountDuplicateMessage, homeBarRestraints);


        //HomeTabbedWindow

        JTabbedPane homeTabbedWindow = new JTabbedPane();

        //Recommended Games Tab

        JPanel recGamesTab = new JPanel();
        homeTabbedWindow.add("Recommended Games", recGamesTab);

        //Search Tab

        JPanel searchTab = new JPanel();
        homeTabbedWindow.add("Search",searchTab);


        //Game Tab

        JPanel gameTab = new JPanel();
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
                //UserProfile.logIn(usernameInput, passwordInput);
            }
        });


        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput;
                String passwordInput;
                usernameInput = usernameField.getText();
                passwordInput = passwordField.getText();
                UserProfile registeredUser = new UserProfile(usernameInput, passwordInput);

            }
        });


    }


    public static void main(String[] args) {
        homeView();
    }

}
