package parsefile;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseXML implements ParseFile {

    @Override
    public Map<String, String> parseFile(File file) {
        Map<String, String> commands = new LinkedHashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);
            NodeList commandElements = document.getDocumentElement().getElementsByTagName("command");

            for (int i = 0; i < commandElements.getLength(); i++) {
                Node command = commandElements.item(i);
                NamedNodeMap attributes = command.getAttributes();
                String action = attributes.getNamedItem("action").getNodeValue();
                String params = attributes.getNamedItem("params").getNodeValue();
                commands.put(action, params);
            }
            return commands;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}