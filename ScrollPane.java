import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ScrollPane extends JFrame {
    ScrollPane() // it also can be written as public Scrollpane ,if u not specify it mean already
                 // its declare as public
    {
        super("ScrollPane");
        ImageIcon img = new ImageIcon("Labh.jpg");
        ImageIcon img1 = new ImageIcon("SM755858.jpg");

        JScrollPane jpg = new JScrollPane(new JLabel(img));

        getContentPane().add(jpg);
        getContentPane().add(jpg);
        setSize(1600, 900);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScrollPane();
    }
}
