import java.io.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class Postvacancyy implements ActionListener {
      JFrame f;
      JLabel l1, l2, l3, l4, l5, l6, l7;
      TextField t1, t2, t3, t4, t5;
      JButton b1, b2, b3, b4;

      Postvacancyy() {
            l7 = new JLabel("");
            ImageIcon obj = new ImageIcon("postvacancy.png");
            l6 = new JLabel(obj);
            f = new JFrame("Post_vacancy");
            l1 = new JLabel("Company_id");
            l2 = new JLabel("Job_Profile");
            l3 = new JLabel("Eligibility_cretia");
            l4 = new JLabel("Salary");
            l5 = new JLabel("Email_id");
            t1 = new TextField();
            t2 = new TextField();
            t3 = new TextField();
            t4 = new TextField();
            t5 = new TextField();
            b1 = new JButton("Post");
            b2 = new JButton("Reset");
            b3 = new JButton("Cancel");
            b4 = new JButton("Previous");
            b3.setBackground(Color.black);
            b3.setForeground(Color.white);
            b4.setBackground(Color.black);
            b4.setForeground(Color.white);
            b1.setBackground(Color.black);
            b1.setForeground(Color.white);
            b2.setBackground(Color.black);
            b2.setForeground(Color.white);

            f.setVisible(true);
            f.setSize(1600, 900);
            f.setLayout(null);
            l7.setFont(new Font("Arial", Font.BOLD, (30)));
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
            l6.setBounds(200, 65, 1300, 600);
            l7.setBounds(430, 10, 900, 80);

            b1.setBounds(60, 240, 100, 40);
            b2.setBounds(185, 240, 100, 40);
            b3.setBounds(90, 300, 150, 30);
            b4.setBounds(90, 350, 150, 30);

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
            f.add(b1);
            f.add(b2);
            f.add(b3);
            f.add(b4);
            f.add(l6);
            f.add(l7);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
      }

      public void actionPerformed(ActionEvent ae) {
            if (ae.getSource().equals(b1)) {
                  if (t1.getText().isEmpty() || (t2.getText().isEmpty()) || (t3.getText().isEmpty())
                              || (t4.getText().isEmpty()) || (t5.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Data missing");
                  } else {
                        try {
                              String Company_id = (String) t1.getText();
                              String job_profile = (String) t2.getText();
                              String eligibility_cretia = (String) t3.getText();
                              String salary = (String) t4.getText();
                              String email_id = (String) t5.getText();

                              DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                              Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                          "system", "password");
                              PreparedStatement ps = c.prepareStatement("insert into Postvacancyy values(?,?,?,?,?)");
                              ps.setString(1, Company_id);
                              ps.setString(2, job_profile);
                              ps.setString(3, eligibility_cretia);
                              ps.setString(4, salary);
                              ps.setString(5, email_id);
                              int rs = ps.executeUpdate();
                              if (rs == 1) {
                                    JOptionPane.showMessageDialog(null, "Post successfully done");
                              } else {
                                    JOptionPane.showMessageDialog(null, "missing data");
                              }
                              ps.close();
                              c.close();
                        } catch (Exception e) {
                        }
                  }
            } else if (ae.getSource().equals(b3)) {
                  f.setVisible(false);
                  new Homepage();
            } else if (ae.getSource().equals(b4)) {
                  f.setVisible(false);
                  new Menu();
            } else {
                  t1.setText("");
                  t2.setText("");
                  t3.setText("");
                  t4.setText("");
                  t5.setText("");
            }
      }

      public static void main(String... aaa) {
            new Postvacancyy();
      }
}
