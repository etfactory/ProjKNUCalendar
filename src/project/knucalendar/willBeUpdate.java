package project.knucalendar;

import javax.swing.*;
import java.awt.*;

public class willBeUpdate {
    JFrame willBeUpdate;

    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));

    public willBeUpdate(){
        willBeUpdate = new JFrame();
        willBeUpdate.setSize(400,150);
        willBeUpdate.setLayout(new BorderLayout());
        willBeUpdate.setLocationRelativeTo(null);
        willBeUpdate.setResizable(false);
        willBeUpdate.setIconImage(icon.getImage());
        willBeUpdate.setVisible(true);
    }
}
