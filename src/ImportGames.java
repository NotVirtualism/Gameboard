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
        Integer rank = 0;
        String title = "empt";
        String thumbUrl = "empt";
        String imageUrl = "empt";
        String desc = "empt";
        Integer year = 0;
        NamedNodeMap attributes = xmlGameNode.getAttributes();

        id = attributes.getNamedItem("id").getNodeValue();
        try {
            rank = Integer.parseInt(attributes.getNamedItem("rank").getNodeValue());
        } catch (NumberFormatException e) {
            rank = 0;  // using a default value if the data in the file is bad
        } catch (NullPointerException e) {
            rank = 0;
        }

        title = parseTextField(xmlGameNode, "name");
        thumbUrl = attributes.getNamedItem("thumbnail").getNodeValue();
        imageUrl = parseTextField(xmlGameNode, "image");
        desc = parseTextField(xmlGameNode, "description");
        year = parseIntegerField(xmlGameNode, "yearpublished");
        return new Game(title, thumbUrl, imageUrl, desc, year, rank, id);
    }

    /**
     * Some data is stored as child elements in the XML
     * Given a gameNode, extracts the given field from the child nodes as an Integer.
     * @param xmlGameNode - a game node from the DOM
     * @param fieldname - the field we are looking to extract
     * @return - the value of the field we are extracting, or "unknown" if no such value exists
     */
    private String parseTextField(Node xmlGameNode, String fieldname) {
        NodeList fields = xmlGameNode.getChildNodes();
        String fieldText = "unknown";
        for (int i = 0; i < fields.getLength(); i++) {
            Node field = fields.item(i);
            if (field.getNodeName().equals(fieldname)) {
                NamedNodeMap attributes = field.getAttributes();
                if(attributes.getNamedItem("value").getNodeValue() != null)
                    fieldText = attributes.getNamedItem("value").getNodeValue();
            }
        }
        return fieldText;
    }

    /**
     * Some data is stored as child elements in the XML
     * Given a gameNode, extracts the given field from the child nodes as an Integer.
     * @param xmlGameNode - a game node from the DOM
     * @param fieldname - the field we are looking to extract
     * @return - the value of the field we are extracting, or "unknown" if no such value exists
     */
    private Integer parseIntegerField(Node xmlGameNode, String fieldname) {
        NodeList fields = xmlGameNode.getChildNodes();
        Integer fieldValue = 0;
        for (int i = 0; i < fields.getLength(); i++) {
            Node field = fields.item(i);
            if (field.getNodeName().equals(fieldname)) {
                NamedNodeMap attributes = field.getAttributes();
                try {
                    fieldValue = Integer.parseInt(attributes.getNamedItem("value").getNodeValue());
                } catch (NumberFormatException e) {
                    fieldValue = 0;  // default if an exception is thrown.
                }
            }
        }
        return fieldValue;
    }

}
