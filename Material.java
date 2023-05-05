package onlinequiz;

//package onlinequiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static onlinequiz.quiz.ans_given;
import static onlinequiz.quiz.count;
import static onlinequiz.quiz.score;
import static onlinequiz.quiz.timer;

public class Material extends JFrame implements ActionListener {

    public static int timer1 = 60;
    String name;

    JButton start, back;

    Material(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //For Heading 
        JLabel heading = new JLabel("Hello," + name + " WelCome to ONLINE QUIZZ MATERIAL ,Read It carefully");

        heading.setBounds(10, 15, 1500, 50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 44, 254));
        add(heading);
        JLabel Rules = new JLabel();
        Rules.setBounds(20, 90, 700, 350);
        Rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        //Rules.setForeground(new Color(30,144,254));
        add(Rules);

        /*
        //for BACK Button
        back = new JButton("Back");
        back.setBounds(150, 700, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.BOLD, 18));
        back.addActionListener(this);
        add(back);
         */
        //for Rules Button
        /*
        start = new JButton("BACK");
        start.setBounds(1100, 700, 260, 50);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Times New Roman", Font.BOLD, 38));
        start.addActionListener(this);
        add(start);
        */

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/material.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 10, 1500, 800);//600,450
        add(image);
        /*
        Rules.setText(
                "<html>"
                + "HTML stands for Hyper Text Markup Language HTML is the standard markup language for creating Web pages." + "<br>"
                + " HTML describes the structure of a Web page HTML consists of a series of elements." + "<br>"
                + " Java is a popular programming language.Java is used to develop mobile apps, web apps, desktop apps, games and much more " + "<br>"
                + " Java is a popular programming language, created in 1995.It is owned by Oracle, and more than 3 billion devices run Java."
                + "It is used for: Mobile applications (specially Android apps),Desktop applications,Web applications,Games,Database connection."
+ "<br>"
                + " Charles Babbage is known as the father of computers. Charles Babbage designed and built the first mechanical computer and Difference Engine." + "<br>"
                + "<html>"
        );
         */
        //frame for rules
        setSize(1540, 850);
        setLocation(0, 0);
        setVisible(true);
    }
    ///////////////////////////////////////////////////
    //            this is for timer                  //
    //////////////////////////////////////////////////

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left - " + timer1 + " Seconds";//120 
        g.setColor(Color.GREEN);//timer color
        g.setFont(new Font("Tahoma", Font.BOLD, 30));//font size and style
        if (timer1 > 0) {
            g.drawString(time, 1000, 120);
        } else {
            g.drawString("Times Up!!", 1100, 120);
            setVisible(false);
            new quiz(name);
        }
        timer1--;//14 decreasing timer
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Rules(name);

            //new Login();
        }
    }

    public static void main(String[] args) {

        new Material("User");
    }
}
