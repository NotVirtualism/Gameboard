import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class GameCollectionView {

    public static int nums = 0;
    public static boolean checked = false;
    private static GameCollection gameList;


    static int rowCounter(int n) {
        nums = nums + 20;
        n = n + 20;
        return n;
    }

  /*
    public static void main(String[] args) {

        view();

    }


    public static void view() {
        GameCollection gameList1 = new GameCollection("gameList1");
        gameList1.list.add(new Game("Game1")); //Test Values to work through the view
        gameList1.list.add(new Game("Game2"));
        gameList1.list.add(new Game("Game3"));
        gameList1.list.add(new Game("Game4"));
        gameList1.list.add(new Game("Game5"));
        gameList1.list.add(new Game("Game6"));
        JFrame f = new JFrame("Game Collection"); //creating instance of JButton

        final JLabel tt = new JLabel();
        tt.setBounds(550, 50, 200, 40);

        tt.setText("Game Collections");

        final JTextArea tf = new JTextArea();
        tf.setBounds(200, 140, 200, 20);

        //Later for potentially adding more games
        final JButton ta = new JButton("Game Collection 1 v");
        ta.setBounds(200, 100, 200, 40);
        f.add(ta);


        ta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int tempy = 160;

                for (Game element : gameList1.list) {
                    tf.append(element.getName(element) + "\n");
                    tempy = rowCounter(tempy);
                }

                tf.setBounds(200, 140, 200, nums);
                f.add(tf);
            }
        });


        f.add(tf);
        f.add(tt);


        f.setSize(1200, 800); //400 width and 500 height of frame
        f.setLayout(null);
        f.setVisible(true);
    }
    */

}

