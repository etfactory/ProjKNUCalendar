package project.knucalendar;

import javax.swing.*;
import java.awt.*;

public class makingCalendar {
    mainPanel mainPanel;
    JPanel calendarPanel = new JPanel();
    JButton weekDaysName[] = new JButton[7];
    String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
    JPanel dateButton[][] = new JPanel[6][7];
    public makingCalendar(){
        calendarPanel.setLayout(new GridLayout(0,7,2,2));
        for(int i=0;i<7;i++){
            weekDaysName[i] =new JButton(WEEK_DAY_NAME[i]);
            weekDaysName[i].setBorderPainted(false);
            weekDaysName[i].setContentAreaFilled(false);
            weekDaysName[i].setForeground(Color.WHITE);
            if(i==0)
                weekDaysName[i].setBackground(new Color(200,50,50));
            else if (i==6)
                weekDaysName[i].setBackground(new Color(50,100,200));
            else
                weekDaysName[i].setBackground(new Color(150,150,150));
            weekDaysName[i].setOpaque(true);
            weekDaysName[i].setFocusPainted(false);
            calendarPanel.add(weekDaysName[i]);
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                dateButton[i][j]=new JPanel();
                dateButton[i][j].setLayout(new BorderLayout());
                dateButton[i][j].setBackground(Color.WHITE);
                dateButton[i][j].setOpaque(true);
                calendarPanel.add(dateButton[i][j]);
            }
        }
    }
}
