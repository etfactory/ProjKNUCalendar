package project.knucalendar;

import java.sql.SQLException;

import javax.swing.*;

public class Main extends JFrame{
    mainPanel mainPanel;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    public Main(){
        new mainPanel();
    }
}