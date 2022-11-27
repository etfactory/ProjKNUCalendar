package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class subMenu implements ActionListener {
    JFrame subMenu;
    JPanel centrePanel_sub;
    JButton darkOnOff, univNotice, univLunch, resetProgram, progInfo;
    public subMenu(){
        subMenu = new JFrame();
        subMenu.setSize(900,600);
        subMenu.setLayout(new BorderLayout());
        centrePanel_sub = new JPanel();
        subMenu.setLayout(new GridLayout(0,5,10,0));

        darkOnOff = new JButton();
        darkOnOff.addActionListener(this);

        univNotice = new JButton();
        univNotice.addActionListener(this);

        univLunch = new JButton();
        univLunch.addActionListener(this);

        resetProgram = new JButton();
        resetProgram.addActionListener(this);

        progInfo = new JButton();
        progInfo.addActionListener(this);

        centrePanel_sub.add(darkOnOff);
        centrePanel_sub.add(univNotice);
        centrePanel_sub.add(univLunch);
        centrePanel_sub.add(resetProgram);
        centrePanel_sub.add(progInfo);

        subMenu.add(centrePanel_sub);
    }

    public void run(){
        new subMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == darkOnOff) {
            try {

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == univNotice) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://knulms.kongju.ac.kr/");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == univLunch) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    URI uri = new URI("https://sugang.kongju.ac.kr/");
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == resetProgram) {
            try {

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == progInfo) {
            try {

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
