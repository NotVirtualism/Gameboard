import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
public class SearchView implements ActionListener{
    JTextField sb;
    ArrayList<JCheckBox> tagBoxes = new ArrayList<JCheckBox>();
    private String query;
    private ArrayList<String> tags = new ArrayList<String>();
    private GameCollection results;

    public SearchView(ArrayList<String> t){
        query = "";
        for(String s:t){
            tagBoxes.add(new JCheckBox(s));
        }
    }

    public JScrollPane view(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        sb = new JTextField();
        sb.setPreferredSize(new Dimension(500, 30));
        panel.add(sb);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        panel.add(searchButton);
        panel.add(new JLabel("Tags:"));
        for(JCheckBox c : tagBoxes){
            panel.add(c);
        }
        return new JScrollPane(panel);
    }

    public void actionPerformed(ActionEvent e) {
        query = sb.getText();
        ArrayList<String> searchTags = new ArrayList<String>();
        for(int i = 0; i < tagBoxes.size(); i++){
            if(tagBoxes.get(i).)
                searchTags.add(tags.add(tagBoxes.get(i).getText()));
        }

    }
}
