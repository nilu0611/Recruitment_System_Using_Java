import java.awt.EventQueue;
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

public class Homepage implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3, b4, b7;
    Button b5, b8;
    // Button b6;

    Homepage() {
        f = new JFrame("Recruitment");
        Color customColor = new Color(255, 102, 0); // Create a custom color
        Color customColor1 = new Color(255, 255, 255);
        JPanel panel = new JPanel();
        panel.setBackground(customColor1); // Set the background color of the panel
        f.setContentPane(panel); // Set the content pane of the frame to the panel
        f.pack();
        f.setVisible(true);
        l1 = new JLabel("We Nurture for better Future");

        ImageIcon img = new ImageIcon("RS-icon3.png");
        l3 = new JLabel(img);
        l6 = new JLabel("");
        l2 = new JLabel("");
        l4 = new JLabel("Better Connections");
        l5 = new JLabel("Better Future");
        b1 = new JButton("Company Login");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b2 = new JButton("Student Login");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b3 = new JButton("Admin Login");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b4 = new JButton("Cancel");
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b5 = new Button("About Us");
        b5.setBackground(Color.white);
        b5.setForeground(Color.black);
        b7 = new JButton("Register");
        b7.setBackground(Color.white);
        b7.setForeground(Color.black);
        b8 = new Button("view-feedbacks");
        b8.setBackground(Color.white);
        b8.setForeground(Color.black);
        // b6 = new Button("Java Questions");
        // b6.setBackground(Color.white);
        // b6.setForeground(Color.black);

        f.setVisible(true);
        f.setSize(1600, 900);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1.setBounds(360, 33, 800, 90);

        l1.setForeground(Color.black);
        b5.setBounds(1200, 500, 150, 30);
        b7.setBounds(535, 700, 150, 60);
        b8.setBounds(1200, 603, 150, 30);
        l2.setBounds(720, 38, 900, 80);
        l2.setForeground(customColor);
        l3.setBounds(0, 160, 1230, 450);
        l4.setBounds(10, 10, 200, 40);
        l4.setForeground(Color.black);
        l5.setBounds(10, 30, 300, 40);
        l5.setForeground(Color.black);
        l6.setBounds(1220, 450, 150, 30);
        b1.setBounds(245, 630, 150, 60);
        b2.setBounds(445, 630, 150, 60);
        b3.setBounds(645, 630, 150, 60);
        b4.setBounds(845, 630, 150, 60);
        // b6.setBounds(1200, 635, 150, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 40));
        l2.setFont(new Font("Arial", Font.BOLD, 40));
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
        // f.add(b6);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(b7);
        f.add(b8);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        // b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b7)) {
            f.setVisible(false);
            new ComboBoxExample();
        } else if (ae.getSource().equals(b8)) {
            new Feedback();
        }

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
            f.setVisible(false);
            new TextAreaExample();
        }

    }

    public static void main(String... aa) {
        new Homepage();
    }
}
