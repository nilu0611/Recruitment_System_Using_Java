import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CompanyRegister implements ActionListener {
      JFrame f;
      JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
      TextField t1, t2, t3, t4, t5, t6, t7;
      JButton b1, b2, b3, b4;

      CompanyRegister() {
            f = new JFrame("Company Register");
            l8 = new JLabel("New Company Please Register");
            ImageIcon img = new ImageIcon("companyregister.png");
            l9 = new JLabel(img);
            l1 = new JLabel("Company name");
            l2 = new JLabel("E-mail");
            l3 = new JLabel("Contact");
            l4 = new JLabel("HR Name");
            l5 = new JLabel("friend name");
            l6 = new JLabel("luckyno");
            l7 = new JLabel("password");
            t1 = new TextField();
            t2 = new TextField();
            t3 = new TextField();
            t4 = new TextField();
            t5 = new TextField();
            t6 = new TextField();
            t7 = new TextField();
            b1 = new JButton("Register");
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b2 = new JButton("Cancel");
            b2.setBackground(Color.black);
            b2.setForeground(Color.white);
            b3 = new JButton("Home page");
            b3.setBackground(Color.white);
            b3.setForeground(Color.black);
            b4 = new JButton("Reset");
            b4.setBackground(Color.black);
            b4.setForeground(Color.white);
            f.setVisible(true);
            f.setSize(1600, 900);
            f.setLayout(null);
            l1.setBounds(30, 75, 100, 20);
            t1.setBounds(150, 75, 185, 20);

            l2.setBounds(30, 105, 100, 20);
            t2.setBounds(150, 105, 185, 20);

            l3.setBounds(30, 135, 100, 20);
            t3.setBounds(150, 135, 185, 20);

            l4.setBounds(30, 165, 100, 20);
            t4.setBounds(150, 165, 185, 20);

            l5.setBounds(30, 195, 100, 20);
            t5.setBounds(150, 195, 185, 20);

            l6.setBounds(30, 225, 100, 20);
            t6.setBounds(150, 225, 185, 20);

            l7.setBounds(30, 255, 100, 20);
            t7.setBounds(150, 255, 185, 20);

            b1.setBounds(50, 400, 100, 40);
            b2.setBounds(190, 400, 100, 40);
            b3.setBounds(90, 540, 150, 30);
            b4.setBounds(90, 495, 150, 30);

            l8.setFont(new Font("Arial", Font.BOLD, 40));
            l9.setBounds(200, 65, 1300, 600);
            l8.setBounds(430, 10, 900, 80);

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
            f.add(b1);
            f.add(b2);
            f.add(b3);
            f.add(b4);
            f.add(l8);
            f.add(l9);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            // b2.addActionListener(this);
      }

      public void actionPerformed(ActionEvent ae) {
            if (ae.getSource().equals(b1)) {
                  if (t1.getText().isEmpty() || (t2.getText().isEmpty()) || (t3.getText().isEmpty())
                              || (t4.getText().isEmpty()) || (t5.getText().isEmpty()) || (t6.getText().isEmpty())
                              || (t7.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Data missing");
                  }

                  else {
                        try {
                              String Company_name = (String) t1.getText();
                              String Email = (String) t2.getText();
                              String Contact = (String) t3.getText();
                              String fname = (String) t5.getText();
                              String lucky_no = (String) t6.getText();
                              String password = (String) t7.getText();
                              DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                              Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                          "system", "password");
                              PreparedStatement ps = c
                                          .prepareStatement("insert into CompanyRegister values(?,?,?,?,?,?)");
                              ps.setString(1, Company_name);
                              ps.setString(2, Email);
                              ps.setString(3, Contact);
                              ps.setString(4, fname);
                              ps.setString(5, lucky_no);
                              ps.setString(6, password);
                              int rs = ps.executeUpdate();
                              if (rs == 1) {
                                    JOptionPane.showMessageDialog(null, "Registered successfully done");
                              }
                              ps.close();
                              c.close();
                              f.setVisible(false);
                              new CLogin();

                        } catch (Exception e) {
                        }
                  }
            } else if (ae.getSource().equals(b3)) {
                  f.setVisible(false);
                  new Homepage();
            } else if (ae.getSource().equals(b4)) {
                  t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");
                  t5.setText("");
                  t6.setText("");
                  t7.setText("");
            } else if (ae.getSource().equals(b2)) {
                  f.setVisible(false);
                  new ComboBoxExample();
            } else {
                  f.setVisible(false);
            }
      }

      public static void main(String... aaa) {
            new CompanyRegister();
      }
}
