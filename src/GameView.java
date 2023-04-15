import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
public class GameView {


//    // Accepts a game and populates the values
//    public void populate(Game g)
//    {
//        String title = g.getTitle();
//        String thumbnailUrl = g.getThumbnailUrl();
//        String imageUrl = g.getImageUrl();
//        String description = g.getDescription();
//        Integer pubYear = g.getPubYear();
//        String id = g.getId();
//        ArrayList<String> tags = g.getTags();
//        ArrayList<Review> reviews = g.getReviews();
//        ArrayList<String> authors = g.getAuthors();
//        ArrayList<String> publishers = g.getPublishers();
//        Integer minPlayers = g.getMinPlayers();
//        Integer maxPlayers = g.getMaxPlayers();
//        Integer minPlayTime = g.getMinPlayTime();
//        Integer maxPlayTime = g.getMaxPlayTime();
//    }


    public GameView(Game g)
    {
        gameView(g);
    }
    public static JPanel gameView(Game game) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Game Thumbnail

        String gameThumbnailHolder = game.getThumbnailUrl();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 4;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 0;

        JLabel gameThumbnailLabel = new JLabel(gameThumbnailHolder);
        panel.add(gameThumbnailLabel, c);
        gameThumbnailLabel.setBorder(new LineBorder(Color.black));

        // Game Name

        String gameNameHolder = game.getTitle();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 8;
        c.gridheight = 2;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 4;

        JLabel gameNameLabel = new JLabel(gameNameHolder);
        panel.add(gameNameLabel, c);
        gameNameLabel.setBorder(new LineBorder(Color.black));

        // Game Picture

        String gamePictureHolder = game.getImageUrl();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 8;
        c.gridheight = 8;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 6;

        JLabel gamePictureLabel = new JLabel(gamePictureHolder);
        panel.add(gamePictureLabel, c);
        gamePictureLabel.setBorder(new LineBorder(Color.black));

        // Library Button

        JButton addToLibraryButton = new JButton("Add to library");

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridwidth = 6;
        c.gridheight = 2;
        c.weightx = 0.3;
        c.weighty = 0.1;
        c.gridy = 0;
        panel.add(addToLibraryButton, c);

        // Game Stats

        Integer minPlayersHolder = game.getMinPlayers();
        Integer maxPlayersHolder = game.getMaxPlayers();
        Integer minPlaytimeHolder = game.getMinPlayTime();
        Integer maxPlaytimeHolder = game.getMaxPlayTime();

        ArrayList<String> tagsHolder = new ArrayList();
        tagsHolder = game.getTags();
        ArrayList<Review> reviewsHolder = new ArrayList();
        reviewsHolder = game.getReviews();
        ArrayList<String> authorsHolder = new ArrayList();
        authorsHolder = game.getAuthors();
        ArrayList<String> publishersHolder = new ArrayList();
        publishersHolder = game.getPublishers();

        String gameStatsHolder = "<html>Minimum Players: " + minPlayersHolder + "<br/>" +
                "Maximum Players: " + maxPlayersHolder + "<br/>" + "Minimum Playtime: " + minPlaytimeHolder + "<br/>" + "Maximum Playtime: " +
                maxPlaytimeHolder + "<br/>";

        String gameTagsHolder = "";
        for (int counter = 0; counter < tagsHolder.size(); counter++) {
            if (counter == 0)
            {
                gameTagsHolder = gameTagsHolder + tagsHolder.get(counter);
            }
            gameTagsHolder = gameTagsHolder + ", " +  tagsHolder.get(counter);
        }

        String gameAuthorsHolder = "";
        for (int counter = 0; counter < authorsHolder.size(); counter++) {
            if (counter == 0)
            {
                gameAuthorsHolder = gameAuthorsHolder + authorsHolder.get(counter);
            }
            gameAuthorsHolder = gameAuthorsHolder + ", " + authorsHolder.get(counter);
        }

        String gamePublishersHolder = "";
        for (int counter = 0; counter < publishersHolder.size(); counter++) {
            if (counter == 0)
            {
                gamePublishersHolder = gamePublishersHolder + publishersHolder.get(counter);
            }
            gamePublishersHolder = gamePublishersHolder + ", " + publishersHolder.get(counter);
        }

        gameStatsHolder = gameStatsHolder + "Tags: " + gameTagsHolder + "<br/>" + "Authors: "
                + gameAuthorsHolder + "<br/>" + "Publishers: " + gamePublishersHolder;

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridwidth = 8;
        c.gridheight = 10;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 4;

        JLabel gameStatsLabel = new JLabel(gameStatsHolder);
        panel.add(gameStatsLabel, c);
        gameStatsLabel.setBorder(new LineBorder(Color.black));

        // Game Rating - UPDATE: Likely dropping using rank - Logan
        /*
        String gameRankHolder = String.valueOf(game.getRank());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 2;

        JLabel gameRankLabel = new JLabel(gameRankHolder);
        panel.add(gameRankLabel, c);
        gameRankLabel.setBorder(new LineBorder(Color.black));
        */

        // Game Description

        String gameDescriptionHolder = game.getDescription();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 16;
        c.gridheight = 8;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 14;

        JLabel gameDescriptionLabel = new JLabel(gameDescriptionHolder);
        panel.add(gameDescriptionLabel, c);
        gameDescriptionLabel.setBorder(new LineBorder(Color.black));

        // The Entire Frame

        JFrame gameFrame = new JFrame();
        gameFrame.setBounds(0,0,1920,1080);
       // gameFrame.getContentPane().add(panel, BorderLayout.CENTER);
        gameFrame.setContentPane(new JScrollPane(panel));
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        return panel;
    }

}
