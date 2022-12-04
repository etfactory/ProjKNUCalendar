package project.knucalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DMLService extends SQLiteManager {

    // 생성자
    public DMLService() {

    }
    public DMLService(String url) {
        super(url);
    }

    // 데이터 삽입 함수
    public int insertData(Map<String, Object> dataMap) throws SQLException {
        final String sql = "INSERT INTO diarydata ("+"\n"
                + "    year,                       "+"\n"
                + "    month,                      "+"\n"
                + "    date,                       "+"\n"
                + "    name,                       "+"\n"
                + "    kind,                       "+"\n"
                + "    string,                     "+"\n"
                + "    address,                    "+"\n"
                + "    icon                        "+"\n"
                + ") VALUES (                      "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?,                          "+"\n"
                + "    ?                           "+")";

        // 변수설정
        //   - Database 변수
        Connection conn = ensureConnection();
        PreparedStatement pstmt = null;

        //   - 입력 결과 변수
        int inserted = 0;

        try {
            // PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);

            // 입력 데이터 매핑
            pstmt.setObject(1, dataMap.get("year"));
            pstmt.setObject(2, dataMap.get("month"));
            pstmt.setObject(3, dataMap.get("date"));
            pstmt.setObject(4, dataMap.get("name"));
            pstmt.setObject(5, dataMap.get("kind"));
            pstmt.setObject(6, dataMap.get("string"));
            pstmt.setObject(7, dataMap.get("address"));
            pstmt.setObject(8, dataMap.get("icon"));

            // 쿼리 실행
            pstmt.executeUpdate();

            // 입력건수  조회
            inserted = pstmt.getUpdateCount();

            // 트랜잭션 COMMIT
            conn.commit();

        } catch (SQLException e) {
            // 오류출력
            System.out.println(e.getMessage());

            // 트랜잭션 ROLLBACK
            if( conn != null ) {
                conn.rollback();
            }

            // 오류
            inserted = -1;

        } finally {
            // PreparedStatement 종료
            if( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 결과 반환
        //   - 입력된 데이터 건수
        return inserted;
    }
}