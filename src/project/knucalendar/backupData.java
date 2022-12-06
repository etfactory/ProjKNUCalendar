package project.knucalendar;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class backupData extends SQLiteManager{
    int size;
    public backupData(){

    }
    public int insert() throws IOException, SQLException {
        int inserted = 0;

        Connection conn = ensureConnection();
        Statement stmt = null;


        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 1, 1, '신정', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 1, 31, '설연휴', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 1, '설날', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 2, '설연휴', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 1, '삼일절', '공휴일', '국경일', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 9, '20대 대선', '공휴일', '제20대 대통령 선거', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 5, 5, '어린이날', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 1, '지방선거', '공휴일', '제8회 전국동시지방선거', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 6, '현충일', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 7, 17, '제헌절', '공휴일', '국경일', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 15, '광복절', '공휴일', '국경일', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 9, '추석연휴', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 10, '추석', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 11, '추석연휴', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 12, '대체공휴일', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 3, '개천절', '공휴일', '국경일', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 9, '한글날', '공휴일', '국경일', null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 10, '대체공휴일', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 25, '크리스마스', '공휴일', null, null, 'user.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 1, 3, '정시원서접수마감', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 1, 3, '시무식', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 1, '휴·복학원 제출 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 9, '1학기 수강신청기간 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 15, '1학기 수강신청기간 마감', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 22, '신·편입생 수강신청기간 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 25, '신·편입생 수강신청마감 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 2, 25, '전기 학위수여식', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 2, '개강', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 3, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 4, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 5, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 6, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 7, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 8, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 3, 29, '1학기 수업일수 1/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 20, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 21, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 22, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 23, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 24, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 25, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 25, '1학기 수업일수 2/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 4, 26, '1학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 5, 23, '1학기 수업일수 3/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 8, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 9, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 10, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 11, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 12, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 13, '1학기 정기휴업일 수업결손 보강기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 14, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 15, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 16, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 17, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 18, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 19, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 20, '1학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 20, '종강', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 20, '1학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 21, '1학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 22, '1학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 23, '1학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 24, '1학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 27, '1학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 28, '1학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 29, '1학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 6, 30, '1학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 1, '휴·복학원 제출 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 5, '2학기 수강신청 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 12, '2학기 수강신청 시작', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 23, '2학기 등록기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 24, '2학기 등록기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 23, '후기 학위수여식', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 25, '2학기 등록기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 8, 26, '2학기 등록기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 1, '개강', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 2, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 3, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 4, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 5, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 6, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 7, '수강신청 변경기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 9, 29, '2학기 수업일수 1/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 20, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 21, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 22, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 23, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 24, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 25, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 26, '2학기 중간고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 10, 28, '2학기 수업일수 2/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 11, 25, '2학기 수업일수 3/4선', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 15, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 16, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 17, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 18, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 19, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 20, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 21, '2학기 기말고사', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 21, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 21, '종강', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 22, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 23, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 24, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 25, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 26, '2학기 성적입력 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 27, '2학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 28, '2학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 29, '2학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n" +
                    "INSERT INTO diarydata (year, month, date, name, kind, string, address, icon) VALUES (2022, 12, 30, '2학기 성적열람 기간', '학사일정', '2022년 공주대학교 학사일정', '공주대학교', 'university.png');\n");
            conn.commit();
        } catch (SQLException e) {
            // 오류출력
            System.out.println(e.getMessage());

                // 트랜잭션 ROLLBACK
            if (conn != null) {
                conn.rollback();
            }
        }
        return inserted;
    }
}
