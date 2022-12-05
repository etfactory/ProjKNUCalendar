package project.knucalendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DQLService extends SQLiteManager {
    String getHolidayNames[] = new String[15];
    String getUnivNames[] = new String[15];
    String getTestNames[] = new String[15];
    String getHomeworkNames[] = new String[15];
    String getUserNames[] = new String[15];

    ArrayList<String> returnHoliday;
    ArrayList<String> returnUniv;
    ArrayList<String> returnHomework;
    ArrayList<String> returnTest;
    ArrayList<String> returnUser;

    int holidaycount = 0;
    int univcount = 0;
    int testcount = 0;
    int homeworkcount = 0;
    int usercount = 0;
    // 생성자
    public DQLService() {

    }
    public DQLService(String url) {
        super(url);
    }

    // 데이터 조회 함수
    public List<Map<String, Object>> selectList(Map<String, Object> dataMap){
        // 상수설정
        //   - SQL
        final String SQL = "SELECT T1.year           "+"\n"
                + "     , T1.month                   "+"\n"
                + "     , T1.date                    "+"\n"
                + "     , T1.name                    "+"\n"
                + "     , T1.kind                    "+"\n"
                + "     , T1.string                  "+"\n"
                + "     , T1.address                 "+"\n"
                + "     , T1.icon                    "+"\n"
                + "  FROM diarydata T1               "+"\n"
                + " WHERE 1=1                        "+"\n"
                + "   AND T1.year = ?                "+"\n"
                + "   AND T1.month = ?               "+"\n"
                + "   AND T1.date = ?                "+"\n"
                ;

        //   - 조회 결과 변수
        final Set<String> columnNames = new HashSet<String>();
        final List<Map<String, Object>> selected = new ArrayList<Map<String, Object>>();

        // 변수설정
        //   - Database 변수
        Connection conn = ensureConnection();
        PreparedStatement pstmt = null;
        ResultSetMetaData meta = null;

        try {
            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(SQL);

            // 조회 데이터 조건 매핑
            pstmt.setObject(1, dataMap.get("year"));
            pstmt.setObject(2, dataMap.get("month"));
            pstmt.setObject(3, dataMap.get("date"));

            // 데이터 조회
            ResultSet rs = pstmt.executeQuery();

            // 조회된 데이터의 컬럼명 저장
            meta = pstmt.getMetaData();
            for(int i=1; i<=meta.getColumnCount(); i++) {
                columnNames.add(meta.getColumnName(i));
            }

            // ResultSet -> List<Map> 객체
            Map<String, Object> resultMap = null;

            while(rs.next()) {
                resultMap = new HashMap<String, Object>();

                for(String column : columnNames) {
                    resultMap.put(column, rs.getObject(column));
                }

                if( resultMap != null ) {
                    selected.add(resultMap);
                }
            }

        } catch (SQLException e) {
            // 오류처리
            System.out.println(e.getMessage());

        } finally  {
            try {
                // PreparedStatement 종료
                if( pstmt != null ) {
                    pstmt.close();
                }

                // Database 연결 종료
                closeConnection();

            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }

        // 결과 반환
        //   - 조회된 데이터 리스트
        return selected;
    }
    public List<Map<String, Object>> findKind(Map<String, Object> dataMap){
        // 상수설정
        //   - SQL
        final String SQL = "SELECT T1.year           "+"\n"
                + "     , T1.month                   "+"\n"
                + "     , T1.date                    "+"\n"
                + "     , T1.kind                    "+"\n"
                + "     , T1.name                    "+"\n"
                + "     , T1.string                  "+"\n"
                + "     , T1.address                 "+"\n"
                + "     , T1.icon                    "+"\n"
                + "  FROM diarydata T1               "+"\n"
                + " WHERE 1=1                        "+"\n"
                + "   AND T1.year = ?                "+"\n"
                + "   AND T1.month = ?               "+"\n"
                + "   AND T1.date = ?                "+"\n"
                + "   AND T1.kind = ?                "+"\n"
                ;

        //   - 조회 결과 변수
        final Set<String> columnNames = new HashSet<String>();
        final List<Map<String, Object>> selected = new ArrayList<Map<String, Object>>();

        // 변수설정
        //   - Database 변수
        Connection conn = ensureConnection();
        PreparedStatement pstmt = null;
        ResultSetMetaData meta = null;

        try {
            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(SQL);

            // 조회 데이터 조건 매핑
            pstmt.setObject(1, dataMap.get("year"));
            pstmt.setObject(2, dataMap.get("month"));
            pstmt.setObject(3, dataMap.get("date"));
            pstmt.setObject(4, dataMap.get("kind"));

            // 데이터 조회
            ResultSet rs = pstmt.executeQuery();

            // 조회된 데이터의 컬럼명 저장
            meta = pstmt.getMetaData();
            for(int i=1; i<=meta.getColumnCount(); i++) {
                columnNames.add(meta.getColumnName(i));
            }

            // ResultSet -> List<Map> 객체
            Map<String, Object> resultMap = null;

            while(rs.next()) {
                resultMap = new HashMap<String, Object>();

                for(String column : columnNames) {
                    resultMap.put(column, rs.getObject(column));
                }
                if( resultMap != null ) {
                    selected.add(resultMap);
                    if(rs.getString(4).equals("학사일정")) {
                        getUserNames[univcount] = rs.getString(5);
                        univcount++;
                    }
                    else if (rs.getString(4).equals("공휴일")) {
                        getHolidayNames[holidaycount] = rs.getString(5);
                        holidaycount++;
                    }
                    else if (rs.getString(4).equals("시험")) {
                        getTestNames[testcount] = rs.getString(5);
                        testcount++;
                    }
                    else if (rs.getString(4).equals("과제")) {
                        getHomeworkNames[homeworkcount] = rs.getString(5);
                        homeworkcount++;
                    }
                    else if (rs.getString(4).equals("개인일정")) {
                        getUserNames[usercount] = rs.getString(5);
                        usercount++;
                    }
                }
            }

        } catch (SQLException e) {
            // 오류처리
            System.out.println(e.getMessage());

        } finally  {
            try {
                // PreparedStatement 종료
                if( pstmt != null ) {
                    pstmt.close();
                }

                // Database 연결 종료
                closeConnection();

            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        // 결과 반환
        //   - 조회된 데이터 리스트
        return selected;
    }

    public String[] getHolidayName(){
        return getHolidayNames;
    }
    public String[] getUnivName(){
        return getUnivNames;
    }
    public String[] getTestName(){
        return getTestNames;
    }
    public String[] getHomeworkName(){
        return getHomeworkNames;
    }
    public String[] getUserNames(){
        return getUserNames;
    }

    // 조회 결과 출력 함수
    public void printMapList(List<Map<String, Object>> mapList) {
        if( mapList.size() == 0 ) {
            System.out.println("조회된 데이터가 없습니다.");
            return;
        }

        // 상세 데이터 출력
        System.out.println(String.format("데이터 조회 결과: %d건", mapList.size()));

        for(int i = 1; i <= mapList.size(); i++) {
            Map<String, Object> map = mapList.get(i-1);

            StringBuilder sb = new StringBuilder();

            sb.append("{");
            map.entrySet().forEach(( entry )->{
                sb.append('"')
                        .append(entry.getKey())
                        .append("\": \"")
                        .append(entry.getValue())
                        .append("\" , ");
            });
            sb.append("}");

            System.out.println(sb.toString());
        }
    }

    public void clear(){
        holidaycount=0;
        univcount=0;
        testcount=0;
        homeworkcount=0;
        usercount=0;
        for(int i=0;i<15;i++){
            getHolidayNames[i]  =null;
            getUnivNames[i]     =null;
            getTestNames[i]     =null;
            getHomeworkNames[i] =null;
            getUserNames[i]     =null;
        }
    }

    public int toInt(List<Map<String, Object>> mapList){
        return(mapList.size());
    }
}
