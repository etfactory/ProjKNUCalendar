package project.knucalendar;

import java.sql.*;

public class dataToDB {
    int getStartDate, getEndDate, getDday;
    public int getDday(int getStartDate, int getEndDate){
        int result = getEndDate-getStartDate;
        if(result==0)
            result=1;

        return result;
    }
    public dataToDB(int getStartDate, int getEndDate, String nameData,
                    String kindData, String whereData, String stringData,
                    int getStartYear, int getStartMonth, int getStartDayofMonth,
                    int getEndYear, int getEndMonth, int getEndDayofMonth) throws ClassNotFoundException, SQLException{

        Connection conn;
        String url = "jdbc:sqlite:database.db";
        Statement stmt;
        ResultSet result;

        getDday = getDday(getStartDate, getEndDate);

        System.out.println(getStartDate+" "+getEndDate+" "+nameData+" "+kindData+" "+whereData+" "+stringData+" "+getStartYear);

        String getName = nameData;
        String getKind = kindData;
        String getWhere = whereData;
        String getString = stringData;

        int getYear = getStartYear;
        int getMonth = getStartMonth;
        int getDayofMonth = getStartDayofMonth;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("DB 연결 완료");

            stmt=conn.createStatement();
            result=stmt.executeQuery("select * from diarydata;");
            System.out.println(result);

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            result=stmt.executeQuery("select * from diarydata;");

            String insertSQL = "insert into diarydata values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            pstmt.setInt(1, getYear);
            pstmt.setInt(2, getMonth);
            pstmt.setInt(3, getDayofMonth);

            pstmt.setString(4, getName);

            if (getKind.equals("학사일정")) {
                pstmt.setString(5, "university");
                pstmt.setString(8, "university.png");
            } else if (getKind.equals("공휴일")) {
                pstmt.setString(5, "legalholiday");
                pstmt.setString(8, "user.png");
            } else if (getKind.equals("시험")) {
                pstmt.setString(5, "test");
                pstmt.setString(8,"test.png");
            } else if (getKind.equals("과제")) {
                pstmt.setString(5, "homework");
                pstmt.setString(8,"homework.png");
            } else if (getKind.equals("개인일정")) {
                pstmt.setString(5, "user");
                pstmt.setString(8,"user.png");
            }
            if (getString.equals(""))
                pstmt.setString(6,null);
            else
                pstmt.setString(6,getString);
            if (getWhere.equals(""))
                pstmt.setString(7,null);
            else
                pstmt.setString(7,getWhere);

            result = pstmt.executeQuery();
            stmt.executeQuery("insert into diarydata values (getYear,getMonth,getDayofMonth,getName,getKind,getString,getWhere,getIcon)");
            System.out.println(result);
        } catch(Exception e) {
            System.out.println();
        }
    }
}
