package project.knucalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainPanel extends calendarDataManager  implements ActionListener {
    final String title = "KNU Calendar Program";
    JFrame mainFrame;
    JPanel centrePanel, topPanel, bottomPanel, calendarPanel, showDiary, rightPanel, leftPanel, top_leftPanel, top_rightPanel;
    JButton linkedKNU, linkedLMS, linkedSugang, menuButton, todayButton;
    JScrollPane diaryPanel;
    JButton weekDaysName[] = new JButton[7];
    String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
    JPanel dateButton[][] = new JPanel[6][7];
    JLabel dateButs[][] = new JLabel[6][7];
    listenForDateButs lForDateButs = new listenForDateButs();
    ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    ImageIcon normalBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/centre.png")));
    ImageIcon bottomNormal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/bottom.png")));
    ImageIcon KNUPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/KNUPage.png")));
    ImageIcon LMSPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/LMSPage.png")));
    ImageIcon SugangPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/수강신청.png")));
    ImageIcon menuPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/menuButton.png")));
    ImageIcon todayPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/homeButton.png")));

    public mainPanel(){
        mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280,720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setVisible(true);

        mainFrame.setLayout(new BorderLayout(0,0));

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1280,76));
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BorderLayout());

        top_leftPanel = new JPanel();
        top_leftPanel.setLayout(new FlowLayout());
        top_leftPanel.setBackground(Color.WHITE);

        menuButton = new JButton(menuPage);
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setContentAreaFilled(false);
        menuButton.addActionListener(this);
        menuButton.setPreferredSize(new Dimension(menuPage.getIconWidth(),menuPage.getIconHeight()));
        top_leftPanel.add(menuButton);
        todayButton = new JButton(todayPage);
        todayButton.setFocusPainted(false);
        todayButton.setBorderPainted(false);
        todayButton.setContentAreaFilled(false);
        todayButton.setPreferredSize(new Dimension(todayPage.getIconWidth(),todayPage.getIconHeight()));
        todayButton.addActionListener(lForCalOpButtons);
        top_leftPanel.add(todayButton);
        /*
        시계 - 오른쪽
        시계 작업 안함
         */
        topPanel.add(top_leftPanel,BorderLayout.WEST);
        /*
        여기에 일정, 달력 순 생성
         */

        centrePanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(normalBackground.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        centrePanel.setSize(1280,508);

        calendarPanel = new JPanel();
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setLayout(new GridLayout(0,7,5,5));
        calendarPanel.setPreferredSize(new Dimension(600,420));
        for(int i=0;i<7;i++){
            weekDaysName[i] =new JButton(WEEK_DAY_NAME[i]);
            weekDaysName[i].setBorderPainted(false);
            weekDaysName[i].setContentAreaFilled(false);
            weekDaysName[i].setForeground(Color.GRAY);
            weekDaysName[i].setBackground(new Color(225,225,225));
            weekDaysName[i].setOpaque(true);
            weekDaysName[i].setFocusPainted(false);
            calendarPanel.add(weekDaysName[i]);
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                dateButton[i][j]=new JPanel();

                dateButs[i][j] = new JLabel();

                if (calDates[i][j]==0)
                    dateButs[i][j].setText("");
                else
                    dateButs[i][j].setText(""+calDates[i][j]+"");

                dateButton[i][j].setLayout(new BorderLayout());
                dateButton[i][j].setBackground(new Color(250,250,250));
                dateButton[i][j].setOpaque(true);

                dateButton[i][j].add(dateButs[i][j],BorderLayout.EAST);
                calendarPanel.add(dateButton[i][j]);
            }
        }
        calendarPanel.setBorder(new LineBorder(Color.WHITE, 2, true));
        centrePanel.setLayout(new FlowLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(420,500));
        leftPanel.setBackground(Color.WHITE);

        showDiary = new JPanel();
        diaryPanel = new JScrollPane(showDiary);
        diaryPanel.setPreferredSize(new Dimension(400,420));

        leftPanel.add(diaryPanel,BorderLayout.PAGE_END);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(620,500));
        rightPanel.add(calendarPanel,BorderLayout.PAGE_END);

        centrePanel.add(leftPanel);
        centrePanel.add(rightPanel);

        bottomPanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(bottomNormal.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        linkedKNU = new JButton(KNUPage);
        linkedKNU.setFocusPainted(false);
        linkedKNU.setBorderPainted(false);
        linkedKNU.setContentAreaFilled(false);
        linkedKNU.addActionListener(this);
        linkedLMS = new JButton(LMSPage);
        linkedLMS.setFocusPainted(false);
        linkedLMS.setBorderPainted(false);
        linkedLMS.setContentAreaFilled(false);
        linkedLMS.addActionListener(this);
        linkedSugang = new JButton(SugangPage);
        linkedSugang.setFocusPainted(false);
        linkedSugang.setBorderPainted(false);
        linkedSugang.setContentAreaFilled(false);
        linkedSugang.addActionListener(this);
        bottomPanel.add(linkedKNU);
        bottomPanel.add(linkedLMS);
        bottomPanel.add(linkedSugang);

        mainFrame.add(topPanel,BorderLayout.PAGE_START);
        mainFrame.add(bottomPanel,BorderLayout.PAGE_END);
        mainFrame.add(centrePanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == linkedKNU) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://kongju.ac.kr/");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == linkedLMS) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://knulms.kongju.ac.kr/");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == linkedSugang) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://sugang.kongju.ac.kr/");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == menuButton) {
            try {
                new subMenu();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void focusToday(){
        if(today.get(Calendar.DAY_OF_WEEK) == 1)
            dateButton[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
        else
            dateButton[today.get(Calendar.WEEK_OF_MONTH)-1][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
    }
    private class ListenForCalOpButtons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == todayButton){
                setToday();
                lForDateButs.actionPerformed(e);
                focusToday();
            }
            /*
            else if(e.getSource() == lYearBut) moveMonth(-12);
            else if(e.getSource() == lMonBut) moveMonth(-1);
            else if(e.getSource() == nMonBut) moveMonth(1);
            else if(e.getSource() == nYearBut) moveMonth(12);
             */
        }
    }
    private class listenForDateButs implements ActionListener{
        public void actionPerformed(ActionEvent e) {

        }
    }
}
