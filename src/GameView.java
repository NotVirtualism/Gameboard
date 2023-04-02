import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
public class GameView {
    public static void gameView() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Game Name

        String gameNameHolder = "This will hold the game's name";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 0;

        JLabel gameNameLabel = new JLabel(gameNameHolder);
        panel.add(gameNameLabel, c);
        gameNameLabel.setBorder(new LineBorder(Color.black));

        // Game Picture

        String gamePictureHolder = "This will hold the game's picture";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 1;

        JLabel gamePictureLabel = new JLabel(gamePictureHolder);
        panel.add(gamePictureLabel, c);
        gamePictureLabel.setBorder(new LineBorder(Color.black));

        // Game Rating

        String gameRatingHolder = "This will hold the game's rating";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;

        JLabel gameRatingLabel = new JLabel(gameRatingHolder);
        panel.add(gameRatingLabel, c);
        gameRatingLabel.setBorder(new LineBorder(Color.black));

        // Game Stats

        String numberOfPlayersHolder = "This will hold the number of players";
        String timeHolder = "This will hold the time";
        String ageHolder = "This will hold the age";
        String weightHolder = "This will hold the weight";

        String gameStatsHolder = "<html>Number of Players: " + numberOfPlayersHolder + "<br/>" +
                "Time: " + timeHolder + "<br/>" + "Age: " + ageHolder + "<br/>" + "Weight: " +
                weightHolder;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;

        JLabel gameStatsLabel = new JLabel(gameStatsHolder);
        panel.add(gameStatsLabel, c);
        gameStatsLabel.setBorder(new LineBorder(Color.black));

        // Library Button

        JButton addToLibraryButton = new JButton("Add to library");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 2;
        panel.add(addToLibraryButton, c);

        // Game Description

        String gameDescriptionHolder = "This will hold the game's description";

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 3;

        JLabel gameDescriptionLabel = new JLabel(gameDescriptionHolder);
        panel.add(gameDescriptionLabel, c);
        gameDescriptionLabel.setBorder(new LineBorder(Color.black));

        // The Entire Frame

        JFrame gameFrame = new JFrame();
        gameFrame.setBounds(0, 0, screenWidth, screenHeight - 30);
        gameFrame.getContentPane().add(panel, BorderLayout.CENTER);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    public static void main(String[] args) {
        gameView();
    }
}
