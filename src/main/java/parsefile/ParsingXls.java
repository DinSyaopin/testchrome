package parsefile;

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
    public ArrayList<Command> parseFile(File file) {
        ArrayList<Command> commands = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String cell0 = row.getCell(0).getStringCellValue();
                String cell1 = row.getCell(1).getStringCellValue();
                if (!cell0.equals("Action") && !cell0.isEmpty()) {
                        commands.add(new Command(cell0, cell1));
                }
            }
            return commands;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
