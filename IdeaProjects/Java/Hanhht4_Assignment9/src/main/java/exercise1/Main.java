package exercise1;


import exercise1.Account;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //------------------- 1. Create a workbook --------------------------------------------------------------------------------
        XSSFWorkbook workbook = new XSSFWorkbook();

        //------------------- 2. Create a sheet in workbook -----------------------------------------------------------------------
        XSSFSheet sheet = workbook.createSheet("exercise1");

        //------------------- 3 + 4 + 5 Create rows + cells in sheet  ----------------------------------------------------------------
        String[] columns = {"ID", "NAME", "LASTNAME"};
        List<Account> ls = new ArrayList<>();
        ls.add(new Account(1, "Amit", "Shukla"));
        ls.add(new Account(2, "Lokesh", "Gupta"));
        ls.add(new Account(3, "John", "Adwards"));
        ls.add(new Account(4, "Brain", "Schultz"));

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int cellCount = 0;

        for (int i = 0; i < ls.size(); i++){
            Row row = sheet.createRow(i+1);

                Cell cell1 = row.createCell(cellCount++);
                cell1.setCellValue(ls.get(i).getId());

                Cell cell2 = row.createCell(cellCount++);
                cell2.setCellValue(ls.get(i).getName());

                Cell cell3 = row.createCell(cellCount++);
                cell3.setCellValue(ls.get(i).getLastName());
                cellCount = 0;

        }
        try (FileOutputStream fos = new FileOutputStream(new File("Exercise1.xlsx"))){
            workbook.write(fos);
            System.out.println("OK");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
