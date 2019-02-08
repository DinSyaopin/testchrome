package Model;

import Model.parsefile.*;

import java.io.File;
import java.util.ArrayList;

/**
 * This class defines extension of scenary file
 * and then send this file to appropriate parser.
 */
public class FileExtensionFactory {

    public static ArrayList<Command> makeScenaryFrom(File file) throws Exception {

        String extension = getFileExtension(file);

        switch (extension) {
            case "xls":
                return new ParsingXls().parseFile(file);
            case "json":
                return new ParsingJson().parseFile(file);
            case "xml":
                return new ParsingXml().parseFile(file);
            case "txt":
                return new ParsingTxt().parseFile(file);
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
