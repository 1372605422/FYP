package com.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    //调用info显示到database页面

    //调用financials当用户点击load时

    //手动添加数据部分
    // download到本地，需要创建excel表格并将数据保存在excel中

    //import excel表格，并将按格式做成的表格保存在database中
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:FinanceData.db");
        List<String> strings = getDataTable(conn);
        System.out.println(strings);
        conn.close();
    }
}
