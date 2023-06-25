import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.sql.*;

public class ComboBoxExample {
    JFrame f;
    JLabel l1, l2;

    ComboBoxExample() {
        f = new JFrame("ComboBox Example");
        l1 = new JLabel("Welcome To Vishwa Recruiters");
        ImageIcon obj = new ImageIcon("registrationicon.png");
        l2 = new JLabel(obj);

        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        JButton b = new JButton("Register Now");
        b.setBackground(Color.black);
        b.setForeground(Color.white);

        b.setBounds(900, 500, 200, 40);
        String languages[] = { "Company Registration", "StudentRegistration", "Admin Registration" };
        final JComboBox cb = new JComboBox(languages);
        cb.setBounds(900, 250, 200, 40);
        cb.setBackground(Color.black);
        cb.setForeground(Color.white);
        l2.setBounds(10, 65, 1000, 600);

        l1.setBounds(430, 10, 900, 80);
        l1.setFont(new Font("Arial", Font.BOLD, 50));
        f.add(label);
        f.add(cb);
        f.add(l1);
        f.add(l2);

        f.add(b);
        f.setLayout(null);
        f.setSize(1600, 900);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "" + cb.getItemAt(cb.getSelectedIndex());
                if (data.equals("Company Registration")) {

                    new CompanyRegister();
                    f.setVisible(false);

                } else if (data.equals("StudentRegistration")) {
                    f.setVisible(false);
                    new Stdregister();
                } else

                    new Adminregister();

            }
        });

    }

    public static void main(String[] args) {
        new ComboBoxExample();
    }
}