package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class connectDB {

    ImageIcon calendarForUser = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/diaryIcon/user.png")));
    public connectDB(){
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/diarydata?serverTimezon=UTC";
        String id = "root";
        String pw = "pw123";

        Statement stmt;
        ResultSet result;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,id,pw);
            System.out.println("DB 연결 완료");

            stmt = conn.createStatement();

            stmt.executeUpdate("insert into diarydata values(2022 ,12 , 25, 'Christmas', NULL, NULL, calendarForUser)");
        } catch(ClassNotFoundException e){
            System.out.println();
        } catch(SQLException e){
            System.out.println();
        }
    }
}
