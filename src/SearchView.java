import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
public class SearchView{
    JTextField sb;
    ArrayList<JCheckBox> tagBoxes = new ArrayList<JCheckBox>();
    private String query;
    private ArrayList<String> tags = new ArrayList<String>();
    private static GameCollection results;
    private GameDatabase database = new GameDatabase("bgg90Games.xml");
    private JPanel panel = new JPanel();


    /**
     * This method creates the checkboxes in the UI for all the tags in the master tag list
     * @param t is the String ArrayList of tag names
     * @throws IOException if it is unable to find anything in the master tag list
     */
    public SearchView(ArrayList<String> t) throws IOException {
        query = "";
        for(String s:t){
            tagBoxes.add(new JCheckBox(s));
        }

    }

    /**
     * Creates the panel displaying a GameCollection of results from the search function in Search class
     * @return the panel in the HomeView
     */
    public JScrollPane view(){
        //JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        sb = new JTextField();
        sb.setPreferredSize(new Dimension(500, 30));
        panel.add(sb);
        JButton searchButton = new JButton("Search");
        /* Takes in input from the Search text bar and the checked tags once button is pressed*/
        searchButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                query = sb.getText();
                ArrayList<String> searchTags = new ArrayList<String>();
                for (int i = 0; i < tagBoxes.size(); i++) {
                    if (tagBoxes.get(i).isSelected())
                        searchTags.add(tagBoxes.get(i).getText());
                }
                Search searchResults = new Search(sb.getText(), searchTags, database.getMasterList());
                results = searchResults.search();
            }
        });
        
        panel.add(searchButton);
        panel.add(new JLabel("Tags:"));
        for(JCheckBox c : tagBoxes){
            panel.add(c);
        }
        return new JScrollPane(panel);
    }

    /**
     * This method returns the GameCollection of results from the Search method
     * @return GameCollection results 
     */
    public static GameCollection getResults()
    {
        return results;
    }
    
    
}
