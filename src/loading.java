
import java.awt.*;
import javax.swing.*;
// import java.awt.event.*;
// import java.sql.*;

public class loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar Bar;

    public void run() {
        try {

            for (int i = 1; i <= 101; i++) {
                int max = Bar.getMaximum();
                int value = Bar.getValue();
                if (value < max) {
                    Bar.setValue(Bar.getValue() + 1);
                } else {
                    setVisible(false);
                }
                Thread.sleep(60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    loading() {
        t = new Thread(this);
        setBounds(450, 300, 600, 400);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel tourism = new JLabel("Travel and Toursim Application");
        tourism.setForeground(new Color(72, 209, 204));
        tourism.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        tourism.setBounds(50, 46, 700, 35);
        add(tourism);

        Bar = new JProgressBar();
        Bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        Bar.setStringPainted(true);
        Bar.setBounds(130, 135, 300, 25);
        add(Bar);

        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        add(panel);

        t.start();
        setVisible(true);

    }

    public static void main(String[] args) {
        new loading();
    }
}