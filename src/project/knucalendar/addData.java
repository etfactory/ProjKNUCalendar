package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addData extends calendarDataManager implements ActionListener {
    JFrame addData, errorMessage, checkSave;
    JPanel textPanel, areaPanel, buttonPanel, diaryTA, dataPanel, underDataPanel;
    JLabel name, kind, string, diary, where;
    JTextArea nameta, stringta, startta, endta, whereta;
    JComboBox kindbox;
    JLabel errorNotice;
    JButton saveButton, cancelButton, okSign, exit;
    String nameData, kindData, startdateData, enddateData, whereData, stringData, setAddZero;
    int getStartYear,getStartMonth, getStartDateofMonth, getEndYear, getEndMonth, getEndDateofMonth, getStartDate, getEndDate;
    String[] arr = {"학사일정","시험","과제","개인일정"};
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    public addData() {
        checkZero();
        addData = new JFrame();
        addData.setSize(700,400);
        addData.setLocationRelativeTo(null);
        addData.setLayout(new BorderLayout());
        addData.setResizable(false);
        addData.setIconImage(icon.getImage());
        addData.setVisible(true);

        dataPanel = new JPanel();
        dataPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        dataPanel.setPreferredSize(new Dimension(600,300));

        textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(100,300));
        textPanel.setLayout(new FlowLayout());
        name = new JLabel("이름");
        name.setPreferredSize(new Dimension(100,30));
        name.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        kind = new JLabel("분류");
        kind.setPreferredSize(new Dimension(100,30));
        kind.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        diary = new JLabel("날짜");
        diary.setPreferredSize(new Dimension(100,30));
        diary.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        where = new JLabel("장소");
        where.setPreferredSize(new Dimension(100,30));
        where.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        string = new JLabel("설명");
        string.setPreferredSize(new Dimension(100,30));
        string.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        textPanel.add(name);
        textPanel.add(kind);
        textPanel.add(diary);
        textPanel.add(where);
        textPanel.add(string);

        areaPanel = new JPanel();
        areaPanel.setPreferredSize(new Dimension(500,300));
        areaPanel.setLayout(new FlowLayout());

        nameta = new JTextArea();
        nameta.setPreferredSize(new Dimension(500,30));
        nameta.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        kindbox = new JComboBox(arr);
        kindbox.setPreferredSize(new Dimension(500,30));
        kindbox.setFont(new Font("나눔바른고딕",Font.BOLD,17));
        startta = new JTextArea(calYear+""+(calMonth+1)+""+setAddZero);
        startta.setPreferredSize(new Dimension(200,30));
        startta.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        endta = new JTextArea(calYear+""+(calMonth+1)+""+setAddZero);
        endta.setPreferredSize(new Dimension(200,30));
        endta.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        diaryTA = new JPanel();
        diaryTA.setLayout(new BorderLayout());
        diaryTA.add(startta,BorderLayout.WEST);
        diaryTA.add(endta,BorderLayout.EAST);
        JLabel diaryLabel = new JLabel("~");
        diaryLabel.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        diaryLabel.setHorizontalAlignment(JLabel.CENTER);
        diaryTA.add(diaryLabel,BorderLayout.CENTER);
        diaryTA.setPreferredSize(new Dimension());
        diaryTA.setPreferredSize(new Dimension(500,30));
        whereta = new JTextArea();
        whereta.setPreferredSize(new Dimension(500,30));
        whereta.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        stringta = new JTextArea();
        stringta.setPreferredSize(new Dimension(500,150));
        stringta.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        stringta.setLineWrap(true);

        areaPanel.add(nameta);
        areaPanel.add(kindbox);
        areaPanel.add(diaryTA);
        areaPanel.add(whereta);
        areaPanel.add(stringta);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        saveButton = new JButton("저장");
        saveButton.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        saveButton.setPreferredSize(new Dimension(100,40));
        saveButton.addActionListener(this);
        saveButton.setBackground(new Color(5,62,143));
        saveButton.setBorderPainted(false);
        saveButton.setOpaque(true);
        saveButton.setForeground(Color.WHITE);
        cancelButton = new JButton("닫기");
        cancelButton.setFont(new Font("나눔바른고딕",Font.BOLD,20));
        cancelButton.setPreferredSize(new Dimension(100,40));
        cancelButton.addActionListener(this);
        cancelButton.setBackground(new Color(5,62,143));
        cancelButton.setBorderPainted(false);
        cancelButton.setOpaque(true);
        cancelButton.setForeground(Color.WHITE);

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        dataPanel.add(textPanel);
        dataPanel.add(areaPanel);
        dataPanel.add(buttonPanel);

        addData.add(dataPanel,BorderLayout.NORTH);
        addData.add(buttonPanel,BorderLayout.SOUTH);
    }
    private void errorMessage(){
        errorMessage = new JFrame();
        errorMessage.setTitle("문제가 발생하였습니다.");
        errorMessage.setSize(400,120);
        errorMessage.setLayout(new FlowLayout());
        errorMessage.setLocationRelativeTo(null);
        errorMessage.setResizable(false);
        errorMessage.setIconImage(icon.getImage());
        errorMessage.setVisible(true);

        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new GridLayout(2,1));
        errorPanel.setSize(300,150);
        errorNotice = new JLabel("작성한 내용 중에 문제가 있습니다. 내용을 확인해주세요.");
        errorNotice.setFont(new Font("나눔바른고딕",Font.BOLD,14));
        errorNotice.setHorizontalAlignment(JLabel.CENTER);

        exit = new JButton("확인");
        exit.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        exit.setPreferredSize(new Dimension(150,30));
        exit.setBackground(new Color(5,62,143));
        exit.setBorderPainted(false);
        exit.setOpaque(true);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);

        errorPanel.add(errorNotice);
        errorPanel.add(exit);

        errorMessage.add(errorPanel);
    }
    public void getData(){
        nameData = nameta.getText();
        kindData = (String)kindbox.getSelectedItem();
        startdateData = startta.getText();
        enddateData = endta.getText();
        whereData = whereta.getText();
        stringData = stringta.getText();

        getStartDate = Integer.parseInt(startdateData);
        getEndDate = Integer.parseInt(enddateData);

        getStartYear = getStartDate/10000;
        getStartMonth = (getStartDate-(getStartYear*10000))/100;
        getStartDateofMonth = getStartDate-(getStartYear*10000)-(getStartMonth*100);

        getEndYear = getEndDate/10000;
        getEndMonth = (getEndDate-(getEndYear*10000))/100;
        getEndDateofMonth = getEndDate-(getEndYear*10000)-(getEndMonth*100);
    }
    public void checkZero(){
        if(calDayOfMon<10)
            setAddZero = "0"+Integer.toString(calDayOfMon);
    }
    public void checkSave(){
        checkSave = new JFrame();
        checkSave.setSize(500,300);
        checkSave.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkSave.setLocationRelativeTo(null);
        checkSave.setIconImage(icon.getImage());
        checkSave.setVisible(true);

        JPanel showData = new JPanel();
        showData.setSize(500,300);
        showData.setLayout(new GridLayout(8,1));
        JLabel showName = new JLabel("이름 : "+nameData);
        showName.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel showKind = new JLabel("종류 : "+kindData);
        showKind.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel showStartDate = new JLabel("시작날짜 : "+getStartYear+"년 "+getStartMonth+"월 "+getStartDateofMonth+"일");
        showStartDate.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel showEndDate = new JLabel("종료날짜 : "+getEndYear+"년 "+getEndMonth+"월 "+getEndDateofMonth+"일");
        showEndDate.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel showWhere = new JLabel("장소 : "+whereData);
        showWhere.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel showString = new JLabel("설명 : "+stringData);
        showString.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel checkingMessage = new JLabel("저장하시겠습니까?");
        checkingMessage.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        checkingMessage.setForeground(new Color(5,62,143));
        checkingMessage.setHorizontalAlignment(JLabel.CENTER);

        showData.add(showName);
        showData.add(showKind);
        showData.add(showStartDate);
        showData.add(showEndDate);
        showData.add(showWhere);
        showData.add(showString);
        showData.add(checkingMessage);

        okSign = new JButton("저장");
        okSign.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        okSign.setPreferredSize(new Dimension(300,30));
        okSign.setBackground(new Color(5,62,143));
        okSign.setBorderPainted(false);
        okSign.setOpaque(true);
        okSign.setForeground(Color.WHITE);
        okSign.addActionListener(this);

        showData.add(okSign);

        checkSave.add(showData);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            getData();
            checkSave();
        } else if (e.getSource() == cancelButton) {
            addData.dispose();
        } else if (e.getSource() == okSign) {
            checkSave.dispose();
            if(nameData.equals(""))
                errorMessage();
            else if((getStartDate/10000000)==0)
                errorMessage();
            else if((getEndDate/10000000)==0)
                errorMessage();
            else
                addData.dispose();
        } else if (e.getSource() == exit){
            errorMessage.dispose();
        }
    }
}
