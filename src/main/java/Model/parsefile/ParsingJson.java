package Model.parsefile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class ParsingJson extends ParsingFile {
    @Override
    public ArrayList<Command> parseFile(File file) {

        try {
            byte[] jsonData = Files.readAllBytes(file.toPath());
            ObjectMapper mapper = new ObjectMapper();
            commands = mapper.readValue(jsonData, new TypeReference<ArrayList<Command>>() {});
            return commands;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
