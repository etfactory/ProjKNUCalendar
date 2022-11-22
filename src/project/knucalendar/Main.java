package project.knucalendar;

import javax.swing.*;

public class Main extends JFrame{
    mainPanel mainPanel;
    connectDB connectDB;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    public Main(){
        new mainPanel(); new connectDB();
    }
}