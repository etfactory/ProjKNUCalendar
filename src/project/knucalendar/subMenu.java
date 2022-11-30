package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class subMenu implements ActionListener {
    JFrame subMenu;
    JPanel centrePanel_sub,top_gap;
    JButton darkOnOff, univNotice, univLunch, resetProgram, progInfo;
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    ImageIcon bg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/subMenuNormal.png")));
    ImageIcon bt = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/submenu/testButton.png")));
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
        centrePanel_sub.setPreferredSize(new Dimension(1280,bt.getIconHeight()));

        darkOnOff = new JButton(bt);
        darkOnOff.addActionListener(this);
        darkOnOff.setPreferredSize(new Dimension(bt.getIconWidth(),bt.getIconHeight()));

        univNotice = new JButton(bt);
        univNotice.addActionListener(this);
        univNotice.setPreferredSize(new Dimension(bt.getIconWidth(),bt.getIconHeight()));

        univLunch = new JButton(bt);
        univLunch.addActionListener(this);
        univLunch.setPreferredSize(new Dimension(bt.getIconWidth(),bt.getIconHeight()));

        resetProgram = new JButton(bt);
        resetProgram.addActionListener(this);
        resetProgram.setPreferredSize(new Dimension(bt.getIconWidth(),bt.getIconHeight()));

        progInfo = new JButton(bt);
        progInfo.addActionListener(this);
        progInfo.setPreferredSize(new Dimension(bt.getIconWidth(),bt.getIconHeight()));

        centrePanel_sub.add(darkOnOff);
        centrePanel_sub.add(univNotice);
        centrePanel_sub.add(univLunch);
        centrePanel_sub.add(resetProgram);
        centrePanel_sub.add(progInfo);

        top_gap = new JPanel();
        top_gap.setBackground(Color.WHITE);
        JLabel title = new JLabel("SubMenu");
        top_gap.add(title);
        top_gap.setPreferredSize(new Dimension(900,106));

        subMenu.add(top_gap,BorderLayout.NORTH);
        subMenu.add(centrePanel_sub,BorderLayout.CENTER);
    }

    public void run(){
        new subMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == darkOnOff) {
            try {
                new willBeUpdate();
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
            try {
                new resetProgram();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == progInfo) {
            try {
                new infoFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
