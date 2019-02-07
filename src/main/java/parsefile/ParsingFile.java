package parsefile;

import java.io.File;
import java.util.ArrayList;

public abstract class ParsingFile {
    ArrayList<Command> commands;
    abstract ArrayList<Command> parseFile(File file);
}
