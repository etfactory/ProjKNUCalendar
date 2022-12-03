package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class connectDB {
    Connection conn;
    Statement stmt;
    ResultSet result;
    public connectDB(){
        String url = "jdbc:sqlite:database.db";

        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("DB 테스트 연결 완료");

            stmt=conn.createStatement();
            result=stmt.executeQuery("select * from diarydata;");
            System.out.println(result);
        } catch(Exception e) {
            System.out.println();
        }
    }
}
