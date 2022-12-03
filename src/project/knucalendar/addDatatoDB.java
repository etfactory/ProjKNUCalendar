package project.knucalendar;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class addDatatoDB {
    String getName, getKind, getWhere, getString, getIcon;
    int getYear, getMonth, getDayofMonth;
    private DMLService DML = new DMLService("jdbc:sqlite:database.db");
    public addDatatoDB(int getStartDate, int getEndDate, String nameData,
                                  String kindData, String whereData, String stringData,
                                  int getStartYear, int getStartMonth, int getStartDayofMonth,
                                  int getEndYear, int getEndMonth, int getEndDayofMonth) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        getName = nameData;
        getKind = kindData;
        getWhere = whereData;
        getString = stringData;
        getIcon = null;

        getYear = getStartYear;
        getMonth = getStartMonth;
        getDayofMonth = getStartDayofMonth;

        if (getKind.equals("학사일정")) {
            getIcon = "university.png";
        } else if (getKind.equals("공휴일")) {
            getIcon = "user.png";
        } else if (getKind.equals("시험")) {
            getIcon = "test.png";
        } else if (getKind.equals("과제")) {
            getIcon = "homework.png";
        } else if (getKind.equals("개인일정")) {
            getIcon = "user.png";
        }
        if (getString.equals("")) {
            getString = null;
        }
        if (getWhere.equals("") || getWhere.equals(null)) {
            getWhere = null;
        }

        insert();
    }
    public void insert() throws SQLException {
        // 상수 설정
        //   - Data를 저장할 객체 생성
        //     * 입력/수정/삭제/조회 에서 공통으로 사용
        final Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("year", getYear);
        dataMap.put("month", getMonth);
        dataMap.put("date", getDayofMonth);
        dataMap.put("name", getName);
        dataMap.put("kind", getKind);
        dataMap.put("string", getString);
        dataMap.put("where", getWhere);
        dataMap.put("icon", getIcon);

        // 데이터 입력
        int inserted = DML.insertData(dataMap);
        if( inserted >= 0 ) {
            System.out.println(String.format("데이터 입력 성공: %d건", inserted));
        } else {
            System.out.println("데이터 입력 실패");
        }
    }
}
