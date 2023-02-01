
import javax.swing.*;

// import oracle.net.ns.Packet;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton login, signup, forget;
    JTextField textuser, textpass;

    login() {
        setSize(600, 300);
        setLocation(300, 400);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 300, 300);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 300, 300);
        p1.add(img);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(300, 0, 300, 300);
        add(p2);

        JLabel lbluser = new JLabel("Username");
        lbluser.setBounds(30, 30, 100, 20);
        p2.add(lbluser);
        lbluser.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));

        textuser = new JTextField();
        textuser.setBounds(30, 55, 250, 20);
        textuser.setBorder(null);
        p2.add(textuser);

        JLabel lblpass = new JLabel("Password");
        lblpass.setBounds(30, 75, 100, 20);
        p2.add(lblpass);
        lblpass.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));

        textpass = new JTextField();
        textpass.setBounds(30, 100, 250, 20);
        textpass.setBorder(null);
        p2.add(textpass);

        login = new JButton("Login");
        login.setBounds(30, 140, 100, 30);
        login.setBorder(null);
        login.setBackground(new Color(131, 193, 233));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("SignUp");
        signup.setBounds(150, 140, 100, 30);
        signup.setBorder(null);
        signup.setBackground(new Color(131, 193, 233));
        signup.addActionListener(this);
        p2.add(signup);

        forget = new JButton("Forget password ?");
        forget.setBounds(90, 190, 120, 30);
        forget.setBorder(null);
        forget.setBackground(new Color(131, 193, 233));
        forget.addActionListener(this);
        p2.add(forget);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String query = "select *from signup where username='" + textuser.getText() + "' and password='"
                        + textpass.getText() + "'";
                sql con = new sql();
                ResultSet rs = con.stmt.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new loading();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!!!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new signup();
        } else {
            setVisible(false);
            new forgetpassword();
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
