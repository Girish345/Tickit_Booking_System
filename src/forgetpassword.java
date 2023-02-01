import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class forgetpassword extends JFrame implements ActionListener {

    JTextField username, Name, question, answer, password;
    JButton b1, b2, back;

    forgetpassword() {
        setBounds(350, 400, 800, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(35, 25, 400, 300);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(410, 5, 400, 380);
        add(j1);

        JLabel user = new JLabel("username");
        user.setBounds(30, 30, 100, 20);
        user.setLayout(null);
        user.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(user);

        username = new JTextField();
        username.setBounds(120, 30, 100, 20);
        // username.setLayout(null);
        username.setBorder(null);
        p1.add(username);

        b1 = new JButton("search");
        b1.setBounds(250, 30, 100, 20);
        b1.setBorder(null);
        b1.addActionListener(this);
        p1.add(b1);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 70, 100, 20);
        name.setLayout(null);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(name);

        Name = new JTextField();
        Name.setBounds(120, 70, 100, 20);
        // username.setLayout(null);
        Name.setBorder(null);
        p1.add(Name);

        // security question
        JLabel security = new JLabel("security question");
        security.setBounds(30, 110, 200, 20);
        security.setLayout(null);
        security.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(security);

        question = new JTextField();
        question.setBounds(170, 110, 130, 20);
        // username.setLayout(null);
        question.setBorder(null);
        p1.add(question);

        // answer of security question

        JLabel ans = new JLabel("Answer");
        ans.setBounds(30, 150, 200, 20);
        ans.setLayout(null);
        ans.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(ans);

        answer = new JTextField();
        answer.setBounds(120, 150, 130, 20);
        // username.setLayout(null);
        answer.setBorder(null);
        p1.add(answer);

        b2 = new JButton("Retrive");
        b2.setBounds(270, 150, 100, 20);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        p1.add(b2);

        // password field

        JLabel pass = new JLabel("Password");
        pass.setBounds(30, 190, 200, 20);
        pass.setLayout(null);
        pass.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(pass);

        password = new JTextField();
        password.setBounds(120, 190, 130, 20);
        password.setBorder(BorderFactory.createEmptyBorder());
        // username.setLayout(null);
        password.setBorder(null);
        p1.add(password);

        // back button
        back = new JButton("back");
        back.setBounds(150, 250, 100, 20);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                String query = "select *from signup where username='" + username.getText() + "'";
                sql conn = new sql();

                ResultSet rs = conn.stmt.executeQuery(query);
                while (rs.next()) {
                    Name.setText(rs.getString("name"));
                    question.setText(rs.getString("question"));
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            try {
                String query = "select *from signup where username='" + username.getText() + "' and answer='"
                        + answer.getText() + "'";
                sql conn = new sql();

                ResultSet result = conn.stmt.executeQuery(query);
                while (result.next()) {
                    password.setText(result.getString("password"));
                }
            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else {
            setVisible(false);
            new login();
        }
    }

    public static void main(String[] args) {
        new forgetpassword();
    }

}
