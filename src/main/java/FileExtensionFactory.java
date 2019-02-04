import parsefile.ParseJSON;
import parsefile.ParseTXT;
import parsefile.ParseXLS;
import parsefile.ParseXML;

import java.io.File;
import java.util.Map;

public class FileExtensionFactory {

    public static Map<String, String> makeScenaryFrom(File file) throws Exception {
        String extension = getFileExtension(file);

        switch (extension) {
            case "xls":
                return new ParseXLS().parseFile(file);
            case "json":
                return new ParseJSON().parseFile(file);
            case "xml":
                return new ParseXML().parseFile(file);
            case "txt":
                return new ParseTXT().parseFile(file);
            default:
                throw new Exception("Can't read type of file.");
        }
    }

    private static String getFileExtension(File file) throws Exception {
        String fileName = file.getName();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }

        throw new Exception("Can't find extension.");
    }
}
