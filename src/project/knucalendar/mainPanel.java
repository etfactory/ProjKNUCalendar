package project.knucalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class mainPanel extends JFrame implements ActionListener {
    final String title = "KNU Calendar Program";
    JFrame mainFrame;
    JPanel centrePanel, topPanel, bottomPanel, calendarPanel, diaryPanel, rightPanel, leftPanel, top_leftPanel, top_rightPanel;
    JButton linkedKNU, linkedLMS, linkedSugang, menuButton, todayButton;
    JButton weekDaysName[] = new JButton[7];
    String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
    JPanel dateButton[][] = new JPanel[6][7];
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    ImageIcon normalBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/centre.png")));
    ImageIcon bottomNormal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/bottom.png")));
    ImageIcon KNUPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/KNUPage.png")));
    ImageIcon LMSPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/LMSPage.png")));
    ImageIcon SugangPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/수강신청.png")));
    ImageIcon menuPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/menuButton.png")));
    ImageIcon todayPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/homeButton.png")));
    subMenu subMenu = new subMenu();

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
        top_leftPanel.add(menuButton);
        todayButton = new JButton(todayPage);
        todayButton.setFocusPainted(false);
        todayButton.setBorderPainted(false);
        todayButton.setContentAreaFilled(false);
        top_leftPanel.add(todayButton);

        topPanel.add(top_leftPanel,BorderLayout.WEST);
        /*
        메뉴, 리셋, 시계 순
        메뉴, 리셋 - 왼쪽
        시계 - 오른쪽
         */

        centrePanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(normalBackground.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        centrePanel.setSize(1280,508);

        /*
        여기에 일정, 달력 순 생성
         */

        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0,7,2,2));
        calendarPanel.setPreferredSize(new Dimension(600,380));
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
        calendarPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
        centrePanel.setLayout(new FlowLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        leftPanel.setPreferredSize(new Dimension(420,500));
        JLabel text = new JLabel("일정 표시할 자리");
        leftPanel.add(text);

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
                subMenu.run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
