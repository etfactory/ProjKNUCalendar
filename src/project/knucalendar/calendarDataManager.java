package project.knucalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class calendarDataManager {
    static final int CAL_WIDTH = 7;
    static final int CAL_HEIGHT = 6;
    int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
    int calYear;
    int calMonth;
    int calDayOfMon;
    final int calLastDateOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int calLastDate;
    Calendar today = Calendar.getInstance();
    Calendar calendar;

    public calendarDataManager(){
        setToday();
    }

    public void setToday(){
        calYear = today.get(Calendar.YEAR);
        calMonth = today.get(Calendar.MONTH);
        calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
        makeCalendarData(today);
    }

    private void makeCalendarData(Calendar calendar){
        int calStartingPos = (calendar.get(Calendar.DAY_OF_WEEK)+7-(calendar.get(Calendar.DAY_OF_MONTH))%7)%7;
        if(calMonth==1)
            calLastDate = calLastDateOfMonth[calMonth]+leapCheck(calYear);
        else
            calLastDate = calLastDateOfMonth[calMonth];

        for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
            if(i == 0) k = calStartingPos;
            else k = 0;
            for(int j = k ; j<CAL_WIDTH ; j++){
                if(num <= calLastDate) calDates[i][j]=num++;
            }
        }
    }

    private int leapCheck(int year){
        if(year%4 == 0 && year%100 != 0 || year%400 == 0)
            return 1;
        else
            return 0;
    }

    public void moveMonth(int month){
        calMonth += month;
        if(calMonth>11)
            while(calMonth>11){
                calYear++;
                calMonth -= 12;
            }
        else if (calMonth<0)
            while(calMonth<0){
                calYear--;
                calMonth+=12;
            }
        calendar = new GregorianCalendar(calYear,calMonth,calDayOfMon);
        makeCalendarData(calendar);
    }
}
