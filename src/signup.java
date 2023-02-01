
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Choice;

public class signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField name, pass, usertext, ans;
    Choice secure;

    signup() {
        setBounds(350, 400, 600, 300);
        getContentPane().setBackground(new Color(131, 193, 233));
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 600, 300);
        p1.setBackground(new Color(131, 193, 233));
        add(p1);

        JLabel setuser = new JLabel("Username");
        setuser.setBounds(30, 30, 100, 20);
        setuser.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p1.add(setuser);

        usertext = new JTextField();
        usertext.setBounds(130, 30, 200, 20);
        usertext.setBorder(null);
        p1.add(usertext);
        // name field

        JLabel setname = new JLabel("Name");
        setname.setBounds(30, 70, 100, 20);
        setname.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p1.add(setname);

        name = new JTextField();
        name.setBounds(130, 70, 200, 20);
        name.setBorder(null);
        p1.add(name);

        // set password

        JLabel setpass = new JLabel("Password");
        setpass.setBounds(30, 110, 100, 20);
        setpass.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p1.add(setpass);

        pass = new JTextField();
        pass.setBounds(130, 110, 200, 20);
        pass.setBorder(null);
        p1.add(pass);

        JLabel security = new JLabel("Security Q");
        security.setBounds(30, 150, 100, 20);
        security.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p1.add(security);

        Choice secure = new Choice();
        secure.add("your fav pet.");
        secure.add("favorite food.");
        secure.add("fav bike or car.");
        secure.add("fav marvel hero.");
        secure.setBounds(130, 150, 200, 30);
        p1.add(secure);

        // answer field
        JLabel setans = new JLabel("Answer");
        setans.setBounds(30, 190, 100, 20);
        setans.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        p1.add(setans);

        ans = new JTextField();
        ans.setBounds(130, 190, 200, 20);
        ans.setBorder(null);
        p1.add(ans);

        create = new JButton("Create");
        create.setBounds(30, 230, 100, 20);
        create.setBorder(null);
        create.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        create.setBackground(Color.GRAY);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(200, 230, 100, 20);
        back.setBorder(null);
        back.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(300, 10, 300, 300);
        p1.add(img);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = usertext.getText();
            String name1 = name.getText();
            String password = pass.getText();
            String choice = secure.getSelectedItem();
            String answer = ans.getText();

            String query = "insert into signup values('" + username + "','" + name1 + "','" + password + "','" + choice
                    + "','" + answer + "')";

            sql conn = new sql();
            try {
                conn.stmt.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "successfully created account");
            setVisible(false);
            new login();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}
