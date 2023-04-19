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
    private GameCollection results;
    private GameDatabase database = new GameDatabase("bgg90Games.xml");
    private JPanel panel = new JPanel();


    public SearchView(ArrayList<String> t) throws IOException {
        query = "";
        for(String s:t){
            tagBoxes.add(new JCheckBox(s));
        }

    }

    public JScrollPane view(){
        //JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        sb = new JTextField();
        sb.setPreferredSize(new Dimension(500, 30));
        panel.add(sb);
        JButton searchButton = new JButton("Search");
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
    
    public GameCollection getResults()
    {
        return results;
    }
    
    
}
