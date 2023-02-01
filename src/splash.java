import javax.swing.*;
import java.awt.*;

public class splash extends JFrame implements Runnable {
    Thread thread;

    splash() {
        setSize(1200, 600);
        setLocation(200, 400);
        ImageIcon icon = new ImageIcon(
                ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = icon.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        splash frame = new splash();
        int x = 1;
        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i) / 2, 400 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // new login();
        }
    }
}
