package project.knucalendar;

import javax.swing.*;
import java.awt.*;

public class infoFrame {
    JFrame infoFrame;

    JPanel infoPanel;

    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));

    public infoFrame(){
        infoFrame = new JFrame();
        infoFrame.setSize(500,400);
        infoFrame.setLayout(new BorderLayout());
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setResizable(false);
        infoFrame.setIconImage(icon.getImage());
        infoFrame.setVisible(true);

        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        JLabel updateTitle = new JLabel("업데이트 예정입니다.");

        infoPanel.add(updateTitle,BorderLayout.CENTER);

        infoFrame.add(infoPanel,BorderLayout.CENTER);
    }
}
