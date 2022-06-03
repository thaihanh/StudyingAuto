package exercise2;

import exercise1.Account;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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
        XSSFSheet sheet = workbook.createSheet("exercise2");

        //------------------- 3 + 4. Create rows + cells in sheet  ----------------------------------------------------------------
        String[] columns = {"Students", "Paper1", "Paper2", "Paper3", "Paper4", "Paper5", "Paper6", "Paper7", "Total"};
        List<Student> ls = new ArrayList<>();
        ls.add(new Student(1, 1, 7, 74, 23, 75, 55, 51));
        ls.add(new Student(2, 73, 17, 5, 52, 18, 26, 26));
        ls.add(new Student(3, 27, 29, 29, 35, 96, 17, 45));
        ls.add(new Student(4, 4, 4, 56, 32, 12, 22, 14));

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int cellCount = 0;

        for (int i = 0; i < ls.size(); i++) {
            Row row = sheet.createRow(i + 1);

            Cell cell1 = row.createCell(cellCount++);
            cell1.setCellValue("Student " + ls.get(i).getId());

            Cell cell2 = row.createCell(cellCount++);
            cell2.setCellValue(ls.get(i).getPaper1());

            Cell cell3 = row.createCell(cellCount++);
            cell3.setCellValue(ls.get(i).getPaper2());

            Cell cell4 = row.createCell(cellCount++);
            cell4.setCellValue(ls.get(i).getPaper3());

            Cell cell5 = row.createCell(cellCount++);
            cell5.setCellValue(ls.get(i).getPaper4());

            Cell cell6 = row.createCell(cellCount++);
            cell6.setCellValue(ls.get(i).getPaper5());

            Cell cell7 = row.createCell(cellCount++);
            cell7.setCellValue(ls.get(i).getPaper6());

            Cell cell8 = row.createCell(cellCount++);
            cell8.setCellValue(ls.get(i).getPaper7());

            //------------------- 5. FormulaTotal cell will be: sum(B->H) ---------------------------------------------
            Cell cell9 = row.createCell(cellCount++);
            cell9.setCellValue(cell2.getNumericCellValue() + cell3.getNumericCellValue() + cell4.getNumericCellValue() + cell5.getNumericCellValue()
                    + cell6.getNumericCellValue() + cell7.getNumericCellValue() + cell8.getNumericCellValue());
            cellCount = 0;

        }

        //------------------- 6. Highlight all cells -----------------------------------------------------------------

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);

            SheetConditionalFormatting sheetConditionalFormatting = sheet.getSheetConditionalFormatting();
            ConditionalFormattingRule rule1 = sheetConditionalFormatting.createConditionalFormattingRule(String.valueOf(cell.getColumnIndex() > 0 && cell.getColumnIndex() < 8));
            PatternFormatting patternFormatting1 = rule1.createPatternFormatting();
            patternFormatting1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.index);
            CellRangeAddress[] addresses1 = {
                    CellRangeAddress.valueOf("B1:I1")
            };

            ConditionalFormattingRule rule2 = sheetConditionalFormatting.createConditionalFormattingRule(String.valueOf(cell.getColumnIndex() == 1));
            PatternFormatting patternFormatting2 = rule2.createPatternFormatting();
            patternFormatting2.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.index);
            CellRangeAddress[] addresses2 = {
                    CellRangeAddress.valueOf("A2:A5")
            };

            ConditionalFormattingRule rule3 = sheetConditionalFormatting.createConditionalFormattingRule(String.valueOf(cell.getColumnIndex() == 8));
            PatternFormatting patternFormatting3 = rule3.createPatternFormatting();
            patternFormatting3.setFillBackgroundColor(IndexedColors.LIGHT_ORANGE.index);
            CellRangeAddress[] addresses3 = {
                    CellRangeAddress.valueOf("I2:I5")
            };


            sheetConditionalFormatting.addConditionalFormatting(addresses1, rule1);
            sheetConditionalFormatting.addConditionalFormatting(addresses2, rule2);
            sheetConditionalFormatting.addConditionalFormatting(addresses3, rule3);
        }

        try (FileOutputStream fos = new FileOutputStream(new File("Exercise2.xlsx"))) {
            workbook.write(fos);
            System.out.println("OK");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
