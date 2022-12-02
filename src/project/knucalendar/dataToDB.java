package project.knucalendar;

import java.sql.*;

public class dataToDB {
    Connection conn = null;
    PreparedStatement pstmt;
    String url = "jdbc:sqlite:database:db";
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

        getDday = getDday(getStartDate, getEndDate);

        System.out.println(getStartDate+" "+getEndDate+" "+nameData+" "+kindData+" "+whereData+" "+stringData+" "+getStartYear);

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            String insertSQL = "insert into diarydata values(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1,getStartYear);
            pstmt.setInt(2,getStartMonth);
            pstmt.setInt(3,getStartDayofMonth);
            pstmt.setString(4,nameData);

            if (kindData.equals("학사일정"))
                pstmt.setString(5,"university");
            else if (kindData.equals("공휴일"))
                pstmt.setString(5,"legalholiday");
            else if (kindData.equals("시험"))
                pstmt.setString(5,"test");
            else if (kindData.equals("과제"))
                pstmt.setString(5,"homework");
            else if (kindData.equals("개인일정"))
                pstmt.setString(5,"user");
            if (stringData.equals(""))
                pstmt.setString(6,null);
            else
                pstmt.setString(6,stringData);
            if (whereData.equals(""))
                pstmt.setString(7,null);
            else
                pstmt.setString(7,whereData);

            if (kindData.equals("학사일정"))
                pstmt.setString(8,"university.png");
            else if (kindData.equals("공휴일"))
                pstmt.setString(8,"user.png");
            else if (kindData.equals("시험"))
                pstmt.setString(8,"test.png");
            else if (kindData.equals("과제"))
                pstmt.setString(8,"homework.png");
            else if (kindData.equals("개인일정"))
                pstmt.setString(8,"user.png");

            pstmt.executeUpdate();
        } catch(Exception e) {
            System.out.println();
        }
    }
}
