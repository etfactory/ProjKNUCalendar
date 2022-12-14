package project.knucalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.*;
import java.util.List;

public class mainPanel extends calendarDataManager implements ActionListener {
    final String title = "KNU Calendar Program";
    JFrame mainFrame;
    JPanel centrePanel, topPanel, bottomPanel,
            calendarPanel, showDiary,
            rightPanel, leftPanel,
            top_leftPanel, top_rightPanel, calendarTopPanel;
    JButton linkedKNU, linkedLMS, linkedSugang, menuButton, todayButton,
            lYearBut, rYearBut, lMonthBut, rMonthBut, openAddData;
    JScrollPane diaryPanel;
    JButton weekDaysName[] = new JButton[7];
    JLabel showMonth, showYear, selectedDate;
    JLabel setTitle[] = new JLabel[15];
    String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
    int getYearinListener, getMonthinListener, getDayofMonthinListener;
    JButton dateButton[][] = new JButton[6][7];
    JButton iconButton[] = new JButton[15];
    JButton stringButton[] = new JButton[15];
    JPanel iconPanel[] = new JPanel[15];

    int count;

    int selectedMonth, selectedDay;

    private DQLService DQL = new DQLService("jdbc:sqlite:database.db");

    int countButtons;
    int showDiaryheight;
    JLabel dateButs[][] = new JLabel[6][7];
    listenForDateButs lForDateButs = new listenForDateButs();
    ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    ImageIcon normalBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/centre.png")));
    ImageIcon bottomNormal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/bottom.png")));
    ImageIcon top = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/top.png")));
    ImageIcon KNUPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/KNUPage.png")));
    ImageIcon LMSPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/LMSPage.png")));
    ImageIcon SugangPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/????????????.png")));
    ImageIcon menuPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/menuButton.png")));
    ImageIcon todayPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/homeButton.png")));
    ImageIcon monthLeft = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/monthleft.png")));
    ImageIcon monthRight = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/monthright.png")));
    ImageIcon yearLeft = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/yearleft.png")));
    ImageIcon yearRight = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/yearright.png")));
    ImageIcon addButton = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/add.png")));


    ImageIcon univIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/diaryIcon/univ_fix.png")));
    ImageIcon testIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/diaryIcon/test_fix.png")));
    ImageIcon homeworkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/diaryIcon/homework_fix.png")));
    ImageIcon userIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/diaryIcon/user_fix.png")));

    addData addData;

    public mainPanel(){
        SQLiteManager manager = new SQLiteManager();

        manager.createConnection();     // ??????
        manager.closeConnection();      // ?????? ??????
        manager.ensureConnection();     // ?????????

        mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280,720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setVisible(true);

        mainFrame.setLayout(new BorderLayout(0,0));

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1280,top.getIconHeight()-24));
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
        ?????? - ?????????
        ?????? ?????? ??????
         */
        top_rightPanel = new JPanel();
        top_rightPanel.setBackground(Color.WHITE);
        top_rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("??????????????????",Font.BOLD,30));
        timerLabel.setHorizontalAlignment(JLabel.RIGHT);
        top_rightPanel.add(timerLabel);

        Timer th = new Timer(timerLabel);

        th.start();

        topPanel.add(top_leftPanel,BorderLayout.WEST);
        topPanel.add(top_rightPanel,BorderLayout.EAST);

        centrePanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(normalBackground.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        centrePanel.setPreferredSize(new Dimension(normalBackground.getIconWidth(),normalBackground.getIconHeight()));
        centrePanel.setLayout(new FlowLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(420,500));
        leftPanel.setBackground(Color.WHITE);

        selectedDate = new JLabel(calYear+"??? "+(calMonth+1)+"??? "+calDayOfMon+"??? (??????)");
        selectedDate.setFont(new Font("??????????????????",Font.BOLD,20));
        selectedDate.setHorizontalAlignment(JLabel.CENTER);

        openAddData = new JButton(addButton);
        openAddData.setFocusPainted(false);
        openAddData.setBorderPainted(false);
        openAddData.setContentAreaFilled(false);
        openAddData.addActionListener(this);

        leftPanel.add(openAddData,BorderLayout.EAST);
        leftPanel.add(selectedDate,BorderLayout.CENTER);

        showDiaryheight = 1000;
        showDiary = new JPanel();
        showDiary.setPreferredSize(new Dimension(400,showDiaryheight));
        diaryPanel = new JScrollPane(showDiary);
        diaryPanel.setPreferredSize(new Dimension(400,420));
        for(int i=0;i<15;i++){
            iconButton[i] = new JButton();
            iconButton[i].setPreferredSize(new Dimension(70,70));
            iconButton[i].setBackground(new Color(214,233,255));
            iconButton[i].setVisible(false);

            setTitle[i] = new JLabel();
            setTitle[i].setFont(new Font("??????????????????",Font.BOLD,20));

            stringButton[i] = new JButton();
            stringButton[i].add(setTitle[i]);
            stringButton[i].setPreferredSize(new Dimension(330,70));
            stringButton[i].setBackground(new Color(214,233,255));
            stringButton[i].setVisible(false);

            iconPanel[i] = new JPanel();
            iconPanel[i].setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

            iconPanel[i].add(iconButton[i]);
            iconPanel[i].add(stringButton[i]);

            showDiary.add(iconPanel[i]);
        }
        leftPanel.add(diaryPanel,BorderLayout.PAGE_END);

        calendarTopPanel = new JPanel();
        calendarTopPanel.setBackground(Color.WHITE);
        calendarTopPanel.setLayout(new BorderLayout());

        JPanel leftButtons = new JPanel();
        leftButtons.setBackground(Color.WHITE);
        leftButtons.setLayout(new FlowLayout());

        JPanel rightButtons = new JPanel();
        rightButtons.setBackground(Color.WHITE);
        rightButtons.setLayout(new FlowLayout());

        JPanel showMonthNYear = new JPanel();
        showMonthNYear.setBackground(Color.WHITE);
        showMonthNYear.setLayout(new BorderLayout());
        showYear = new JLabel();
        showYear.setFont(new Font("??????????????????",Font.BOLD,15));
        showYear.setText(""+calYear+"");
        showYear.setHorizontalAlignment(JLabel.CENTER);
        showMonth = new JLabel();
        showMonth.setFont(new Font("??????????????????",Font.BOLD,30));
        showMonth.setText(""+(calMonth+1)+"");
        showMonth.setHorizontalAlignment(JLabel.CENTER);
        showMonthNYear.add(showYear,BorderLayout.PAGE_START);
        showMonthNYear.add(showMonth,BorderLayout.CENTER);

        lYearBut = new JButton(yearLeft);
        lYearBut.setPreferredSize(new Dimension(yearLeft.getIconWidth(),yearLeft.getIconHeight()));
        lYearBut.setFocusPainted(false);
        lYearBut.setBorderPainted(false);
        lYearBut.setContentAreaFilled(false);
        lYearBut.addActionListener(lForCalOpButtons);

        lMonthBut = new JButton(monthLeft);
        lMonthBut.setPreferredSize(new Dimension(monthLeft.getIconWidth(),monthLeft.getIconHeight()));
        lMonthBut.setFocusPainted(false);
        lMonthBut.setBorderPainted(false);
        lMonthBut.setContentAreaFilled(false);
        lMonthBut.addActionListener(lForCalOpButtons);

        rYearBut = new JButton(yearRight);
        rYearBut.setPreferredSize(new Dimension(yearRight.getIconWidth(),yearRight.getIconHeight()));
        rYearBut.setFocusPainted(false);
        rYearBut.setBorderPainted(false);
        rYearBut.setContentAreaFilled(false);
        rYearBut.addActionListener(lForCalOpButtons);

        rMonthBut = new JButton(monthRight);
        rMonthBut.setPreferredSize(new Dimension(monthRight.getIconWidth(),monthRight.getIconHeight()));
        rMonthBut.setFocusPainted(false);
        rMonthBut.setBorderPainted(false);
        rMonthBut.setContentAreaFilled(false);
        rMonthBut.addActionListener(lForCalOpButtons);

        leftButtons.add(lYearBut);
        leftButtons.add(lMonthBut);

        rightButtons.add(rMonthBut);
        rightButtons.add(rYearBut);

        calendarTopPanel.add(showMonthNYear,BorderLayout.CENTER);
        calendarTopPanel.add(leftButtons,BorderLayout.WEST);
        calendarTopPanel.add(rightButtons,BorderLayout.EAST);

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
            weekDaysName[i].setFont(new Font("??????????????????",Font.BOLD,15));
            calendarPanel.add(weekDaysName[i]);
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                dateButton[i][j]=new JButton();

                dateButs[i][j] = new JLabel();
                dateButs[i][j].setHorizontalAlignment(JLabel.CENTER);
                dateButs[i][j].setFont(new Font("??????????????????",Font.BOLD,15));

                dateButton[i][j].setLayout(new BorderLayout());
                dateButton[i][j].setBackground(new Color(250,250,250));
                dateButton[i][j].setBorderPainted(false);
                dateButton[i][j].setOpaque(true);
            }
        }
        setSelectedDay(calMonth+1, calDayOfMon);
        getDateinListener(calYear, calMonth+1, calDayOfMon);
        showCal();
        selectDate();
        findKindList();
        calendarPanel.setBorder(new LineBorder(Color.WHITE, 2, true));

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(620,500));
        rightPanel.add(calendarTopPanel,BorderLayout.PAGE_START);
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
        linkedKNU.setPreferredSize(new Dimension(KNUPage.getIconWidth(), KNUPage.getIconHeight()));
        linkedLMS = new JButton(LMSPage);
        linkedLMS.setFocusPainted(false);
        linkedLMS.setBorderPainted(false);
        linkedLMS.setContentAreaFilled(false);
        linkedLMS.addActionListener(this);
        linkedLMS.setPreferredSize(new Dimension(LMSPage.getIconWidth(), LMSPage.getIconHeight()));
        linkedSugang = new JButton(SugangPage);
        linkedSugang.setFocusPainted(false);
        linkedSugang.setBorderPainted(false);
        linkedSugang.setContentAreaFilled(false);
        linkedSugang.addActionListener(this);
        linkedSugang.setPreferredSize(new Dimension(SugangPage.getIconWidth(), SugangPage.getIconHeight()));
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
        } else if (e.getSource() == openAddData) {
            try {
                new addData(selectedMonth, selectedDay);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void showCal(){
        for(int i=0;i<6;i++) {
            for (int j = 0; j < 7; j++) {
                if (calDates[i][j] == 0)
                    dateButs[i][j].setText("");
                else
                    dateButs[i][j].setText("" + calDates[i][j] + "");

                if (calMonth == today.get(Calendar.MONTH) &&
                        calYear == today.get(Calendar.YEAR) &&
                        calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
                    dateButton[i][j].setBackground(new Color(5, 62, 143));
                    dateButs[i][j].setText("<html><font color=white>" + calDates[i][j] + "</font></html>");
                    dateButton[i][j].setToolTipText("????????? ??????");
                }
                dateButton[i][j].addActionListener(lForDateButs);
                dateButton[i][j].add(dateButs[i][j], BorderLayout.CENTER);
                calendarPanel.add(dateButton[i][j]);
            }
        }
    }
    private void delCal(){
        for(int i=0;i<6;i++) {
            for (int j = 0; j < 7; j++) {
                calDates[i][j]=0;
                dateButs[i][j].setText("");
                dateButton[i][j].setBackground(new Color(250,250,250));
            }
        }
    }
    private class ListenForCalOpButtons implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == todayButton){
                delCal();
                setToday();
                lForDateButs.actionPerformed(e);
                focusToday();
                showYear.setText(""+calYear+"");
                showMonth.setText(""+(calMonth+1)+"");
            } else if(e.getSource() == lYearBut){
                delCal();
                moveMonth(-12);
                showYear.setText(""+calYear+"");
                showMonth.setText(""+(calMonth+1)+"");
            } else if(e.getSource() == lMonthBut){
                delCal();
                moveMonth(-1);
                showYear.setText(""+calYear+"");
                showMonth.setText(""+(calMonth+1)+"");
            } else if(e.getSource() == rMonthBut){
                delCal();
                moveMonth(1);
                showYear.setText(""+calYear+"");
                showMonth.setText(""+(calMonth+1)+"");
            } else if(e.getSource() == rYearBut){
                delCal();
                moveMonth(12);
                showYear.setText(""+calYear+"");
                showMonth.setText(""+(calMonth+1)+"");
            }
            showCal();
        }
    }
    private void focusToday(){
        if(today.get(Calendar.DAY_OF_WEEK) == 1)
            dateButton[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
        else
            dateButton[today.get(Calendar.WEEK_OF_MONTH)-1][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
    }
    private class listenForDateButs implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<15;i++){
                iconButton[i].setVisible(false);
                stringButton[i].setVisible(false);
                setTitle[i].setText("");
            }
            int k=0, l=0, newCalDayOfMon=0;
            for(int i=0;i<6;i++){
                for(int j=0;j<7;j++){
                    if(e.getSource()==dateButton[i][j]){
                        k=i; l=j;
                    }
                }
            }

            if(!(k==0&&l==0))
                newCalDayOfMon = calDates[k][l];

            if(!(newCalDayOfMon==0)) {
                calendar = new GregorianCalendar(calYear, calMonth, newCalDayOfMon);

                String dDayString = new String();

                int dDay=((int)((calendar.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
                if(dDay == 0 && (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR))
                        && (calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                        && (calendar.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)))
                    dDayString = "??????";
                else if(dDay >=0)
                    dDayString = "D-"+(dDay+1);
                else if(dDay < 0)
                    dDayString = "D+"+(dDay)*(-1);

                selectedDate.setText(calYear + "??? " + (calMonth + 1) + "??? " + newCalDayOfMon + "??? (" + dDayString + ")");
                calDayOfMon = newCalDayOfMon;

                getDateinListener(calYear, calMonth+1, newCalDayOfMon);

                setSelectedDay(calMonth+1, newCalDayOfMon);
                selectDate();
                findKindList();
            }
        }
    }
    public void setSelectedDay(int selectedM,int selected) {
        selectedMonth = selectedM;
        selectedDay = selected;
    }

    public void selectDate(){
        final Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);

        List<Map<String, Object>> result = DQL.selectList(dataMap);

        countButtons = DQL.toInt(result);

        for(int i=0;i<countButtons;i++){
            iconButton[i].setVisible(true);
            stringButton[i].setVisible(true);
        }

        System.out.println(getYearinListener+" "+getMonthinListener+" "+getDayofMonthinListener+" "+countButtons);
        DQL.printMapList(result);
    }
    public void findKindList(){
        final Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);
        dataMap.put("kind" , "?????????");

        List<Map<String, Object>> resultHoliday = DQL.findKind(dataMap);

        int countHoliday = DQL.toInt(resultHoliday);

        int count=0;

        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);
        dataMap.put("kind" , "????????????");

        List<Map<String, Object>> resultUniv = DQL.findKind(dataMap);

        int countUniv = DQL.toInt(resultUniv);

        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);
        dataMap.put("kind" , "??????");

        List<Map<String, Object>> resultTest = DQL.findKind(dataMap);

        int countTest = DQL.toInt(resultTest);

        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);
        dataMap.put("kind" , "??????");

        List<Map<String, Object>> resultHomework = DQL.findKind(dataMap);

        int countHomework = DQL.toInt(resultHomework);

        dataMap.put("year" , getYearinListener);
        dataMap.put("month", getMonthinListener);
        dataMap.put("date" , getDayofMonthinListener);
        dataMap.put("kind" , "????????????");

        List<Map<String, Object>> resultUser = DQL.findKind(dataMap);

        int countUser = DQL.toInt(resultUser);

        ArrayList<String> saveString = new ArrayList<>();
        ArrayList<String> saveFile = new ArrayList<>();

        for(int i=0;i<countHoliday;i++){
            saveString.add(DQL.getHolidayNames[i]);
            saveFile.add("holiday");
        }
        for(int i=0;i<countUniv;i++){
            saveString.add(DQL.getUnivNames[i]);
            saveFile.add("univ");
        }
        for(int i=0;i<countTest;i++){
            saveString.add(DQL.getTestNames[i]);
            saveFile.add("test");
        }
        for(int i=0;i<countHomework;i++){
            saveString.add(DQL.getHomeworkNames[i]);
            saveFile.add("homework");
        }
        for(int i=0;i<countUser;i++){
            saveString.add(DQL.getUserNames[i]);
            saveFile.add("user");
        }

        for(int i=0;i<saveString.size();i++){
            setTitle[i].setText(saveString.get(i));
            if(saveFile.get(i).equals("holiday"))
                iconButton[i].setIcon(userIcon);
            else if(saveFile.get(i).equals("univ"))
                iconButton[i].setIcon(univIcon);
            else if(saveFile.get(i).equals("test"))
                iconButton[i].setIcon(testIcon);
            else if(saveFile.get(i).equals("homework"))
                iconButton[i].setIcon(homeworkIcon);
            else if(saveFile.get(i).equals("user"))
                iconButton[i].setIcon(userIcon);
        }

        saveString.clear();
        saveFile.clear();

        setCount(count);
    }

    public void setCount(int c){
        count = c;
    }
    public void getDateinListener(int y, int m, int d){
        getYearinListener = y;
        getMonthinListener = m;
        getDayofMonthinListener = d;
    }
}
