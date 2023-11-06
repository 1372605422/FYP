package com.database;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Search {

    //TODO 查现有的表，先查表，如果现有的表中没有，先返回弹窗，询问是否需要从网络中下载。如果需要，则调用py程序download
    //将现存的表加入到下拉菜单中
    public static List<String> getDataTable(Connection conn) throws SQLException {
        // 执行查询语句
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");


        List<String> tableNames = new ArrayList<>();

        while (resultSet.next()) {
            String tableName = resultSet.getString("name");
            tableNames.add(tableName);
        }

        // 删除第一个元素
        if (!tableNames.isEmpty()) {
            tableNames.remove(0);
        }

        return tableNames;
    }

    public static ResultSet searchTable(Connection conn, String tableName) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM " + tableName;
        return statement.executeQuery(sql);
    }

    public static int searchOline(){
        //TODO 等python文件封装好后，再写
        return 1;
    }

    //调用info显示到database页面


    //手动添加数据部分



    // download到本地，需要创建excel表格并将数据保存在excel中
    public static void downloadData(String name, String savePath, ResultSet resultSet){
        //生成一份excel文件，文件格式类似于彭博终端，表中分别打印income statement，balance sheet and cash flow等数据
        String filePath = Search.copySheet(name, savePath);

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowOne = 3;
            Row row = sheet.getRow(rowOne);
            if (row == null) {
                row = sheet.createRow(rowOne);
            }
            Cell cell;

            while (resultSet.next()) {
                String columnName = resultSet.getString("income_statement_index");
                double value = resultSet.getDouble("income_statement_value");
                String balanceSheetIndex = resultSet.getString("balance_sheet_index");
                double balanceSheetValue = resultSet.getDouble("balance_sheet_value");
                String cashFlowIndex = resultSet.getString("cashflow_index");
                double cashFlowValue = resultSet.getDouble("cashflow_value");
                String priceIndex = resultSet.getString("current_price");

                cell = row.createCell(0);
                if (Objects.equals(balanceSheetIndex, null) && Objects.equals(cashFlowIndex, null)) {
                    // 写入income statement
                    cell.setCellValue(columnName);

                    cell = row.createCell(1);
                    cell.setCellValue(value);
                } else if (Objects.equals(columnName, null) && Objects.equals(cashFlowIndex, null)) {
                    cell = row.createCell(0);
                    cell.setCellValue(balanceSheetIndex);

                    cell = row.createCell(1);
                    cell.setCellValue(balanceSheetValue);
                } else if (Objects.equals(columnName, null) && Objects.equals(balanceSheetIndex, null) && priceIndex == null) {

                    cell = row.createCell(0);
                    cell.setCellValue(cashFlowIndex);

                    cell = row.createCell(1);
                    cell.setCellValue(cashFlowValue);
                }

                rowOne++;
                row = sheet.getRow(rowOne);
                if (row == null) {
                    row = sheet.createRow(rowOne);
                }
            }

            // 保存修改后的文件
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                workbook.write(fileOutputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   public static String copySheet(String name, String savePath){
        String sourceFilePath = "example.xlsx";
        String destinationFilePath = savePath + "/" + name + ".xlsx";
        try (FileInputStream sourceFileInputStream = new FileInputStream(sourceFilePath);
             FileOutputStream destinationFileOutputStream = new FileOutputStream(destinationFilePath)) {

            // 复制文件内容
            FileChannel sourceChannel = sourceFileInputStream.getChannel();
            FileChannel destinationChannel = destinationFileOutputStream.getChannel();
            destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationFilePath;
    }

    //import excel表格，并将按格式做成的表格保存在database中
    public static void importData(){
        //将用户输入的数据，更新到数据库中
        
    }

    public static void main(String[] args) {

    }
}
