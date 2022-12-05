package project.knucalendar;

import javax.swing.*;
import java.util.*;

public class Timer extends Thread{
    private JLabel label;

    public Timer(JLabel label) {
        this.label=label;
    }

    public void run() {
        while(true) {
            try {
                Calendar c = Calendar.getInstance();

                int amPM = c.get(Calendar.AM_PM);
                int hour = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);
                String ampm = amPM==Calendar.AM?"오전":"오후";

                String clock = ampm;
                clock = clock.concat(" ");
                clock = clock.concat(Integer.toString(hour));
                clock = clock.concat(":");
                clock = clock.concat(Integer.toString(min));
                label.setText(clock);
            }
            catch(Exception e) {return;}
        }
    }
}
