import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stdregister implements ActionListener {
      JFrame f;
      JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
      JTextField t1, t2, t3, t4, t5, t6, t7, t8, t10, t11, t12, t13, t14, t15;
      JButton b1, b2, b3, b4;

      Stdregister() {
            f = new JFrame("Student Register");
            l17 = new JLabel("New Student Please Register");
            ImageIcon img = new ImageIcon("studentregistration.png");
            l18 = new JLabel(img);
            l1 = new JLabel("Name");
            l2 = new JLabel("User name");
            l3 = new JLabel("Contact no");
            l4 = new JLabel("City");
            l5 = new JLabel("Address");
            l6 = new JLabel("date_of_birth");
            l7 = new JLabel("age");
            l8 = new JLabel("School");
            l9 = new JLabel("gender");
            l10 = new JLabel("Friend Name");
            l11 = new JLabel("Aggregate");
            l12 = new JLabel("Department");
            l13 = new JLabel("Extra curriculars");
            l14 = new JLabel("E-Mail");
            l15 = new JLabel("password");
            l16 = new JLabel("Country");
            t1 = new JTextField(10);
            t2 = new JTextField(10);
            t3 = new JTextField(10);
            t4 = new JTextField(10);
            t5 = new JTextField(10);
            t6 = new JTextField(10);
            t7 = new JTextField(10);
            t8 = new JTextField(10);
            t10 = new JTextField(10);
            t11 = new JTextField(10);
            t12 = new JTextField(10);
            t13 = new JTextField(10);
            t14 = new JTextField(10);
            t15 = new JTextField(10);
            b1 = new JButton("Register");
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b2 = new JButton("Reset");
            b2.setBackground(Color.black);
            b2.setForeground(Color.white);
            b3 = new JButton("Cancel");
            b3.setBackground(Color.black);
            b3.setForeground(Color.white);
            b4 = new JButton("Homepage");
            b4.setBackground(Color.white);
            b4.setForeground(Color.black);
            String country[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };
            JComboBox cb = new JComboBox(country);
            String gender[] = { "male", "female", "others" };
            JComboBox y = new JComboBox(gender);
            f.setVisible(true);
            f.setSize(1600, 900);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            l1.setBounds(850, 75, 100, 20);
            t1.setBounds(975, 75, 200, 20);

            l17.setBounds(430, 0, 900, 80);
            l17.setFont(new Font("Arial", Font.BOLD, 40));
            l2.setBounds(850, 105, 100, 20);
            t2.setBounds(975, 105, 200, 20);

            l3.setBounds(850, 135, 100, 20);
            t3.setBounds(975, 135, 200, 20);

            l4.setBounds(850, 165, 100, 20);
            t4.setBounds(975, 165, 200, 20);

            l5.setBounds(850, 195, 100, 20);
            t5.setBounds(975, 195, 200, 20);

            l6.setBounds(850, 225, 100, 20);
            t6.setBounds(975, 225, 200, 20);

            l7.setBounds(850, 255, 100, 20);
            t7.setBounds(975, 255, 200, 20);
            l8.setBounds(850, 285, 100, 20);
            t8.setBounds(975, 285, 200, 20);

            l9.setBounds(850, 315, 100, 20);
            y.setBounds(975, 315, 200, 20);

            l10.setBounds(850, 345, 100, 20);
            t10.setBounds(975, 345, 200, 20);

            l11.setBounds(850, 375, 100, 20);
            t11.setBounds(975, 375, 200, 20);

            l12.setBounds(850, 405, 100, 20);
            t12.setBounds(975, 405, 200, 20);

            l13.setBounds(850, 435, 100, 20);
            t13.setBounds(975, 435, 200, 20);

            l14.setBounds(850, 465, 100, 20);
            t14.setBounds(975, 465, 200, 20);
            l15.setBounds(850, 495, 100, 20);
            t15.setBounds(975, 495, 200, 20);

            l16.setBounds(850, 525, 100, 20);
            l18.setBounds(10, 10, 1000, 600);

            b1.setBounds(1100, 600, 100, 30);
            b2.setBounds(950, 600, 100, 30);
            b3.setBounds(1030, 650, 100, 30);

            b4.setBounds(1030, 700, 100, 30);
            cb.setBounds(975, 525, 200, 20);
            f.add(l17);
            f.add(l1);
            f.add(t1);
            f.add(l2);
            f.add(t2);
            f.add(l3);
            f.add(t3);
            f.add(l4);
            f.add(t4);
            f.add(l5);
            f.add(t5);
            f.add(l6);
            f.add(t6);
            f.add(l7);
            f.add(t7);
            f.add(l8);
            f.add(t8);
            f.add(l9);
            f.add(y);
            f.add(l10);
            f.add(t10);
            f.add(l11);
            f.add(t11);
            f.add(l12);
            f.add(t12);
            f.add(l13);
            f.add(t13);
            f.add(l14);
            f.add(t14);
            f.add(l15);
            f.add(t15);
            f.add(l16);
            f.add(cb);
            f.add(b1);
            f.add(b2);
            f.add(b3);
            f.add(b4);
            f.add(l18);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);

      }

      public void actionPerformed(ActionEvent ae) {

            if (ae.getSource().equals(b1)) {
                  if (t1.getText().isEmpty() || (t2.getText().isEmpty()) || (t3.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Data missing");
                  } else {

                        try {
                              String name = (String) t1.getText();
                              String age = (String) t7.getText();
                              String address = (String) t5.getText();
                              String email = (String) t14.getText();
                              String contact = (String) t3.getText();
                              String password = (String) t15.getText();
                              String fname = (String) t10.getText();

                              DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                              Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                          "system", "password");
                              PreparedStatement ps = c
                                          .prepareStatement("insert into Stdregister values(?,?,?,?,?,?,?)");
                              ps.setString(1, name);
                              ps.setString(2, age);
                              ps.setString(3, email);
                              ps.setString(4, contact);
                              ps.setString(5, address);
                              ps.setString(6, password);
                              ps.setString(7, fname);
                              int rs = ps.executeUpdate();
                              if (rs == 1) {
                                    JOptionPane.showMessageDialog(null, "Register successfully done");
                              }
                              ps.close();
                              c.close();
                              f.setVisible(false);
                              new Login();

                        } catch (Exception e) {
                              f.setVisible(true);
                        }
                  }
            }

            if (ae.getSource().equals(b2)) {
                  t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");
                  t5.setText("");
                  t6.setText("");
                  t7.setText("");
                  t8.setText("");
                  t10.setText("");
                  t11.setText("");
                  t12.setText("");
                  t13.setText("");
                  t14.setText("");
                  t15.setText("");
            }
            if (ae.getSource().equals(b4)) {
                  f.setVisible(false);
                  new Homepage();
            }

            if (ae.getSource().equals(b3)) {
                  f.setVisible(false);
                  new ComboBoxExample();
            } else {
                  f.setVisible(false);
            }
      }

      public static void main(String... aaa) {
            new Stdregister();
      }
}
