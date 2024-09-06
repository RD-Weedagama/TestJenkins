package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            FileInputStream inputStream = new FileInputStream(excelPath);
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getData() {
        List<String[]> data = new ArrayList<>();
        for (Row row : sheet) {
            String[] rowData = new String[row.getPhysicalNumberOfCells()];
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                rowData[i] = row.getCell(i).getStringCellValue();
            }
            data.add(rowData);
        }
        return data;
    }

    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}