import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ProfileView {
    public static void profileView() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // User Name

        String userNameHolder = "User Name";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridy = 0;

        JLabel gameNameLabel = new JLabel(userNameHolder);
        panel.add(gameNameLabel, c);
        gameNameLabel.setBorder(new LineBorder(Color.black));

        // Profile Picture

        String profilePictureHolder = "Profile Picture";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridy = 0;

        JLabel profilePictureLabel = new JLabel(profilePictureHolder);
        panel.add(profilePictureLabel, c);
        profilePictureLabel.setBorder(new LineBorder(Color.black));

        // User Reviews

        String reviewsHolder = "This will display the user's reviews";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.gridy = 1;

        JLabel reviewsLabel = new JLabel(reviewsHolder);
        panel.add(reviewsLabel, c);
        reviewsLabel.setBorder(new LineBorder(Color.black));

        // Library

        String libraryHolder = "This will display the user's library";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridy = 0;

        JLabel libraryLabel = new JLabel(libraryHolder);
        panel.add(libraryLabel, c);
        libraryLabel.setBorder(new LineBorder(Color.black));

        // Game Collection

        String gameCollectionHolder = "This will display the games in the selected game collection from the library";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridheight = 2;
        c.gridy = 0;

        JLabel gameCollectionLabel = new JLabel(gameCollectionHolder);
        panel.add(gameCollectionLabel, c);
        gameCollectionLabel.setBorder(new LineBorder(Color.black));

        // The Entire Frame

        JFrame profileFrame = new JFrame();
        profileFrame.setBounds(0, 0, screenWidth, screenHeight - 30);
        profileFrame.getContentPane().add(panel, BorderLayout.CENTER);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(true);
    }
}
