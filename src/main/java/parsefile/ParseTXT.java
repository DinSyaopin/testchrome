package parsefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseTXT implements ParseFile{

    @Override
    public Map<String, String> parseFile(File file) {
        Map<String, String> commands = new LinkedHashMap<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.contains(" ")) {
                    int indexOfSpace = line.indexOf(' ');
                    commands.put(line.substring(0, indexOfSpace), line.substring(indexOfSpace));
                    line = bufferedReader.readLine();
                } else {
                    commands.put(line, null);
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
