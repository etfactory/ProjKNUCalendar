package project.knucalendar;

import java.sql.*;

public class addDatatoDB {
    public addDatatoDB(int getStartDate, int getEndDate, String nameData,
                                  String kindData, String whereData, String stringData,
                                  int getStartYear, int getStartMonth, int getStartDayofMonth,
                                  int getEndYear, int getEndMonth, int getEndDayofMonth) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        String getName = nameData;
        String getKind = kindData;
        String getWhere = whereData;
        String getString = stringData;
        String getIcon;

        int getYear = getStartYear;
        int getMonth = getStartMonth;
        int getDayofMonth = getStartDayofMonth;

        String insertSQL = "insert into diarydata values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        pstmt.setInt(1, getYear);
        pstmt.setInt(2, getMonth);
        pstmt.setInt(3, getDayofMonth);

        pstmt.setString(4, getName);

        if (getKind.equals("학사일정")) {
            pstmt.setString(5, "university");
            pstmt.setString(8, "university.png");
            getIcon = "university.png";
        } else if (getKind.equals("공휴일")) {
            pstmt.setString(5, "legalholiday");
            pstmt.setString(8, "user.png");
            getIcon = "user.png";
        } else if (getKind.equals("시험")) {
            pstmt.setString(5, "test");
            pstmt.setString(8,"test.png");
            getIcon = "test.png";
        } else if (getKind.equals("과제")) {
            pstmt.setString(5, "homework");
            pstmt.setString(8,"homework.png");
            getIcon = "homework.png";
        } else if (getKind.equals("개인일정")) {
            pstmt.setString(5, "user");
            pstmt.setString(8,"user.png");
            getIcon = "user.png";
        }
        if (getString.equals("")) {
            pstmt.setString(6, null);
            getString = null;
        } else
            pstmt.setString(6,getString);
        if (getWhere.equals("")) {
            pstmt.setString(7, null);
            getWhere = null;
        } else
            pstmt.setString(7,getWhere);

        int result = pstmt.executeUpdate();
        System.out.println(result);

        if( result >= 0 ) {
            System.out.println(String.format("데이터 입력 성공: %d건", result));
        } else {
            System.out.println("데이터 입력 실패");
        }
    }
}
