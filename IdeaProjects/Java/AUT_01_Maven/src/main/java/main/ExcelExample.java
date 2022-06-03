package main;

import entity.Account;
import org.apache.commons.math3.exception.MathArithmeticException;
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

public class ExcelExample {

//    public static void main(String[] args) {
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("account");
//        List<Account> ls = new ArrayList<Account>();
//        ls.add(new Account(1, "AnhDT45", "AnhDT45@gmail.com", new String[]{"Admin", "Member", "Mod"}, true));
//        ls.add(new Account(2, "AnhPT", "AnhPT@gmail.com", new String[]{"Member", "Mod"}, true));
//        ls.add(new Account(3, "MaiTT", "MaiTT@gmail.com", new String[]{"Member"}, false));
//        int cellCount = 0;
//        for (int i = 0; i < ls.size(); i++) {
//            Row row = sheet.createRow(i);
//            Cell cell1 = row.createCell(cellCount++);
//            cell1.setCellValue(ls.get(i).getId());
//            Cell cell2 = row.createCell(cellCount++);
//            cell2.setCellValue(ls.get(i).getName());
//            Cell cell3 = row.createCell(cellCount++);
//            cell3.setCellValue(ls.get(i).getEmail());
//            Cell cell4 = row.createCell(cellCount++);
//            cell4.setCellValue(ls.get(i).toStringRole());
//            Cell cell5 = row.createCell(cellCount++);
//            cell5.setCellValue(ls.get(i).isAdmin());
//            cellCount = 0;
//        }
//        try (FileOutputStream fos = new FileOutputStream(new File("test.xlsx"))){
//            workbook.write(fos);
//            System.out.println("OK");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void test () throws  Exception {
//        try{
//            FileOutputStream fos = new FileOutputStream(new File("test.xlsx"));
//
//        }finally {
//            fos.close();
//        }
//    }
}
