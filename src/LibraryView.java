import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryView{
    private static Library gameLib;
    private static JScrollPane cView;

    public LibraryView(Library l){
        gameLib = l;
    }

    /**
     * Displays a view where, much like GameCollectionView, displays every GameCollection in a user's library as buttons.
     * Clicking a button pops up that GameCollectionView in a new window.
     * TODO:
     * Figure out a way to replace the current view/panel with the GameCollectionView and NOT popup a new window.
     */
    public void view(){
        JFrame frame = new JFrame("Game Collection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,7));
        Game current;
        for(GameCollection c : gameLib.getCollections()){
            JButton btn = new JButton(c.getName());
            btn.setPreferredSize(new Dimension(200, 200));
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    GameCollectionView gc = new GameCollectionView(c);
                    frame.setContentPane(gc.view());
                }
            });
            panel.add(btn);
        }
        frame.setContentPane(new JScrollPane(panel));
        frame.pack();
        frame.setVisible(true);
    }
}
