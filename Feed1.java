import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

class Feed1 implements ActionListener {
    JFrame f;
    JLabel ll, l1, l3, l4;
    JButton b1, b2, b3;
    JTextField t1, t2;

    Feed1() {
        f = new JFrame("Feedback");
        l1 = new JLabel("Feedback");
        l4 = new JLabel("Username");
        ll = new JLabel(new ImageIcon("screen.jpvg"));
        l3 = new JLabel("thanking you for using this website");
        t2 = new JTextField(30);
        t1 = new JTextField(10);
        b1 = new JButton("send");
        b2 = new JButton("exit");
        f.setVisible(true);
        f.setSize(1600, 900);

        f.add(ll);
        ll.add(l4);
        ll.add(t1);
        ll.add(l1);
        ll.add(t2);
        ll.add(b1);
        ll.add(b2);
        ll.add(l3);
        l4.setBounds(30, 70, 250, 50);
        t1.setBounds(330, 70, 250, 50);
        l1.setBounds(30, 150, 250, 50);
        t2.setBounds(330, 150, 250, 50);
        b1.setBounds(30, 350, 250, 50);
        b2.setBounds(330, 350, 250, 50);
        l3.setBounds(230, 450, 250, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            try {
                String username = (String) t1.getText();
                String feedback = (String) t2.getText();

                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                PreparedStatement ps = c.prepareStatement("insert into Feed values(?,?)");
                ps.setString(1, username);
                ps.setString(2, feedback);
                int rs = ps.executeUpdate();
                if (rs == 1) {
                    JOptionPane.showMessageDialog(null, "feedback successfully done");
                } else {
                    JOptionPane.showMessageDialog(null, "missing data");
                }
                ps.close();
                c.close();
            } catch (Exception e) {
            }
        } else {
            f.setVisible(false);
        }
    }

    public static void main(String... aa) {
        new Feed1();
    }
}
