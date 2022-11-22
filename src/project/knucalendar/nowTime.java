package project.knucalendar;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class nowTime extends JFrame {
    public nowTime() {
        super("시계 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("나눔고딕", Font.BOLD,80));
        c.add(timerLabel);

        Timer th = new Timer(timerLabel);

        setSize(500,300);
        setVisible(true);

        th.start();
    }
}
class Timer extends Thread {
    private final JLabel label;

    public Timer(JLabel label) {
        this.label=label;
    }

    public void run() {
        while(true) {
            try {
                Calendar c = Calendar.getInstance();

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                int second = c.get(Calendar.SECOND);

                String clock = Integer.toString(hour);
                clock = clock.concat(":");
                clock = clock.concat(Integer.toString(min));
                clock = clock.concat(":");
                clock = clock.concat(Integer.toString(second));
                label.setText(clock);
            }
            catch(Exception e) {return;}
        }
    }
}