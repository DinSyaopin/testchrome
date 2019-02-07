package parsefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParsingTxt extends ParsingFile {

    @Override
    public ArrayList<Command> parseFile(File file) {
        commands = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.contains(" ")) {
                    int indexOfSpace = line.indexOf(' ');
                    commands.add(new Command(line.substring(0, indexOfSpace), line.substring(indexOfSpace)));
                    line = bufferedReader.readLine();
                } else {
                    commands.add(new Command(line, null));
                    line = bufferedReader.readLine();
                }
            }
            return commands;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
