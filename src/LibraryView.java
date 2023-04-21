import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryView{
    private static Library gameLib;

    /**
     * Instantiates a new LibraryView
     * @param l - The Library represented in the view
     */
    public LibraryView(Library l){
        gameLib = l;
    }

    /**
     * Displays a view where, much like GameCollectionView, displays every GameCollection in a user's library as buttons.
     * Clicking a button pops up that GameCollectionView in a new window.
     * Clicking the "Add Collection" button opens a popup that lets the user input a name of a new collection, and adds
     * it to the user's library.
     * @return the JScrollPane for the LibraryView to be used in other frames
     */
    public JScrollPane view(){
        JFrame frame = new JFrame("Game Collection");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,7));
        JButton newLib = new JButton("Add Collection");
        newLib.setPreferredSize(new Dimension(200, 200));

        newLib.addActionListener(new ActionListener(){
            @Override
            //The new collection popup
            public void actionPerformed(ActionEvent e){
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                JFrame subFrame = new JFrame("Add Collection");
                subFrame.setLocation(screenSize.width/2, screenSize.height/2);
                JPanel subP = new JPanel();
                subP.add(new JLabel("Enter Collection Name: "));
                JTextField input = new JTextField();
                input.setPreferredSize(new Dimension(300, 20));
                JButton enter = new JButton("Enter");
                //Instantiating a new collection to the user's library with the text given in the textbox.
                enter.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        gameLib.addGameCollection(new GameCollection(input.getText()));
                        subFrame.setVisible(false);
                    }
                });
                subP.add(input);
                subP.add(enter);
                subFrame.setContentPane(subP);
                subFrame.pack();
                subFrame.setVisible(true);
            }
        });
        panel.add(newLib);

        for(GameCollection c : gameLib.getCollections()){
            JButton btn = new JButton(c.getName());
            btn.setPreferredSize(new Dimension(200, 200));
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    GameCollectionView gc = new GameCollectionView(c);
                    frame.setContentPane(gc.view());
                    frame.pack();
                    frame.setVisible(true);
                }
            });
            panel.add(btn);
        }
        return new JScrollPane(panel);
    }
}
