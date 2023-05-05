package onlinequiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener {

    String name;
    
    score(String name, int score) {
        
         this.name = name;
         
        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // image insert
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/pic3.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 500, 1000);//600,450
        add(image);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/9.png"));
        JLabel scoreimage = new JLabel(i2);
        scoreimage.setBounds(550, 60, 500, 320);//600,450
        add(scoreimage);

        //for Questions numbers
        JLabel qno = new JLabel("Thank You " + name + " for playing Online Quizz");
        qno.setBounds(320, 50, 1000, 60);
        qno.setFont(new Font("Viner Hand ITC", Font.BOLD, 46));
        add(qno);

        JLabel lblscore = new JLabel("Your Score is: " + score);
        lblscore.setBounds(600, 350, 700, 60);
        lblscore.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        add(lblscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(680, 450, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        //submit.setEnabled(false);
        add(submit);

        setSize(1540, 850);
        setLocation(0, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login(name);
    }

    public static void main(String args[]) {
        new score("user", 0);
    }
}
