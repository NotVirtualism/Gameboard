import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
     *
     * @return
     */
    public JPanel view(){
        //JFrame frame = new JFrame("Game Collection");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,7));
        JButton newLib = new JButton("Add Collection");

        newLib.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame subFrame = new JFrame("Add Collection");
                subFrame.setSize(800, 400);

                JPanel subP = new JPanel();
                subP.add(new JLabel("Enter Collection Name: "));
                JTextField input = new JTextField();
                JButton enter = new JButton("Enter");
                subP.add(input);
                subP.add(enter);
                subFrame.setContentPane(subP);
                subFrame.pack();
                subFrame.setVisible(true);
            }
        });
        panel.add(newLib);

        Game current;
        for(GameCollection c : gameLib.getCollections()){
            JButton btn = new JButton(c.getName());
            btn.setPreferredSize(new Dimension(200, 200));
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    GameCollectionView gc = new GameCollectionView(c);
                    /*frame.setContentPane(gc.view());
                    frame.pack();
                    frame.setVisible(true);*/
                }
            });
            panel.add(btn);
        }
        /*
        frame.setContentPane(new JScrollPane(panel));
        frame.pack();
        frame.setVisible(true);
         */
        return panel;
    }
}
