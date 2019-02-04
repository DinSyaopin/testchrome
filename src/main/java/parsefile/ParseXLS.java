package parsefile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseXLS implements ParseFile {
    @Override
    public Map<String, String> parseFile(File file) {
        Map<String, String> commands = new LinkedHashMap<>();

        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String cell0 = row.getCell(0).getStringCellValue();
                String cell1 = row.getCell(1).getStringCellValue();
                if (!cell0.equals("Action") && !cell0.isEmpty()) {
                        commands.put(cell0, cell1);
                }
            }
            return commands;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
