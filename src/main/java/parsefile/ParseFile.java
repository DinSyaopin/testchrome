package parsefile;

import java.io.File;
import java.util.Map;

public interface ParseFile {
    Map<String, String> parseFile(File file);
}
