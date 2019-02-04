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
        //String key;
        //String value;
        //String[] command;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                //System.out.println(line);
                //command = line.split(" ");
                //key = command[0];
                //value = command[1];
                //commands.put(key, value);
                int indexOfSpace = line.indexOf(' ');
                commands.put(line.substring(0, indexOfSpace), line.substring(indexOfSpace));
                line = bufferedReader.readLine();
            }
            return commands;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
