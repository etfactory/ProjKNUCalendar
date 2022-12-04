package project.knucalendar;

import java.sql.*;

public class resetProgram {
    // 변수 생성
    private DDLService DDL = new DDLService("jdbc:sqlite:database.db");

    // 테이블 생성 함수
    public resetProgram(){
    }
    public void createTable() throws SQLException {
        //
        final String SQL = "CREATE TABLE IF NOT EXISTS diarydata (  "+"\n"
                + "  year        INTEGER        NOT NULL,           "+"\n"
                + "  month       INTEGER        NOT NULL,           "+"\n"
                + "  date        INTEGER        NOT NULL,           "+"\n"
                + "  name        TEXT           NOT NULL,           "+"\n"
                + "  kind        TEXT           NOT NULL,           "+"\n"
                + "  string      TEXT,                              "+"\n"
                + "  address     TEXT,                              "+"\n"
                + "  icon        TEXT                               "+")";

        // 테이블 생성
        DDLService.ResultType result = DDL.createTable("diarydata", SQL);

        // 테이블 생성 결과 출력
        switch( result ) {
            case SUCCESS:
                System.out.println("테이블 생성 완료.");
                break;
            case WARNING:
                System.out.println("테이블이 이미 존재합니다.");
                break;
            case FAILURE:
                System.out.println("테이블 생성 실패.");
                break;
        }

        // DB 연결 종료
        DDL.closeConnection();
    }

    // 테이블 삭제 함수
    public void dropTable() throws SQLException {

        // 테이블 삭제
        DDLService.ResultType result = DDL.dropTable("diarydata");

        // 테이블 삭제 결과 출력
        switch( result ) {
            case SUCCESS:
                System.out.println("테이블 삭제 완료.");
                break;
            case WARNING:
                System.out.println("테이블이 존재하지 않습니다.");
                break;
            case FAILURE:
                System.out.println("테이블 삭제 실패.");
                break;
        }

        // DB 연결 종료
        DDL.closeConnection();
    }
}
