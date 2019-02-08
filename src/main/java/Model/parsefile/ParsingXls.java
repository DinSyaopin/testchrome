package Model.parsefile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ParsingXls extends ParsingFile {
    @Override
    public ArrayList<Command> parseFile(File file) throws IOException {

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String action = row.getCell(0).getStringCellValue();
            String params = row.getCell(1).getStringCellValue();
            String desc = row.getCell(2).getStringCellValue();
            if (!action.equals("Action") && !params.isEmpty()) {
                    commands.add(new Command(action, params, desc));
            }
        }
        return commands;
    }
}
