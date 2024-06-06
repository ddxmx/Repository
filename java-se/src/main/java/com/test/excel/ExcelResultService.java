package com.test.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExcelResultService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelResultService.class);

    private static final String inputServicesFileName = "input-services.xlsx";

    private static final String outputVariableFileName = "sensitive-variable.xlsx";

    private static final Map<String, String> inputServiceMap = new LinkedHashMap<>();

    public static void readExcel() {
        String path = ExcelResultService.class.getClassLoader().getResource(inputServicesFileName).getPath();

        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("从{}文件中读取数据失败", inputServicesFileName);
        }

        if (workbook == null) {
            return;
        }

        Sheet sheet = workbook.getSheetAt(0);
        if (sheet == null) {
            return;
        }

        // 从第二行开始读，遍历到最后一行
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            String serviceName = row.getCell(0).getStringCellValue();
            String serviceUrl = row.getCell(1).getStringCellValue();

            inputServiceMap.put(serviceName, serviceUrl);
        }

        LOGGER.info("从{}文件中读取数据成功", inputServicesFileName);
        System.out.println(inputServiceMap);
    }

    public static void writeExcelTitle(String filePath, List<String> columnNameList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        // 在第一行写入数据
        if (row0 != null) {
            for (int i = 0; i < columnNameList.size(); i++) {
                row0.createCell(i, CellType.STRING).setCellValue(columnNameList.get(i));
            }
        }

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("{}中新增一条记录失败", new File(outputVariableFileName).getName());
        }
    }

    public static void writeExcel(String filePath, List<String> cellList) {
        try (FileInputStream in = new FileInputStream(filePath)
        ) {
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 0; i < cellList.size(); i++) {
                sheet.autoSizeColumn(i);
            }
            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

            for (int i = 0; i < cellList.size(); i++) {
                newRow.createCell(i, CellType.STRING).setCellValue(cellList.get(i));
            }

            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();

            LOGGER.info("{}中新增一条记录成功", new File(filePath).getName());
        } catch (Exception e) {
            LOGGER.error("{}中新增一条记录失败", new File(filePath).getName());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        readExcel();

        String filePath = ExcelResultService.class.getResource("/").getPath() + outputVariableFileName;
        List<String> columnNameList = Arrays.asList("ServiceName", "Branch", "Stage", "Activity",
                "variableName", "variableType", "variableValue", "variableEncrypt", "variableUpdateUser", "variableUpdateTime");

        writeExcelTitle(filePath, columnNameList);
        for (int i = 100; i < 110; i++) {
            writeExcel(filePath,
                    Arrays.asList(
                            "A" + i,
                            "B" + i,
                            "C" + i,
                            "D" + i,
                            "E" + i,
                            "F" + i,
                            "G" + i,
                            "H" + i,
                            "I" + i,
                            "J" + i
                    ));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
