package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.sql.SQLException;

public class subMenu implements ActionListener {

    resetProgram rs = new resetProgram();
    backupData bd = new backupData();
    JFrame subMenu, checkReset;
    JPanel centrePanel_sub,top_gap;
    JButton dataManage, univNotice, univLunch, resetProgram, progInfo, okReset;
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    ImageIcon notice = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/notice.png")));
    ImageIcon lunch = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/lunch.png")));
    ImageIcon manage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/manage.png")));
    ImageIcon reset = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/reset.png")));
    ImageIcon info = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/info.png")));
    public subMenu(){
        subMenu = new JFrame();
        subMenu.setSize(900,600);
        subMenu.setLayout(new BorderLayout());
        subMenu.setLocationRelativeTo(null);
        subMenu.setResizable(false);
        subMenu.setIconImage(icon.getImage());
        subMenu.setVisible(true);

        centrePanel_sub = new JPanel();
        centrePanel_sub.setLayout(new FlowLayout());
        centrePanel_sub.setBackground(Color.WHITE);

        univNotice = new JButton(notice);
        univNotice.addActionListener(this);
        univNotice.setPreferredSize(new Dimension(notice.getIconWidth(),notice.getIconHeight()));

        univLunch = new JButton(lunch);
        univLunch.addActionListener(this);
        univLunch.setPreferredSize(new Dimension(lunch.getIconWidth(),lunch.getIconHeight()));

        dataManage = new JButton(manage);
        dataManage.addActionListener(this);
        dataManage.setPreferredSize(new Dimension(manage.getIconWidth(),manage.getIconHeight()));

        resetProgram = new JButton(reset);
        resetProgram.addActionListener(this);
        resetProgram.setPreferredSize(new Dimension(reset.getIconWidth(),reset.getIconHeight()));

        progInfo = new JButton(info);
        progInfo.addActionListener(this);
        progInfo.setPreferredSize(new Dimension(info.getIconWidth(),info.getIconHeight()));

        centrePanel_sub.add(univNotice);
        centrePanel_sub.add(univLunch);
        centrePanel_sub.add(dataManage);
        centrePanel_sub.add(resetProgram);
        centrePanel_sub.add(progInfo);

        top_gap = new JPanel();
        top_gap.setLayout(new BorderLayout());
        top_gap.setBackground(Color.WHITE);
        JLabel title = new JLabel("SubMenu");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("??????????????????",Font.BOLD,20));
        top_gap.add(title,BorderLayout.CENTER);
        top_gap.setPreferredSize(new Dimension(900,106));

        subMenu.add(top_gap,BorderLayout.NORTH);
        subMenu.add(centrePanel_sub,BorderLayout.CENTER);
    }

    public void run(){
        new subMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dataManage) {
            try {
                new dataManage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == univNotice) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://www.kongju.ac.kr/kongju/12499/subview.do");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == univLunch) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://www.kongju.ac.kr/kongju/13156/subview.do");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == resetProgram) {
            frameCheck();
        } else if (e.getSource() == progInfo) {
            try {
                new infoFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == okReset){
            try {
                rs.dropTable();
                rs.createTable();
                bd.insert();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            checkReset.dispose();
        }
    }

    public void frameCheck(){
        checkReset = new JFrame();
        checkReset.setSize(500,160);
        checkReset.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkReset.setLocationRelativeTo(null);
        checkReset.setIconImage(icon.getImage());
        checkReset.setVisible(true);

        JPanel showData = new JPanel();
        showData.setSize(500,160);
        showData.setLayout(new GridLayout(3,1));
        JLabel checkingMessage1 = new JLabel("???????????? ?????? ???????????? ????????? ??? ????????????.");
        checkingMessage1.setFont(new Font("??????????????????",Font.BOLD,16));
        checkingMessage1.setHorizontalAlignment(JLabel.CENTER);
        JLabel checkingMessage2 = new JLabel("????????????????????????????");
        checkingMessage2.setFont(new Font("??????????????????",Font.BOLD,16));
        checkingMessage2.setForeground(new Color(5,62,143));
        checkingMessage2.setHorizontalAlignment(JLabel.CENTER);

        showData.add(checkingMessage1);
        showData.add(checkingMessage2);

        okReset = new JButton("?????????");
        okReset.setFont(new Font("??????????????????",Font.BOLD,16));
        okReset.setPreferredSize(new Dimension(300,30));
        okReset.setBackground(new Color(5,62,143));
        okReset.setBorderPainted(false);
        okReset.setOpaque(true);
        okReset.setForeground(Color.WHITE);
        okReset.addActionListener(this);

        showData.add(okReset);

        checkReset.add(showData);
    }
}
