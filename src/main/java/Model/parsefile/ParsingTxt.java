package Model.parsefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParsingTxt extends ParsingFile {

    @Override
    public ArrayList<Command> parseFile(File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        // TODO do desc
        while (line != null) {
            if (line.contains(" ")) {
                int indexOfSpace = line.indexOf(' ');
                String action = line.substring(0, indexOfSpace);
                String params = line.substring(indexOfSpace + 1);
                commands.add(new Command(action, params));
                line = bufferedReader.readLine();
            } else {
                commands.add(new Command(line, null));
                line = bufferedReader.readLine();
            }
        }
        return commands;
    }

}
