package Model.parsefile;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParsingXml extends ParsingFile {

    @Override
    public ArrayList<Command> parseFile(File file) throws IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document;
        try {
            builder = factory.newDocumentBuilder();

            document = builder.parse(file);

            NodeList commandElements = document.getDocumentElement().getElementsByTagName("command");

            for (int i = 0; i < commandElements.getLength(); i++) {
                Node command = commandElements.item(i);
                NamedNodeMap attributes = command.getAttributes();
                String action = attributes.getNamedItem("action").getNodeValue();
                String params = attributes.getNamedItem("params").getNodeValue();
                String description = attributes.getNamedItem("description").getNodeValue();
                commands.add(new Command(action, params, description));
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return commands;
    }
}