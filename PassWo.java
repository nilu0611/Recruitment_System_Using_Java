import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

class PassWo implements ActionListener {
    Frame f, f2;
    JLabel l1, l2, l3, ll, l4;
    JTextField t1, t2;
    Button b1, b2;
    JPasswordField p1, p2;

    PassWo() {
        f = new Frame("Change password");
        l3 = new JLabel("Enter E-mail");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        l1 = new JLabel("Reset password");
        l4 = new JLabel("Q)What is your friend_name");
        ll = new JLabel(new ImageIcon("screen.jphg"));
        l2 = new JLabel("Confirm password");
        b1 = new Button("Submit");
        b2 = new Button("Cancel");
        p1 = new JPasswordField(10);
        p2 = new JPasswordField(10);
        f.setVisible(true);
        f.add(ll);
        f.setSize(1600, 900);
        ll.add(l3);
        ll.add(t1);
        ll.add(l4);
        ll.add(t2);
        ll.add(l1);
        ll.add(p1);
        ll.add(l2);
        ll.add(p2);
        ll.add(b1);
        ll.add(b2);

        l3.setBounds(30, 70, 250, 56);
        t1.setBounds(350, 70, 250, 56);
        l4.setBounds(30, 150, 250, 56);
        t2.setBounds(350, 150, 250, 56);
        l1.setBounds(30, 230, 250, 56);
        p1.setBounds(350, 230, 250, 56);

        l2.setBounds(30, 300, 250, 56);
        p2.setBounds(350, 300, 250, 56);
        b1.setBounds(30, 370, 250, 56);
        b2.setBounds(350, 370, 250, 56);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            try {
                String s1 = p1.getText();
                String s2 = p2.getText();
                String an = t2.getText();
                // System.out.println(s1+" "+s2);
                String s3 = t1.getText();
                if (s1.equals(s2)) {
                    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "password");
                    Statement s = c.createStatement();
                    ResultSet rs = s.executeQuery("select email,fname from companyregister");
                    while (rs.next()) {
                        String s4 = rs.getString(2);
                        String s5 = rs.getString(4);
                        // System.out.println(s4+" "+s5);
                        // System.out.println("yes");
                        if (s4.equals(s3)) {// System.out.println("yes");
                            if (s5.equals(an)) {// System.out.println("yes");
                                PreparedStatement ps = c
                                        .prepareStatement("update companyregister set password=? where email=?");

                                ps.setString(2, s1);
                                ps.setString(4, s4);
                                int m = ps.executeUpdate();
                                if (m == 1) {
                                    JOptionPane.showMessageDialog(null, "your password is successfully reset");
                                    new Login();
                                }

                            }
                        }
                    }
                }
                if (ae.getSource().equals(b1)) {
                    f.setVisible(false);
                    new CLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid data");
                }
            } catch (Exception eee) {
            }
        }
    }

    public static void main(String... aa) {
        new PassWo();
    }
}
