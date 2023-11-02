package com.database;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
    // 把json格式的字符串写到文件
    public static void writeFile(String filePath, String sets) {
        sets = "{ \"Ticker\": \"" + sets + "\" }";
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(sets);
            out.println();
            fw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}