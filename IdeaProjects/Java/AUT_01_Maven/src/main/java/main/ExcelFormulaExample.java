package main;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFormulaExample {

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("number");

        int[] number = new int[]{1, 6, 3, 8, 9};

        Row row = sheet.createRow(0);
        for (int i = 0; i < number.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(number[i]);
        }

        Cell cell = row.createCell(number.length);
        cell.setCellFormula("A1+B1+C1+D1+E1");

        SheetConditionalFormatting sheetConditionalFormatting = sheet.getSheetConditionalFormatting();
        ConditionalFormattingRule rule = sheetConditionalFormatting.createConditionalFormattingRule(ComparisonOperator.EQUAL, "3");
        PatternFormatting patternFormatting = rule.createPatternFormatting();
        patternFormatting.setFillBackgroundColor(IndexedColors.RED.index);

        FontFormatting fontFormatting = rule.createFontFormatting();
        fontFormatting.setFontColorIndex(IndexedColors.WHITE.index);

        CellRangeAddress[] addresses = {
                CellRangeAddress.valueOf("A1:E1")
        };

        sheetConditionalFormatting.addConditionalFormatting(addresses,rule);

        try (FileOutputStream fos = new FileOutputStream(new File("test.xlsx"))){
            workbook.write(fos);
            System.out.println("OK");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
