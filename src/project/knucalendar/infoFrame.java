package project.knucalendar;

import javax.swing.*;
import java.awt.*;

public class infoFrame {
    JFrame infoFrame;
    JPanel infoPanel;

    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion1_1.png")));

    public infoFrame(){
        infoFrame = new JFrame();
        infoFrame.setSize(600,300);
        infoFrame.setLayout(new BorderLayout());
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setResizable(false);
        infoFrame.setIconImage(icon.getImage());
        infoFrame.setVisible(true);

        infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new GridLayout(8,1,10,10));

        JLabel versionTitle = new JLabel("VERSION");
        versionTitle.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel addressTitle = new JLabel("UNIVERSITY");
        addressTitle.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel firstdeveloperName = new JLabel("DEVELOPER NAME");
        firstdeveloperName.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel firstdeveloperGIT = new JLabel("DEVELOPER GIT");
        firstdeveloperGIT.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel secdeveloperName = new JLabel("DEVELOPER NAME");
        secdeveloperName.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel secdeveloperGIT = new JLabel("DEVELOPER GIT");
        secdeveloperGIT.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        JLabel blank = new JLabel(" ");
        blank.setFont(new Font("나눔바른고딕",Font.BOLD,16));

        leftPanel.add(versionTitle);
        leftPanel.add(addressTitle);
        leftPanel.add(firstdeveloperName);
        leftPanel.add(firstdeveloperGIT);
        leftPanel.add(secdeveloperName);
        leftPanel.add(secdeveloperGIT);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new GridLayout(8,1,10,10));

        JLabel version = new JLabel("0.0.1");
        version.setFont(new Font("나눔바른고딕",Font.PLAIN,16));
        JLabel address = new JLabel("Kongju National University");
        address.setFont(new Font("나눔바른고딕",Font.PLAIN,16));
        JLabel firstDeveloperName = new JLabel("Euntaek Oh");
        firstDeveloperName.setFont(new Font("나눔바른고딕",Font.PLAIN,16));
        JLabel firstDeveloperGit = new JLabel("@etfactory");
        firstDeveloperGit.setFont(new Font("나눔바른고딕",Font.PLAIN,16));
        JLabel secondDeveloperName = new JLabel("Jeong-woo Choi");
        secondDeveloperName.setFont(new Font("나눔바른고딕",Font.PLAIN,16));
        JLabel secondDeveloperGit = new JLabel("@ygftcu");
        secondDeveloperGit.setFont(new Font("나눔바른고딕",Font.PLAIN,16));

        rightPanel.add(version);
        rightPanel.add(address);
        rightPanel.add(firstDeveloperName);
        rightPanel.add(firstDeveloperGit);
        rightPanel.add(secondDeveloperName);
        rightPanel.add(secondDeveloperGit);

        infoPanel.add(leftPanel);
        infoPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel();
        JLabel bottomText = new JLabel("KNU Calendar Program");
        bottomText.setFont(new Font("나눔바른고딕",Font.BOLD,16));
        bottomPanel.add(bottomText);

        infoFrame.add(infoPanel,BorderLayout.CENTER);
        infoFrame.add(bottomPanel,BorderLayout.SOUTH);
    }
}
