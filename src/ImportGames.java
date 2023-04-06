import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportGames {
    private Document  xmlDocumentTree;  // this is the object tree parsed from the given XML File
    private GameCollection currentGameList;  // current game list, may be null

    /**
     * Constructor to create a parser to deal with a given file.
     * If the file does not exist, it will throw an exception for the user to deal with.
     * @param inputFileName - the file containing XML text
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ImportGames(String inputFileName) throws FileNotFoundException, IOException{
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

        currentGameList = null;
    }

    /**
     * Retrieves the entire game list from an XML document
     * @return a GameCollection object holding all found Game objects, in order of when they were found.
     */
    public GameCollection retrieveGameList() {
        if (currentGameList == null){
            currentGameList = new GameCollection("master");

            Element items = xmlDocumentTree.getDocumentElement();
            NodeList xmlGameList = items.getElementsByTagName("item");

            for(int i = 0; i < xmlGameList.getLength(); i++){
                Node game = xmlGameList.item(i);
                currentGameList.addGame(parseNextGame(game));
            }
        }

        return currentGameList;
    }

    /**
     * Every game in the XML is a child node of a larger item.
     * Parses a given node for all relevant data to instantiate a Game object.
     * @param xmlGameNode - the node being parsed
     * @return a newly instantiated Game object given the results of the parse.
     */
    private Game parseNextGame(Node xmlGameNode){
        String id;
        String title = "empt";
        String thumbUrl = "empt";
        String imageUrl = "empt";
        String desc = "empt";
        Integer year = 0;
        NamedNodeMap attributes = xmlGameNode.getAttributes();
        id = attributes.getNamedItem("id").getNodeValue();
        NodeList subNodes = xmlGameNode.getChildNodes();
        title = getNodeAttribute(subNodes, "name", "value");
        thumbUrl = getNodeText(subNodes, "thumbnail");
        imageUrl = getNodeText(subNodes, "image");
        desc = getNodeText(subNodes, "desc");
        year = Integer.parseInt(getNodeAttribute(subNodes, "yearpublished", "value"));
        return new Game(title, thumbUrl, imageUrl, desc, year, id);
    }

    /**
     * Returns the string in between the opening and closing tags of the specified node in a given NodeList (<>$*@%$</>).
     * @param n - NodeList to search for the specified node in.
     * @param nodeName - Name of the node to search for.
     * @return the node's text content as a String or a default if not found/does not exist.
     */
    private String getNodeText(NodeList n, String nodeName){
        Node current;
        for(int i = 0; i < n.getLength(); i++){
            current = n.item(i);
            if(current.getNodeName().equals(nodeName))
                return current.getTextContent();
        }
        return "does not exist.";
    }

    /**
     * Returns the contents of a specified attribute of a specified node in a given NodeList.
     * @param n - The NodeList to look for the node in
     * @param nodeName - The name of the node to search 'n' for
     * @param att - The name of the attribute to search the node for
     * @return The value of the attribute as a String, or a default if it is not found/does not exist.
     */
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
