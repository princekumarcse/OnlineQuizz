package onlinequiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;

    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        /*
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/6.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(0, 0, 2500, 750);//600,450
        add(secimage);
         */
        //For Heading 
        JLabel heading = new JLabel("Hello," + name + " WelCome to ONLINE QUIZZ RULES ,Read It carefully");

        heading.setBounds(30, 10, 1500, 50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
        heading.setForeground(new Color(230, 0, 0));
        add(heading);
        
        JLabel Rules = new JLabel();
        Rules.setBounds(40, 90, 700, 350);
        Rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        //Rules.setForeground(new Color(30,144,254));
        add(Rules);

        //for BACK Button
        back = new JButton("BACK");
        back.setBounds(480, 655, 100, 40);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.BOLD, 18));
        back.addActionListener(this);
        add(back);

        //for Rules Button
        start = new JButton("START");
        start.setBounds(950, 655, 100, 40);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Times New Roman", Font.BOLD, 18));
        start.addActionListener(this);
        add(start);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Rules.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 20, 1500, 800);//600,450
        add(image);
        /*
        Rules.setText(
                "<html>"
                + "<br><br><br><br>"
                + "1. *********************************************" + "<br><br>"
                + "2. *********************************************" + "<br><br>"
                + "3. *********************************************" + "<br><br>"
                + "4. *********************************************" + "<br><br>"
                + "5. *********************************************" + "<br><br>"
                + "6. *********************************************" + "<br><br>"
                + "7. *********************************************" + "<br><br>"
                + "8. *********************************************" + "<br><br>"
                + "<html>"
        );
         */

        //frame for rules
        setSize(1540, 850);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Material(name);
        }
        if (ae.getSource() == back) {
            setVisible(false);
            new Login(name);
        }
    }

    public static void main(String[] args) {

        new Rules("User");
    }
}
