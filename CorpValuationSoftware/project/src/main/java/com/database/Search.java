package com.database;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public static int searchOline(){
        //TODO 等python文件封装好后，再写
        return 1;
    }

    //调用info显示到database页面


    //手动添加数据部分

    // download到本地，需要创建excel表格并将数据保存在excel中
    public static void downloadData(){
        //生成一份excel文件，文件格式类似于彭博终端，表中分别打印income statement，balance sheet and cash flow等数据
    }
    //import excel表格，并将按格式做成的表格保存在database中
    public static void importData(){
        //将用户输入的数据，更新到数据库中
    }

}
