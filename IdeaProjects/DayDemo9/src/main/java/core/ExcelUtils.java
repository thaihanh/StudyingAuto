package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtils {
    public static Object[][] getTableArray(String filePath, String sheetName, int startCol, int totalCol) {
        String[][] tableArray = null;

        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excelFile);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = xssfSheet.getLastRowNum();
            ci = 0;
            tableArray = new String[totalRows][totalCol];
            for (int i = startRow; i <= totalRows; i++, ci++){
                cj = 0;
                for(int j = startCol; j < totalCol; j++, cj++){
                    XSSFCell cell = xssfSheet.getRow(i).getCell(j);
                    tableArray[ci][cj] = cell.getStringCellValue();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tableArray;
    }
}
