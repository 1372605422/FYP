package com.database;

import java.sql.*;

public class ImportData {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 连接到 SQLite 数据库
            conn = DriverManager.getConnection("jdbc:sqlite:FinanceData.db");
            Search.importData("GOOG","/Users/allan/Downloads/FYP/GOOG.xlsx", conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
