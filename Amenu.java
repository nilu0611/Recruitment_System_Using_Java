import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.net.*;

public class Amenu implements ActionListener {
    JFrame f;
    JMenuBar menubar;
    JMenu menu, options;
    JMenuItem view_std_details, post_vacancy, logout, feedback, view_vacancy;
    JLabel l1, l2;

    Amenu() {
        ImageIcon obj = new ImageIcon("adminaccess.png");
        l2 = new JLabel(obj);
        f = new JFrame(" Admin Details ");
        menubar = new JMenuBar();
        options = new JMenu("Options");
        logout = new JMenuItem("Logout");
        feedback = new JMenuItem("feedback");
        menu = new JMenu("Menu");

        view_std_details = new JMenuItem("view_std_details");
        post_vacancy = new JMenuItem("post_vacancy");
        view_vacancy = new JMenuItem("View_vacancy");
        l1 = new JLabel("Get Best For Your Best");
        f.setVisible(true);
        f.setSize(1600, 900);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar.setBounds(0, 2, 1500, 50);
        l1.setBounds(400, 100, 700, 100);
        l2.setBounds(50, 130, 1200, 600);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 50));
        f.add(menubar);
        menubar.add(menu);
        menubar.add(options);

        menu.add(view_std_details);

        menu.add(post_vacancy);
        menu.add(view_vacancy);

        options.add(logout);
        options.add(feedback);
        f.add(l1);
        f.add(l2);
        menu.addActionListener(this);
        logout.addActionListener(this);
        view_std_details.addActionListener(this);
        post_vacancy.addActionListener(this);
        view_vacancy.addActionListener(this);
        feedback.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(logout)) {
            f.setVisible(false);
            new ALogin();
        } else if (e.getSource().equals(view_std_details)) {
            new JTableDatabase2();
        } else if (e.getSource().equals(feedback)) {
            new Feed1();
        } else if (e.getSource().equals(view_vacancy)) {
            new JTableDatabase1();
        } else if (e.getSource().equals(post_vacancy)) {
            f.setVisible(false);
            new Postvacancyyy();
        }
    }

    public static void main(String sd[]) {
        new Amenu();
    }
}
