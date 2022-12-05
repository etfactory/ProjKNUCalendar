package project.knucalendar;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class dataManage{
    JFrame manageFrame, updateData;
    JTable jTable;
    JScrollPane jScrollPane;
    DefaultTableModel model;
    Vector v;
    Vector cols;

    JMenu m = new JMenu("관리");
    JMenuItem update = new JMenuItem("수정");
    JMenuItem delete = new JMenuItem("삭제");
    JMenuBar mb = new JMenuBar();

    JPanel bottomPanel;

    String[] arr = {"학사일정","시험","과제","개인일정","공휴일"};

    JComboBox comboBox;
    JTextField searchField;
    JButton searchButton;

    public dataManage() {
        manageFrame = new JFrame();
        manageFrame.setSize(800,600);
        manageFrame.setLocationRelativeTo(null);
        manageFrame.setLayout(new BorderLayout());

        m.add(update);
        m.add(delete);
        mb.add(m);

        v = getMemberList();
        cols = getColumn();

        model = new DefaultTableModel(v,cols);

        jTable = new JTable(model);
        jScrollPane = new JScrollPane(jTable);

        bottomPanel = new JPanel();
        comboBox = new JComboBox(arr);
        comboBox.setFont(new Font("나눔바른고딕",Font.PLAIN,12));
        searchField = new JTextField(30);
        searchField.setFont(new Font("나눔바른고딕",Font.PLAIN,14));
        searchButton = new JButton("검색");
        searchButton.setFont(new Font("나눔바른고딕",Font.PLAIN,12));

        bottomPanel.add(comboBox);
        bottomPanel.add(searchField);
        bottomPanel.add(searchButton);

        manageFrame.setJMenuBar(mb);
        manageFrame.add(bottomPanel,BorderLayout.SOUTH);
        manageFrame.add(jScrollPane,BorderLayout.CENTER);
        manageFrame.setVisible(true);
    }
    public Vector getMemberList(){

        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가


        Connection conn = null;      //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String sql = "select * from diarydata order by name asc";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                int date = rs.getInt("date");
                String name = rs.getString("name");
                String kind = rs.getString("kind");
                String string = rs.getString("string");
                String address = rs.getString("address");
                String icon = rs.getString("icon");

                Vector row = new Vector();
                row.add(year);
                row.add(month);
                row.add(date);
                row.add(name);
                row.add(kind);
                row.add(string);
                row.add(address);
                row.add(icon);

                data.add(row);
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()
    public Vector getColumn(){
        Vector col = new Vector();
        col.add("년도");
        col.add("월");
        col.add("일");
        col.add("일정명");
        col.add("분류");
        col.add("설명");
        col.add("장소");
        col.add("아이콘");

        return col;
    }
    public void jTableRefresh(){
        DefaultTableModel model = new DefaultTableModel(getMemberList(), getColumn());
    }
}
