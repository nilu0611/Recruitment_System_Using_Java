import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Homepage implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5;
    JButton b1, b2, b3, b4;
    Button b5, b6;

    Homepage() {
        f = new JFrame("Recruiment");
        l1 = new JLabel("Welcome to the Recruitments System");
        ImageIcon img = new ImageIcon("adminlogin.jpg");
        l3 = new JLabel(img);
        l2 = new JLabel("Get Your Dream Job Today");
        l4 = new JLabel("Think As A Team");
        l5 = new JLabel("Enjoy Work Like Never Before");
        b1 = new JButton("Company Login");
        b2 = new JButton("Student Login");
        b3 = new JButton("Admin Login");
        b4 = new JButton("Cancel");
        b5 = new Button("About Us");
        b6 = new Button("FAQ");
        f.setVisible(true);
        f.setSize(1600, 900);
        f.setLayout(null);
        l1.setBounds(345, 50, 800, 90);
        b5.setBounds(1200, 30, 150, 30);
        l2.setBounds(450, 100, 900, 80);
        l3.setBounds(0, 160, 1300, 450);
        l4.setBounds(10, 20, 200, 40);
        l5.setBounds(10, 40, 300, 40);

        b1.setBounds(245, 630, 150, 60);
        b2.setBounds(445, 630, 150, 60);
        b3.setBounds(645, 630, 150, 60);
        b4.setBounds(845, 630, 150, 60);
        b6.setBounds(1200, 630, 150, 30);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1.setFont(new Font("Arial", Font.BOLD, 40));
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setFont(new Font("Arial", Font.BOLD, 20));

        f.add(l1);
        f.add(b5);
        f.add(l3);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b6);
        f.add(l4);
        f.add(l5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            f.setVisible(false);
            new CLogin();
        }

        if (ae.getSource().equals(b2)) {
            f.setVisible(false);
            new Login();
        }

        if (ae.getSource().equals(b3)) {
            f.setVisible(false);
            new ALogin();
        }

        if (ae.getSource().equals(b4)) {
            f.setVisible(false);
        }
        if (ae.getSource().equals(b5)) {
            new TextAreaExample();
        }
        if (ae.getSource().equals(b6)) {
            new ScrollPane();
        }
    }

    public static void main(String... aaa) {
        new Homepage();
    }
}