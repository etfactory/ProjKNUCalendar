package project.knucalendar;

import javax.swing.*;
import java.awt.*;

public class addData {
    JFrame addData;
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));
    public addData() {
        addData = new JFrame();
        addData.setSize(900,600);
        addData.setLayout(new FlowLayout());
        addData.setLocationRelativeTo(null);
        addData.setResizable(false);
        addData.setIconImage(icon.getImage());
        addData.setVisible(true);
    }
}
