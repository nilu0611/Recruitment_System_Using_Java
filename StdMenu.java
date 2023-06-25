import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.net.*;

public class StdMenu implements ActionListener {
    JFrame f;
    JMenuBar menubar;
    JMenu menu, options;
    JMenuItem View_vacancy, All_Company, logout, view_advertisements, feedback;
    JLabel l1, l2;
    Button b1;

    StdMenu() {
        ImageIcon obj = new ImageIcon("std.png");
        l2 = new JLabel(obj);
        f = new JFrame("Student Dashboard");
        menubar = new JMenuBar();
        options = new JMenu("Options");
        logout = new JMenuItem("Logout");
        feedback = new JMenuItem("feedback");
        b1 = new Button("Java Questions");

        View_vacancy = new JMenuItem("View_vacancy");
        menu = new JMenu("Menu");

        view_advertisements = new JMenuItem("view_advertisements");
        // All_Company = new JMenuItem("All_Company");
        l1 = new JLabel("Get Best Job For You");
        f.setVisible(true);
        f.setSize(1600, 900);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menubar.setBounds(0, 2, 1500, 50);
        l1.setBounds(470, 150, 700, 100);
        l2.setBounds(50, 130, 1200, 600);
        l1.setFont(new Font("Times New Roman", Font.BOLD, 40));
        b1.setBounds(1200, 650, 200, 50);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        f.add(menubar);
        menubar.add(menu);
        menubar.add(options);

        menu.add(View_vacancy);
        menu.add(view_advertisements);
        // menu.add(All_Company);
        options.add(logout);
        options.add(feedback);
        f.add(l1);
        f.add(l2);
        f.add(b1);
        menu.addActionListener(this);
        logout.addActionListener(this);
        View_vacancy.addActionListener(this);
        view_advertisements.addActionListener(this);
        feedback.addActionListener(this);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(logout)) {
            f.setVisible(false);
            new Login();
        } else if (e.getSource().equals(View_vacancy)) {
            new JTableDatabase1();
        } else if (e.getSource().equals(view_advertisements)) {
            new Ad();
        } else if (e.getSource().equals(feedback)) {
            new Feed1();
        } else if (e.getSource().equals(b1)) {
            new OnlineTest("Online Test Of Java");
        }

    }

    public static void main(String sd[]) {
        new StdMenu();
    }
}
