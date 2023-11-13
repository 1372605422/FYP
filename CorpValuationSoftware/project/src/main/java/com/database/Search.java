package com.database;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.nio.channels.FileChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Search {
    // 获取 Logger


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

    public static int searchOnline(String path) throws IOException, InterruptedException {
        // 使用 ProcessBuilder 构建执行命令
        ProcessBuilder processBuilder = new ProcessBuilder(path);

        // 启动进程
        Process process = processBuilder.start();

        // 读取标准输出流
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            // 处理标准输出，如果需要的话
            System.out.println("Standard Output: " + line);
        }

        // 读取错误输出流
        InputStream errorStream = process.getErrorStream();
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
        while ((line = errorReader.readLine()) != null) {
            // 打印错误输出到控制台
            System.out.println("Error Output: " + line);
        }

        // 等待进程执行完成
        int exitCode = process.waitFor();

        if (exitCode == 0){
            return 0;
        }else {
            return 1;
        }
    }

    //调用info显示到database页面


    //手动添加数据部分


    // download到本地，需要创建excel表格并将数据保存在excel中
    public static void downloadData(String name, String savePath, ResultSet resultSet){
        //生成一份excel文件，文件格式类似于彭博终端，表中分别打印income statement，balance sheet and cash flow等数据
        String filePath = Search.copySheet(name, savePath);
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowOne = 3;
            Row row = sheet.createRow(rowOne);
            Cell cell;

            while (resultSet.next()) {
                String columnName = resultSet.getString("income_statement_index");
                double value = resultSet.getDouble("income_statement_value");
                String balanceSheetIndex = resultSet.getString("balance_sheet_index");
                double balanceSheetValue = resultSet.getDouble("balance_sheet_value");
                String cashFlowIndex = resultSet.getString("cashflow_index");
                double cashFlowValue = resultSet.getDouble("cashflow_value");
                String priceIndex = resultSet.getString("current_price_value");

                if (priceIndex != null){
                    try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                        workbook.write(fileOutputStream);
                    }
                    return;
                }

                if (Objects.equals(balanceSheetIndex, null) && Objects.equals(cashFlowIndex, null)) {
                    if (flag){
                        cell = row.createCell(0);
                        cell.setCellValue("Income Statement");
                        cell = row.createCell(1);
                        cell.setCellValue("");

                        rowOne++;
                        row = sheet.getRow(rowOne);
                        // 写入income statement
                        cell = row.createCell(0);
                        cell.setCellValue(columnName);
                        cell = row.createCell(1);
                        cell.setCellValue(value);

                        flag = false;
                    }  else {
                    // 写入income statement
                        cell = row.createCell(0);
                        cell.setCellValue(columnName);

                        cell = row.createCell(1);
                        cell.setCellValue(value);
                    }

                } else if (Objects.equals(columnName, null) && Objects.equals(cashFlowIndex, null)) {
                    if (flag1){
                        cell = row.createCell(0);
                        cell.setCellValue("Balance Sheet");
                        cell = row.createCell(1);
                        cell.setCellValue("");

                        rowOne++;
                        row = sheet.getRow(rowOne);
                        // 写入income statement
                        cell = row.createCell(0);
                        cell.setCellValue(balanceSheetIndex);
                        cell = row.createCell(1);
                        cell.setCellValue(balanceSheetValue);


                        flag1 = false;
                    }else {
                        cell = row.createCell(0);
                        cell.setCellValue(balanceSheetIndex);

                        cell = row.createCell(1);
                        cell.setCellValue(balanceSheetValue);
                    }
                } else if (Objects.equals(columnName, null) && Objects.equals(balanceSheetIndex, null)) {
                    cell = row.createCell(0);
                    if (flag2){
                        cell.setCellValue("Cash Flow");
                        cell = row.createCell(1);
                        cell.setCellValue("");

                        rowOne++;
                        row = sheet.getRow(rowOne);
                        // 写入income statement
                        cell = row.createCell(0);
                        cell.setCellValue(cashFlowIndex);
                        cell = row.createCell(1);
                        cell.setCellValue(cashFlowValue);

                        flag2 = false;
                    }else {
                        cell.setCellValue(cashFlowIndex);

                        cell = row.createCell(1);
                        cell.setCellValue(cashFlowValue);
                    }
                }


                rowOne++;
                row = sheet.getRow(rowOne);
                if (row == null) {
                    row = sheet.createRow(rowOne);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String  checkCol(Connection conn,String  ticker){
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM " + ticker;
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                if (columnName.equals("underlyingSymbol")){
                    return resultSet.getString("underlyingSymbol");
                }
            }
        } catch (SQLException t) {
            System.out.println("No such table");
        }

        return null;
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
    public static void importData(String tableName, String filePath, Connection connection){
        //将用户输入的数据，更新到数据库中
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            // 准备更新语句
            String updateStatement = "UPDATE " + tableName + " SET "
                    + "income_statement_index = ?, "
                    + "income_statement_value = ?, "
                    + "balance_sheet_index = ?, "
                    + "balance_sheet_value = ?, "
                    + "cashflow_index = ?, "
                    + "cashflow_value = ? "
                    + "WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            int rowIndex;
            // 遍历Excel表格行
            for (Row row : sheet) {
                rowIndex = row.getRowNum();
                Cell indexCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (indexCell != null && valueCell != null && rowIndex >= 3) {

                    String index = indexCell.getStringCellValue();
                    switch (index) {
                        case "Income Statement" -> {
                            flag = true;
                            continue;
                        }
                        case "Balance Sheet" -> {
                            flag = false;
                            flag1 = true;
                            continue;
                        }
                        case "Cash Flow" -> {
                            flag1 = false;
                            flag2 = true;
                            continue;
                        }
                    }
                    double value = valueCell.getNumericCellValue();


                    if (flag){
                        // 设置更新语句参数
                        preparedStatement.setString(1, index);
                        preparedStatement.setDouble(2, value);
                        preparedStatement.setString(3, null);
                        preparedStatement.setString(4, null);
                        preparedStatement.setString(5, null);
                        preparedStatement.setString(6, null);
                        rowIndex -= 3;
                        preparedStatement.setInt(7, rowIndex);

                        // 执行更新
                        preparedStatement.executeUpdate();
                    } else if (flag1) {
                        // 设置更新语句参数
                        preparedStatement.setString(1, null);
                        preparedStatement.setString(2, null);
                        preparedStatement.setString(3, index);
                        preparedStatement.setDouble(4, value);
                        preparedStatement.setString(5, null);
                        preparedStatement.setString(6, null);
                        rowIndex -= 4;
                        preparedStatement.setInt(7, rowIndex);

                        // 执行更新
                        preparedStatement.executeUpdate();

                    } else if (flag2) {
                        // 设置更新语句参数
                        preparedStatement.setString(1, null);
                        preparedStatement.setString(2, null);
                        preparedStatement.setString(3, null);
                        preparedStatement.setString(4, null);
                        preparedStatement.setString(5, index);
                        preparedStatement.setDouble(6, value);
                        rowIndex -= 5;
                        preparedStatement.setInt(7, rowIndex);

                        // 执行更新
                        preparedStatement.executeUpdate();
                    }
                }
            }

            // 关闭预处理语句
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
