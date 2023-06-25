import javax.swing.*;
import java.awt.*;

public class TextAreaExample {
   TextAreaExample() {
      JFrame f = new JFrame();
      TextArea area = new TextArea("gbghbghb");
      area.setText(
            "1] VishwaRecruiters is a leading provider of recruitment solutions that help companies find the right talent quickly and efficiently.\n\n2] Our mission is to revolutionize the hiring process by leveraging technology to match the best candidates with the right jobs.\n\n3] Our values are centered on integrity, innovation, and excellence. We believe that hiring the right people is critical to the success of any organization.\n\n4] We are committed to providing the best possible solutions to our clients.\n\n5] Our team is made up of experienced recruiters, software developers, and HR professionals who are passionate about helping companies find the talent they need.\n\n6] With over 25 years of combined experience, we have the knowledge and expertise to help you streamline your hiring process and achieve your goals.\n\n7] We are committed to providing the highest level of customer service and support.\n\n8] We are always looking for ways to improve our solutions and exceed our clients' expectations.\n\n9] Contact us today to learn more about how we can help you find the right talent for your organization.");
      area.setBounds(20, 40, 1000, 600);
      area.setEditable(false);
      f.add(area);
      f.setSize(1600, 900);
      f.setLayout(null);
      f.setVisible(true);
      Font font = new Font("Arial", Font.BOLD, 15);
      area.setFont(font);
   }

   public static void main(String args[]) {
      new TextAreaExample();
   }
}