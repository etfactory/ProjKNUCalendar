import java.awt.*;
import javax.swing.*;

public class mainUI extends JFrame{
    JFrame mainFrame;
    JPanel topPanel, centrePanel, bottomPanel;
    final String title = "mainUI Test";


    //배경화면 소스
    ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon/bear/bearVersion2_1.png")));
    ImageIcon normalBackground = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/centre.png")));
    ImageIcon bottomNormal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/background (1280x720)/bottom.png")));

    //하단 버튼 소스
    ImageIcon KNUPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/KNUPage.png")));
    ImageIcon LMSPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/LMSPage.png")));
    ImageIcon SugangPage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/gui/button/수강신청.png")));
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainUI();
            }
        });
    }
    public mainUI(){
        mainFrame = new JFrame(title);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280,720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setVisible(true);

        mainFrame.setLayout(new BorderLayout(0,0));

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1280,76));
        topPanel.setBackground(Color.WHITE);

        /*
        메뉴, 리셋, 시계 순
        메뉴, 리셋 - 왼쪽
        시계 - 오른쪽
         */

        bottomPanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(bottomNormal.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        JButton linkedKNU = new JButton(KNUPage);
        linkedKNU.setFocusPainted(false);
        linkedKNU.setBorderPainted(false);
        linkedKNU.setContentAreaFilled(false);
        JButton linkedLMS = new JButton(LMSPage);
        linkedLMS.setFocusPainted(false);
        linkedLMS.setBorderPainted(false);
        linkedLMS.setContentAreaFilled(false);
        JButton linkedSugang = new JButton(SugangPage);
        linkedSugang.setFocusPainted(false);
        linkedSugang.setBorderPainted(false);
        linkedSugang.setContentAreaFilled(false);
        bottomPanel.add(linkedKNU);
        bottomPanel.add(linkedLMS);
        bottomPanel.add(linkedSugang);
        /*
        마우스 클릭 시 하이퍼 링크 아직 안함
         */

        centrePanel = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(normalBackground.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        centrePanel.setSize(1280,508);

        /*
        여기에 일정, 달력 순 생성
         */

        centrePanel.setLayout(new FlowLayout());

        mainFrame.add(topPanel,BorderLayout.PAGE_START);
        mainFrame.add(bottomPanel,BorderLayout.PAGE_END);
        mainFrame.add(centrePanel,BorderLayout.CENTER);
    }

}
