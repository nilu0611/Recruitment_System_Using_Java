import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.JScrollPane;

public class JTableDatabase2 implements ActionListener {
    JFrame f;
    JLabel l1, l2;
    JButton b1;
    JTextField t1, t2, t4, t5;

    JTableDatabase2() {
        f = new JFrame("view details");
        // l1 = new JLabel("e-mail");
        // l2 = new JLabel("message");
        t1 = new JTextField(20);
        t2 = new JTextField(30);
        b1 = new JButton("send");
        t4 = new JTextField("Email");
        t5 = new JTextField("Message");
        t4.setForeground(Color.white);
        t4.setBackground(Color.black);
        t5.setForeground(Color.white);
        t5.setBackground(Color.black);
        t4.setEditable(false);
        t5.setEditable(false);
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel p = new JPanel();
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
            String sql = "select name,age,email,contact from Stdregister";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i));
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        TableColumn col;
        for (int i = 0; i < table.getColumnCount(); i++) {
            col = table.getColumnModel().getColumn(i);
            col.setMaxWidth(300);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        p.add(scrollPane);
        f.add(p);

        f.setSize(1600, 900);
        f.setVisible(true);
        f.setLayout(null);

        // l1.setBounds(200, 570, 100, 20); // x, y, width, height for label 1
        // t1.setBounds(370, 570, 200, 20); // x, y, width, height for text field 1
        // l2.setBounds(200, 620, 100, 20); // x, y, width, height for label 2
        // t2.setBounds(370, 620, 200, 20); // x, y, width, height for text field 2
        // b1.setBounds(380, 660, 100, 20);
        t4.setBounds(200, 570, 100, 20); // x, y, width, height for label 1
        t1.setBounds(370, 570, 200, 20); // x, y, width, height for text field 1
        t5.setBounds(200, 620, 100, 20); // x, y, width, height for label 2
        t2.setBounds(370, 620, 200, 20); // x, y, width, height for text field 2
        b1.setBounds(380, 660, 100, 20);

        f.add(t4);
        f.add(t5);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        // f.setVisible(true);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            try {
                JOptionPane.showMessageDialog(null, "successfully send");
                String s1 = t1.getText();
                String s2 = t2.getText();
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                PreparedStatement ps = c.prepareStatement("insert into Sstud values(?,?)");
                ps.setString(1, s1);
                ps.setString(2, s2);

                int m = ps.executeUpdate();
                if (m == 1)
                    JOptionPane.showMessageDialog(null, "selected successfully");
                ps.close();
                c.close();
            } catch (Exception ee) {
            }

        }
    }

    public static void main(String... aa) {
        new JTableDatabase2();
    }
}