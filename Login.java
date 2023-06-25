import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class Login implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3, b4, b5;

    Login() {
        l4 = new JLabel("Welcome");
        ImageIcon img = new ImageIcon("studentlogin.png");
        l5 = new JLabel(img);
        f = new JFrame("StudentLogin");

        l1 = new JLabel("E-Mail");
        l2 = new JLabel("password");
        l3 = new JLabel("Not a member?");
        t1 = new JTextField(10);
        t2 = new JPasswordField(10);
        b1 = new JButton("Register now");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2 = new JButton("Login");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3 = new JButton("Reset");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b4 = new JButton("Home page");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b5 = new JButton("Forgetten Password");
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        f.setVisible(true);
        f.setSize(1600, 900);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1.setBounds(530, 525, 100, 20);
        t1.setBounds(620, 525, 100, 20);
        l4.setBounds(580, 430, 800, 90);
        l2.setBounds(530, 550, 100, 20);
        t2.setBounds(620, 550, 100, 20);

        b2.setBounds(550, 590, 100, 20);
        b3.setBounds(675, 590, 100, 20);
        l3.setBounds(500, 650, 90, 20);
        l5.setBounds(85, 30, 1100, 450);
        b1.setBounds(600, 650, 150, 20);
        b4.setBounds(1200, 30, 150, 30);
        b5.setBounds(600, 620, 150, 20);
        l4.setFont(new Font("Arial", Font.BOLD, 40));

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(b2);
        f.add(b1);
        f.add(b3);
        f.add(b4);
        f.add(l4);
        f.add(b5);
        f.add(l5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b4)) {
            f.setVisible(false);
            new Homepage();
        }
        if (ae.getSource().equals(b3)) {
            t1.setText("");
            t2.setText("");
        }

        if (ae.getSource().equals(b1)) {
            f.setVisible(false);
            new ComboBoxExample();
        }
        if (ae.getSource().equals(b2)) {
            try {
                String email = (String) t1.getText();
                String password = (String) t2.getText();
                String qs = "select * from Stdregister where email=? and password=?";
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                PreparedStatement ps = c.prepareStatement(qs);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Welcome");
                    t1.setText("");
                    t2.setText("");
                    ps.close();
                    c.close();
                    f.setVisible(false);
                    new StdMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "user_name or password invalid");
                    t2.setText("");
                }
            } catch (Exception ee) {
            }
        }
    }

    public static void main(String... aa) {
        new Login();
    }
}
