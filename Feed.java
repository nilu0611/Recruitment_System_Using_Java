import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

class Feed implements ActionListener {
    JFrame f;
    JLabel ll, l1, l3, l4;
    Button b1, b2, b3;
    JTextField t1;
    JTextArea a1;

    Feed() {
        f = new JFrame("feedback");
        l1 = new JLabel("feedback");
        l4 = new JLabel("user name");
        ll = new JLabel(new ImageIcon("screen.jpvg"));
        l3 = new JLabel("thanking you for using this website");
        a1 = new JTextArea();
        t1 = new JTextField(10);
        b1 = new Button("send");
        b2 = new Button("exit");
        f.setVisible(true);
        f.setSize(1600, 900);

        f.add(ll);
        ll.add(l4);
        ll.add(t1);
        ll.add(l1);
        ll.add(a1);
        ll.add(b1);
        ll.add(b2);
        ll.add(l3);
        l4.setBounds(30, 70, 250, 50);
        t1.setBounds(330, 70, 250, 50);
        l1.setBounds(30, 150, 250, 50);
        a1.setBounds(330, 150, 250, 50);
        b1.setBounds(30, 350, 250, 50);
        b2.setBounds(330, 350, 250, 50);
        l3.setBounds(230, 450, 250, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            try {
                String s1 = t1.getText();
                String s2 = a1.getText();
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                PreparedStatement ps = c.prepareStatement("insert into Feed values(?,?)");
                ps.setString(1, s1);
                ps.setString(2, s2);

                int m = ps.executeUpdate();
                if (m == 1)
                    JOptionPane.showMessageDialog(null, "Feedback is successfully sent");
                ps.close();
                c.close();
            } catch (Exception ee) {
            }
        } else {
            f.setVisible(false);
        }
    }

    public static void main(String... aa) {
        new Feed();
    }
}
