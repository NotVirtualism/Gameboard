import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class ImportUserProfiles{
    private Document xmlDocumentTree;
    private ArrayList<UserProfile> userList = null;

    public ImportUserProfiles (String inputFileName) throws FileNotFoundException, IOException{
        File inFile = new File(inputFileName);

        if(!inFile.exists()){
            throw new FileNotFoundException(inputFileName+" not found.");
        }
        //If the above file exists, we open it and retrieve the XML
        //Throws another exception if the XML is malformed
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setExpandEntityReferences(false);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            xmlDocumentTree = db.parse(inputFileName);   // retrieves the XML text into a stored dom object
        } catch (Exception ex) {
            throw new java.io.IOException("Unable to parse XML document");
        }

    }

    public ArrayList<UserProfile> retrieveUserList() throws IOException {
        if (userList == null){
            userList = new ArrayList<>();
            Element items = xmlDocumentTree.getDocumentElement();
            NodeList xmlUserList = items.getElementsByTagName("item");

            for(int i = 0; i < xmlUserList.getLength(); i++){
                Node user = xmlUserList.item(i);
                loadNextUser(user);

            }
        }

        return userList;
    }

    private void loadNextUser(Node xmlUserNode) throws IOException {
        String username;
        String password;
        String collectionName = "empt";
        String reviewText;
        String reviewGame;
        String reviewScore;
        String collectionGame;

        String inputFile = "bgg90Games.xml";
        GameDatabase mainGDB = new GameDatabase(inputFile);
        GameCollection master;
        master = mainGDB.getMasterList();

        NodeList subNodes = xmlUserNode.getChildNodes();
        username = getNodeAttribute(subNodes, "name", "value");
        password = getNodeAttribute(subNodes, "password", "value");



        UserProfile loadedUser = new UserProfile(username, password);
        userList.add(loadedUser);
        Node current;
        GameCollection loadedCollection = new GameCollection(collectionName);
        ArrayList<String> noTags =new ArrayList<>();
        for(int i = 0; i < subNodes.getLength(); i++){
            current = subNodes.item(i);
            if(current.getNodeName().equals("review")) {
                reviewText = current.getAttributes().getNamedItem("value").getNodeValue();
                reviewGame = current.getAttributes().getNamedItem("game").getNodeValue();
                reviewScore = current.getAttributes().getNamedItem("score").getNodeValue();

                Review loadedReview = new Review(Integer.parseInt(reviewScore), reviewText, loadedUser, reviewGame);
                loadedUser.addReview(loadedReview);
                Search importGame = new Search(reviewGame, noTags , master);
                GameCollection results = importGame.search();
                Game loadedGame = results.getGameByIndex(0);
                loadedGame.addReview(loadedReview);

            }
            else if(current.getNodeName().equals("collection")){
                collectionName = current.getAttributes().getNamedItem("value").getNodeValue();
                loadedCollection = new GameCollection(collectionName);
                loadedUser.getLibrary().addGameCollection(loadedCollection);
            }
            else if(current.getNodeName().equals("game")){
                collectionGame = current.getAttributes().getNamedItem("value").getNodeValue();
                Search importGame = new Search(collectionGame, noTags , master);
                GameCollection results = importGame.search();
                Game loadedGame = results.getGameByIndex(0);
                loadedCollection.addGame(loadedGame);
            }
        }
    }


    private String getNodeAttribute(NodeList n, String nodeName, String att){
        Node current;
        for(int i = 0; i < n.getLength(); i++){
            current = n.item(i);
            if(current.getNodeName().equals(nodeName)){
                NamedNodeMap attributes = current.getAttributes();
                return attributes.getNamedItem(att).getNodeValue();
            }
        }
        return "does not exist.";
    }
}

