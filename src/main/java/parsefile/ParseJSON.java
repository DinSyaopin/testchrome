package parsefile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class ParseJSON implements ParseFile {
    @Override
    public Map<String, String> parseFile(File file) {

        Map<String, String> commands = new LinkedHashMap<>();
        try {
            byte[] jsonData = Files.readAllBytes(file.toPath());
            ObjectMapper mapper = new ObjectMapper();
            List<Command> scenary = mapper.readValue(jsonData, new TypeReference<ArrayList<Command>>() {});
            for (Command command:
                 scenary) {
                commands.put(command.getAction(), command.getParams());
            }
            return commands;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
