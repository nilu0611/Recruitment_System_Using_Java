import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    JButton b3;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b3 = new JButton("Student Menu");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);
        set();
        setSize(800, 600);
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        b3.setBounds(100, 280, 300, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            // System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
        if (e.getActionCommand().equals("Student Menu")) {
            setVisible(false);
            new StdMenu();
        }

    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("1: Which one among these is not a primitive datatype?");
            jb[0].setText("Int");
            jb[1].setText("Float");
            jb[2].setText("Boolean");
            jb[3].setText("Arrays");
        }
        if (current == 1) {
            l.setText("2: What is the size of float and double in java?");
            jb[0].setText("32 and 64");
            jb[1].setText("32 and 128");
            jb[2].setText("32 and 32");
            jb[3].setText("16 and 32");
        }
        if (current == 2) {
            l.setText("3: Which package is directly available to our class without importing it?");
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Net");
            jb[3].setText("Lang");
        }
        if (current == 3) {
            l.setText("4: String class is defined in which package?");
            jb[0].setText("Lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("Awt");
        }
        if (current == 4) {
            l.setText("5: Select the valid statement.");
            jb[0].setText("char[] ch=new char(5)");
            jb[1].setText("char[] ch=new char[5]");
            jb[2].setText("char[] ch=new char[]");
            jb[3].setText("char[] ch=new char()");
        }
        if (current == 5) {
            l.setText("6: Which one among these is not a keyword in Java");
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("where");
            jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("7: When an array is passed to a method, what does the method receive? ");
            jb[0].setText("The reference of the array");
            jb[1].setText("Copy of array");
            jb[2].setText("Length of array");
            jb[3].setText("Duplicate Array");
        }
        if (current == 7) {
            l.setText(
                    "8: Keyword that makes a variable belong to a class,rather than being defined for each instance of the class.");
            jb[0].setText("final");
            jb[1].setText("static");
            jb[2].setText("abstract");
            jb[3].setText("volatile");
        }
        if (current == 8) {
            l.setText("9: Identify the return type of a method that does not return any value.");
            jb[0].setText("int");
            jb[1].setText("void");
            jb[2].setText("boolean");
            jb[3].setText("float");
        }
        if (current == 9) {
            l.setText("10: Which one among these is not a valid component?");
            jb[0].setText("JButton");
            jb[1].setText("JList");
            jb[2].setText("JField");
            jb[3].setText("JTextArea");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[0].isSelected());
        if (current == 2)
            return (jb[3].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[1].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[1].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[1].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");
    }
}