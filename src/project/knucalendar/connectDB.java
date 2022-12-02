package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class connectDB {
    public connectDB(){
        Connection conn;
        String url = "jdbc:sqlite:database.db";
        Statement stmt;
        ResultSet result;

        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("DB 연결 완료");

            stmt=conn.createStatement();
            result=stmt.executeQuery("select * from diarydata;");
            System.out.println(result);
        } catch(Exception e) {
            System.out.println();
        }
    }
}
