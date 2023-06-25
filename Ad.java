import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;

public class Ad implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4;
    JButton b1, b2, b3, b4;

    Ad() {
        f = new JFrame("Advertisement");
        l1 = new JLabel("Recruiting Companies");
        ImageIcon img = new ImageIcon("images.PNG");
        b1 = new JButton("Apply");
        l2 = new JLabel(img);
        b2 = new JButton("Apply");
        ImageIcon img2 = new ImageIcon("images.jpg");
        l3 = new JLabel(img2);
        ImageIcon img3 = new ImageIcon("download.jpg");
        b3 = new JButton("Apply");
        b4 = new JButton("Previous");

        l4 = new JLabel(img3);
        f.setVisible(true);
        f.setSize(1600, 800);
        f.setLayout(null);
        l1.setBounds(520, 1, 500, 200);
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        l1.setForeground(Color.blue);

        l2.setBounds(500, 120, 300, 150);
        b1.setBounds(600, 280, 100, 40);
        l3.setBounds(500, 330, 330, 150);
        b2.setBounds(600, 490, 100, 40);
        l4.setBounds(500, 550, 300, 100);
        b3.setBounds(600, 690, 100, 40);
        b4.setBounds(1200, 30, 150, 30);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b4)) {
            f.setVisible(false);
            new StdMenu();
        }
        if (ae.getSource().equals(b1)) {

            JOptionPane.showMessageDialog(null, "You will get notification soon");
        }
        if (ae.getSource().equals(b2)) {
            JOptionPane.showMessageDialog(null, "You will get notification soon");

        }
        if (ae.getSource().equals(b3)) {

            JOptionPane.showMessageDialog(null, "You will get notification soon");
        }

    }

    public static void main(String... aa) {
        new Ad();
    }
}
