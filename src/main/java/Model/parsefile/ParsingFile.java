package Model.parsefile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * That class need to parse commands from file with testing requests to browser.
 */
public abstract class ParsingFile {
    ArrayList<Command> commands = new ArrayList<>();
    abstract ArrayList<Command> parseFile(File file) throws IOException;
}
