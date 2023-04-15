import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;

public class ExportUserProfile {
    private Document userfile;

    private ArrayList<Review> reviewList = new ArrayList<Review>();
    private String username;
    private String password;

    private Library library;

    public ExportUserProfile(String outputFileName, String user, String pass, ArrayList<Review> reviews, Library library) throws FileNotFoundException, IOException{
        File outFile = new File(outputFileName);
        username = user;
        password = pass;
        reviewList = reviews;
        this.library = library;
        //userfile = outputFileName;

        //If the above file exists, we open it and retrieve the XML
        //Throws another exception if the XML is malformed
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setExpandEntityReferences(false);
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("items");
            doc.appendChild(rootElement);

            // supercars element
            Element item = doc.createElement("item");
            rootElement.appendChild(item);

            // setting attribute to element
            Attr attr = doc.createAttribute("value");
            attr.setValue("UserProfile");
            item.setAttributeNode(attr);

            Element name = doc.createElement("name");
            item.appendChild(name);
            Attr attr1 = doc.createAttribute("value");
            attr1.setValue(username);
            name.setAttributeNode(attr1);

            Element passw = doc.createElement("password");
            item.appendChild(passw);
            Attr attr2 = doc.createAttribute("value");
            attr2.setValue(password);
            name.setAttributeNode(attr2);

            int i = 0;
            while (i < reviewList.size())
            {
                i++;
            }
            String s = Integer.toString(i);

            Element reviewLength = doc.createElement("reviews");
            item.appendChild(reviewLength);
            Attr attr3 = doc.createAttribute("value");
            attr3.setValue(s);
            name.setAttributeNode(attr3);

            Attr attrType;
            Attr attrType2;
            Attr attr4;

            Element current;
            for (Review listings : reviewList)
            {
                current = doc.createElement("review");
                reviewLength.appendChild(current);

                attrType = doc.createAttribute("game");
                attrType.setValue(listings.getGameName());
                current.setAttributeNode(attrType);

                attr4 = doc.createAttribute("value");
                attr4.setValue(listings.getText());
                current.setAttributeNode(attr4);

                String scoreConvert = Integer.toString(listings.getScore());
                attrType2 = doc.createAttribute("score");
                attrType2.setValue(scoreConvert);
                current.setAttributeNode(attrType2);
            }

            Element collections = doc.createElement("collections");
            item.appendChild(collections);

            i = 0;
            while (i < library.gameCollectionList.size())
            {
                i++;
            }
            s = Integer.toString(i);
            Attr attr5 = doc.createAttribute("value");
            attr5.setValue(s);
            collections.setAttributeNode(attr5);


            Element currentCollection;
            Element currentGame;
            Element currentGameListLen;

            Attr attr6;
            Attr attr7;
            Attr attr8;

            GameCollection tempGameCollection;

            int k = 0;
            for (GameCollection collectionNames : library.gameCollectionList)
            {
                currentCollection = doc.createElement("collection");
                collections.appendChild(currentCollection);

                attr6 = doc.createAttribute("value");
                attr6.setValue(collectionNames.getGameCollectionName()); //might get name of game, not sure yet
                currentCollection.setAttributeNode(attr6);

                tempGameCollection = library.getGameCollectionByIndex(k);

                currentGameListLen = doc.createElement("games");
                currentCollection.appendChild(currentGameListLen);
                int tempLen = tempGameCollection.size();
                s = Integer.toString(tempLen);

                attr7 = doc.createAttribute("value");
                attr7.setValue(s);
                currentGameListLen.setAttributeNode(attr7);

                for (int j = 0; j < tempGameCollection.size(); j++)
                {
                    currentGame = doc.createElement("game");
                    currentGameListLen.appendChild(currentGame);

                    attr8 = doc.createAttribute("value");
                    attr8.setValue(tempGameCollection.getGameByIndex(j).getTitle());
                    currentGame.setAttributeNode(attr8);
                }

                k++;

            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Test2.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);


        } catch (Exception ex) {
            throw new java.io.IOException("Unable to parse XML document");
        }


    }



}

