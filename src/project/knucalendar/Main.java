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
        SQLiteManager manager = new SQLiteManager();

        manager.createConnection();     // 연결
        manager.closeConnection();      // 연결 해제
        manager.ensureConnection();     // 재연결
        new mainPanel();
    }
}