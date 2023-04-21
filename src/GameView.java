import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GameView {
    private UserProfile user;

    /**
     * Constructs a game view from a Game g and UserProfile u.
     * @param g is a Game.
     * @param u is a User.
     * @throws IOException
     */
    public GameView(Game g, UserProfile u) throws IOException {
        gameView(g, u);
    }

    /**
     * Displays game information on the screen.
     * @param game is a Game. The information from the game will be used to display the information.
     * @param user is a User. Information from the User's library and reviews will be used in Action Events.
     * @return a panel to be used in HomeView.
     * @throws IOException
     */
    public static JPanel gameView(Game game, UserProfile user) throws IOException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        // Game Thumbnail

        String htmlThumbnail = String.format("<html><img src='%s'/><br/>%s", game.getThumbnailUrl(), game.getTitle());

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

        // Library Button

        JButton addToLibraryButton = new JButton("Add to library");

        addToLibraryButton.addActionListener(new ActionListener() {

            /**
             * Displays a window with the User's game collections. The User
             * selects a game collection to add the current game to.
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String chooseCollection = "Choose collection";

                JLabel collectionLabel = new JLabel(chooseCollection);
                JFrame libraryFrame = new JFrame();
                JPanel libraryPanel = new JPanel();
                libraryPanel.add(collectionLabel);

                Library l = user.getLibrary();

                for(GameCollection c : l.getCollections()){
                    JButton btn = new JButton(c.getName());

                    btn.setPreferredSize(new Dimension(200, 200));
                    btn.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            c.addGame(game);
                            user.getLibrary().getGameCollectionByIndex(0).addGame(game);
                            try {
                                UserDatabase.exportDatabase();
                            } catch (IOException | ParserConfigurationException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    libraryPanel.add(btn);
                }

                libraryFrame.add(libraryPanel, BorderLayout.CENTER);
                libraryFrame.pack();
                libraryFrame.setLocation(screenWidth / 2, screenHeight / 2);
                libraryFrame.setVisible(true);


            }
        });

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridwidth = 3;
        c.gridheight = 2;
        c.weightx = 0.3;
        c.weighty = 0.1;
        c.gridy = 0;
        panel.add(addToLibraryButton, c);

        // Game Reviews

        ArrayList<Review> reviewsHolder = new ArrayList();
        reviewsHolder = game.getReviews();

        JPanel contentPane = new JPanel();

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 8;
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
            else
            {
                gameReviewsHolder = gameReviewsHolder + "<br/>" + reviewsHolder.get(counter).toString();
            }
        }

        JLabel gameReviewsLabel = new JLabel(gameReviewsHolder);
        contentPane.add(gameReviewsLabel, c);
        panel.add(scrollPane, c);
        scrollPane.getViewport().setPreferredSize(new Dimension(40, 40));
        gameReviewsLabel.setBorder(new LineBorder(Color.black));

        // Review Button

        JButton addReviewButton = new JButton("Add review");

        addReviewButton.addActionListener(new ActionListener() {

            /**
             * Displays a window with a Combo Box that allows the User to choose
             * a rating. Also displays a Text Field that allows the User to
             * enter a review.
             * @param e the event to be processed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String chooseRating = "Choose rating";
                JPanel reviewPanel = new JPanel();
                JLabel ratingLabel = new JLabel(chooseRating);
                reviewPanel.add(ratingLabel);

                String[] ratingString = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
                JComboBox ratingList = new JComboBox(ratingString);
                reviewPanel.add(ratingList);

                JTextField textField = new JTextField("Type your review", 20);
                reviewPanel.add(textField);

                JButton addReviewButton = new JButton("Click to add your review");

                JFrame ratingFrame = new JFrame();
                ratingFrame.add(reviewPanel);
                addReviewButton.addActionListener(new ActionListener() {
                    /**
                     * Gets the value from the Combo Box and the text from the
                     * Text Field and uses them to create a review for the
                     * current game by the User that is logged in.
                     * @param e the event to be processed.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // add selected rating to review
                        int value = Integer.parseInt(ratingList.getSelectedItem().toString());

                        // add review text to review
                        String text = textField.getText();

                        Review newReview = new Review(value, text, user, game.getTitle());
                        game.addReview(newReview);

                        panel.revalidate();
                        panel.repaint();
                    }
                    });

                reviewPanel.add(addReviewButton);

                ratingFrame.setLocation(screenWidth / 2, screenHeight / 2);
                ratingFrame.pack();
                ratingFrame.setVisible(true);
            }
        });

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 8;
        c.gridwidth = 3;
        c.gridheight = 2;
        c.weightx = 0.2;
        c.weighty = 0.1;
        c.gridy = 0;
        panel.add(addReviewButton, c);

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
        c.gridx = 4;
        c.gridwidth = 8;
        c.gridheight = 10;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridy = 4;

        JLabel gameStatsLabel = new JLabel(gameStatsHolder);
        panel.add(gameStatsLabel, c);
        gameStatsLabel.setBorder(new LineBorder(Color.black));

        // Game Description

        String gameDescriptionHolder = game.getDescription();

        if (game.getDescription() == "does not exist.")
        {
            gameDescriptionHolder = "no description";
        }

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

        return panel;
    }

}
