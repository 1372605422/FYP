package com.database;
import java.sql.*;

public class DatabaseTest {
        public static void main(String[] args) {
            Connection conn = null;
            try {
                // 连接到 SQLite 数据库
                conn = DriverManager.getConnection("jdbc:sqlite:FinanceData.db");

                // 执行查询语句
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM FiData");

                // 遍历结果集并输出数据
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String columnName = resultSet.getString("column_name");
                    double value = resultSet.getDouble("value");

                    System.out.println("ID: " + id);
                    System.out.println("Column Name: " + columnName);
                    System.out.println("Value: " + value);
                    System.out.println("--------------");
                }
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
