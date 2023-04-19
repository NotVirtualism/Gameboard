import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
public class GameView {
    public GameView(Game g) throws IOException {
        gameView(g);
    }
    public static JPanel gameView(Game game) throws IOException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Game Thumbnail

        String htmlThumbnail = String.format("<html><img src='%s'/><br/>%s", game.getThumbnailUrl(), "");

        // String gameThumbnailHolder = game.getThumbnailUrl();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridheight = 4;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 0;

        JLabel gameThumbnailLabel = new JLabel(htmlThumbnail);
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

        String htmlImage = String.format("<html><img src='%s'/><br/>%s", game.getImageUrl(), "");

        // String gamePictureHolder = game.getImageUrl();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridwidth = 8;
        c.gridheight = 8;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 6;

        JLabel gamePictureLabel = new JLabel(htmlImage);
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

        // Game Reviews

        ArrayList<Review> reviewsHolder = new ArrayList();
        reviewsHolder = game.getReviews();

        JPanel contentPane = new JPanel();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 12;
        c.gridwidth = 8;
        c.gridheight = 10;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 4;

        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String gameReviewsHolder = "<html>REVIEWS" + "<br/>";
        for (int counter = 0; counter < reviewsHolder.size(); counter++) {
            if (counter == 0)
            {
                gameReviewsHolder = gameReviewsHolder + reviewsHolder.get(counter).toString();
            }
            gameReviewsHolder = gameReviewsHolder + "<br/>" + reviewsHolder.get(counter).toString();
        }

        JLabel gameReviewsLabel = new JLabel(gameReviewsHolder);
        contentPane.add(gameReviewsLabel, c);
        panel.add(scrollPane, c);
        scrollPane.getViewport().setPreferredSize(new Dimension(40, 40));
        gameReviewsLabel.setBorder(new LineBorder(Color.black));

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
/*
        JFrame gameFrame = new JFrame();
        gameFrame.setBounds(0,0,1920,1080);
        gameFrame.getContentPane().add(panel, BorderLayout.CENTER);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
*/
        return panel;
    }

}
