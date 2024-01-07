package com.qa.utils.excel;

import com.qa.constants.FrameworkConstants;
import com.qa.exceptions.FrameworkException;
import com.qa.exceptions.InvalidPathForExcelException;
import lombok.SneakyThrows;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static List<Map<String, String>> importTestData(String sheetname) {
        List<Map<String, String>> list = new ArrayList<>();
        String excelFile = FrameworkConstants.getExcelFilePath();
        try (FileInputStream fs = new FileInputStream(excelFile)) {

            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetname);

            int lastRowNum = sheet.getLastRowNum();
            int lastColumnNum = sheet.getRow(0).getLastCellNum();
            Map<String, String> map = null;
            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColumnNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException exception) {
            throw new InvalidPathForExcelException("Excel File: " + excelFile + " you trying to read is not found");
        } catch (IOException e) {
            throw new FrameworkException("Some io exception happened while reading excel file: " + excelFile);
        }
        return list;
    }

    @SneakyThrows
    public static void downloadExcelFile(String url, String dest){

        URL sourceURL = new URL(url);

        Path targetPath = Path.of(dest);

        try(InputStream in = sourceURL.openStream()){
            Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File downloaded successfully from google drive.");
        }


    }
}
