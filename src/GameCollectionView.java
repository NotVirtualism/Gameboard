import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
*/

public class GameCollectionView {
    private static GameCollection gameList;

    private static Game selectedGame;

    /**
     * Instantiates a GameCollectionView with a given GameCollection
     * @param gc - The given collection of games
     */
    public GameCollectionView(GameCollection gc){
        gameList = gc;
    }

    /**
     * Creates a view for all the games. Turns every game in gameList into a button and throws them into a
     * scrollable grid.
     * TODO:
     * Add working action listeners to the buttons that link to their GameViews (needs to be completed).
     * Turn from void to returning a JScrollPane so it can be implemented INTO views and not be its own view.
     */
    public static JPanel view(){
        JFrame frame = new JFrame("Game Collection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,7));
        Game current;
        ArrayList<JButton> buttons = new ArrayList<>();
        for(int i = 0; i < gameList.size(); i++) {
            current = gameList.getGameByIndex(i);
            String html = String.format("<html><img src='%s'/><br/>%s", current.getThumbnailUrl(), current.getTitle()); //swing is so swag for this
            JButton btn = new JButton(html);

            btn.setPreferredSize(new Dimension(200, 200));
            buttons.add(btn);
            panel.add(buttons.get(i));
            final int index = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        selectedGame = gameList.getGameByIndex(index);
                        HomeView.openGameTab();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        }
        for(int i = 0; i < gameList.size(); i++){


        }
/*
        frame.setContentPane(new JScrollPane(panel));
        frame.pack();
        frame.setVisible(true);
        */

        return panel;
    }

    public static Game getSelectedGame(){
        return selectedGame;
    }
}



