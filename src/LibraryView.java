import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryView {

    public static int nums = 0;
    public static int xnums = 100;
    public static boolean checked = false;
    private static GameCollection gameList;
    private static ArrayList<GameCollection> collectionsList = new ArrayList<GameCollection>();

    static int rowCounter(int n)
    {
        nums = nums + 20;
        n = n + 20;
        return n;
    }


    public static void main(String[] args)
    {

        view();

    }


    public static Component view()
    {
        JPanel gamecBar = new JPanel();
        gamecBar.setLayout(new GridBagLayout());
        GridBagConstraints homeBarRestraints = new GridBagConstraints();

        GameCollection gameList1 = new GameCollection("gameList1");

        gameList1.list.add(new Game("Game1"));
        gameList1.list.add(new Game("Game2"));
        gameList1.list.add(new Game("Game3"));
        gameList1.list.add(new Game("Game4"));
        gameList1.list.add(new Game("Game5"));
        gameList1.list.add(new Game("Game6"));

        JFrame f = new JFrame("Library"); //creating instance of JButton

        final JLabel tt = new JLabel();
        tt.setBounds(550, 50, 200, 40);

        tt.setText("Game Collections");

        final JTextArea tf = new JTextArea();
        tf.setBounds(200, 140, 200, 20);

        //Later for potentially adding more games
        final JButton ta = new JButton("Game Collection 1 v");
        ta.setBounds(200, 100, 200, 40);
        gamecBar.add(ta);

        final JButton tv = new JButton("Add New Game Collection");
        tv.setBounds(800, 100, 200, 40);
        gamecBar.add(tv);


        ta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                int tempy = 160;

                for (Game element : gameList1.list)
                {
                    tf.append(element.getName(element) + "\n");
                    tempy = rowCounter(tempy);
                }

                tf.setBounds(200, 140, 200, nums);
                gamecBar.add(tf);
            }
        });

        tv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                JTabbedPane gamecTabbedWindow = new JTabbedPane();

                JPanel GameCollection = new JPanel();
                gamecTabbedWindow.add("Game Collection",GameCollection);

                JTextField listname = new JTextField();

                listname.setBounds(800, 140, 200, 20);
                gamecBar.add(listname);

                final JButton tx = new JButton("Confirm New Game Collection");
                tx.setBounds(800, 180, 200, 40);
                gamecBar.add(tx);

                tx.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {

                        GameCollection tempgameList = new GameCollection(listname.getName());
                        collectionsList.add(tempgameList);

                        xnums = xnums + 300;

                        final JButton tr = new JButton(listname.getName());
                        tr.setBounds(xnums, 100, 200, 40);
                        gamecBar.add(tr);

                        tr.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {

                                JTabbedPane gamecTabbedWindow = new JTabbedPane();

                                JPanel GameCollection = new JPanel();
                                gamecTabbedWindow.add("Game Collection",GameCollection);

                                final JTextArea tm = new JTextArea();
                                tm.setBounds(200, 140, 200, 20);

                                for (Game element : tempgameList.list)
                                {
                                    tm.append(element.getName(element) + "\n");

                                }

                                tm.setBounds(200, 140, 200, nums);
                                gamecBar.add(tm);
                            }
                        });


                    }
                });


            }
        });




        gamecBar.add(gamecBar, BorderLayout.NORTH);
        gamecBar.add(tf);
        gamecBar.add(tt);


        gamecBar.setSize(1200, 800); //400 width and 500 height of frame
        gamecBar.setLayout(null);
        gamecBar.setVisible(true);

        return gamecBar;
    }

}
