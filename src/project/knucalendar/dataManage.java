package project.knucalendar;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class dataManage extends SQLiteManager implements MouseListener, ActionListener{
    JFrame manageFrame, updateData;
    JTable jTable;
    JScrollPane jScrollPane;
    DefaultTableModel model;
    Vector v;
    Vector cols;

    JPanel bottomPanel;
    JButton deleteButton;

    int getRow, getCol;

    public dataManage() {
        manageFrame = new JFrame();
        manageFrame.setSize(800,600);
        manageFrame.setLocationRelativeTo(null);
        manageFrame.setLayout(new BorderLayout());

        v = getMemberList();
        cols = getColumn();

        model = new DefaultTableModel(v,cols);

        jTable = new JTable(model);
        jScrollPane = new JScrollPane(jTable);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        deleteButton = new JButton("삭제");
        deleteButton.addActionListener(this);
        deleteButton.setFont(new Font("나눔바른고딕",Font.PLAIN,14));
        deleteButton.setBackground(new Color(5,62,143));
        deleteButton.setBorderPainted(false);
        deleteButton.setOpaque(true);
        deleteButton.setForeground(Color.WHITE);

        bottomPanel.add(deleteButton);

        manageFrame.add(jScrollPane,BorderLayout.CENTER);
        manageFrame.add(bottomPanel,BorderLayout.SOUTH);
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

    public void delete(DefaultTableModel data){
        Connection conn = ensureConnection();
        PreparedStatement pstmt = null; //명령
        final String sql = "DELETE FROM diarydata"+"\n"
                + " WHERE year= ?                "+"\n"
                + " AND month = ?                "+"\n"
                + " AND date  = ?                "+"\n"
                + " AND name  = ?                "+"\n";

        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, data.getValueAt(getRow,0));
            pstmt.setObject(2, data.getValueAt(getRow,1));
            pstmt.setObject(3, data.getValueAt(getRow,2));
            pstmt.setObject(4, data.getValueAt(getRow,3));

            pstmt.executeUpdate();

            conn.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void jTableRefresh(){
        DefaultTableModel model = new DefaultTableModel(getMemberList(), getColumn());
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        getRow = jTable.getSelectedRow();
        getCol = jTable.getSelectedColumn();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deleteButton) {
            int row = jTable.getSelectedRow();
            delete(model);
            jTableRefresh();
        }
    }
}
