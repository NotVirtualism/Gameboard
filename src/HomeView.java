import javax.swing.*;
import java.awt.*;

public class HomeView {
    public static void homeView(){

          //Buttons and Text Fields


        JButton signInButton = new JButton("Sign In");
        JButton homeButton = new JButton("GAMEBOARD");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();


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

          //Username Field Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 3;
        homeBarRestraints.gridy = 0;
        homeBar.add(usernameField, homeBarRestraints);

          //Password Field Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.weightx = 0.2;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 1;
        homeBarRestraints.gridx = 3;
        homeBarRestraints.gridy = 1;
        homeBar.add(passwordField, homeBarRestraints);

          //Sign In Button Formatting

        homeBarRestraints.ipady = 40;
        homeBarRestraints.gridwidth = 1;
        homeBarRestraints.gridheight = 2;
        homeBarRestraints.weightx = 0.05;
        homeBarRestraints.gridx = 4;
        homeBarRestraints.gridy = 0;
        homeBar.add(signInButton, homeBarRestraints);



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
        homeFrame.pack();
        homeFrame.setVisible(true);
    }
}
