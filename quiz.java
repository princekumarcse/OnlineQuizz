package onlinequiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswer[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton submit, next;
    //time for questions
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    quiz(String name) {
        this.name = name;
        //frame 
        setBounds(0, 0, 1540, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // image insert
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/quizz1.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 20, 1000, 400);//600,450
        add(image);

        //for Questions numbers
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        //for Questions numbers
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // these all are questions
        questions[0][0] = "By default a real number is treated as a";
        questions[0][1] = "Double";
        questions[0][2] = "Float";
        questions[0][3] = "Long Double";
        questions[0][4] = "Far Double";

        questions[1][0] = "Which of the following can be overloaded?";
        questions[1][1] = "Functions and Operators";
        questions[1][2] = "Functions";
        questions[1][3] = "Operators";
        questions[1][4] = "Object";

        questions[2][0] = "Which of the following means \"The use of an object of one class in definition of another class\"?";
        questions[2][1] = "Composition";
        questions[2][2] = "Inheritance";
        questions[2][3] = "Encapsulation";
        questions[2][4] = "Abstraction";

        questions[3][0] = "Which is a valid keyword in java?";
        questions[3][1] = "interface";
        questions[3][2] = "string";
        questions[3][3] = "Float";
        questions[3][4] = "unsigned";

        questions[4][0] = "Who is the father of Computers?";
        questions[4][1] = "Charles Babbage";
        questions[4][2] = "James Gosling";
        questions[4][3] = "Dennis Ritchie";
        questions[4][4] = "Bjarne Stroustrup";

        questions[5][0] = "Which of the following is the smallest unit of data in a computer?";
        questions[5][1] = "Bit";
        questions[5][2] = "KB";
        questions[5][3] = "Nibble";
        questions[5][4] = "byte";

        questions[6][0] = "Which of the following are physical devices of a computer?";
        questions[6][1] = "Hardware";
        questions[6][2] = "Software";
        questions[6][3] = "System Software";
        questions[6][4] = "Package";

        questions[7][0] = "Which of the following can access the server?";
        questions[7][1] = "Web Client";
        questions[7][2] = "User";
        questions[7][3] = "Web Browser";
        questions[7][4] = "Web Server";

        questions[8][0] = "Which of the following type of computer is mostly used for automatic operations?";
        questions[8][1] = "Remote";
        questions[8][2] = "digital";
        questions[8][3] = "Hybrid";
        questions[8][4] = "analog";

        questions[9][0] = " Which of the following is not a type of computer on the basis of operation?";
        questions[9][1] = "Remote";
        questions[9][2] = "Digital";
        questions[9][3] = "Analog";
        questions[9][4] = "Hybrid";

        //these all are the answer of the above questions
        answers[0][1] = "Double";
        answers[1][1] = "Functions and Operators";
        answers[2][1] = "Composition";
        answers[3][1] = "interface";
        answers[4][1] = "Charles Babbage";
        answers[5][1] = "Bit";
        answers[6][1] = "Hardware";
        answers[7][1] = "Web Client";
        answers[8][1] = "Remote";
        answers[9][1] = "Remote";

        // these four Button Defines Option for thequestions.
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("DIALOG", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("DIALOG", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("DIALOG", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("DIALOG", Font.PLAIN, 20));
        add(opt4);

        //to choose any one options
        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 530, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 610, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = groupOptions.getSelection().getActionCommand();
            }

            //submit button Enable when question is last.
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                useranswer[count][0] = "";
            } else {
                useranswer[count][0] = groupOptions.getSelection().getActionCommand();
            }
            for (int i = 0; i < useranswer.length; i++) {
                if (useranswer[i][0].equals(answers[i][1])) {
                    score += 1;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new score(name, score);
        }
    }

    ///////////////////////////////////////////////////
    //            this is for timer                  //
    //////////////////////////////////////////////////
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left - " + timer + " Seconds";//15 
        g.setColor(Color.RED);//timer color
        g.setFont(new Font("Tahoma", Font.BOLD, 25));//font size and style
        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times Up!!", 1100, 500);
        }
        timer--;//14 decreasing timer
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {//selection of answer
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {//submit button case
                if (groupOptions.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupOptions.getSelection().getActionCommand();
                }
                for (int i = 0; i < useranswer.length; i++) {
                    if (useranswer[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new score(name, score);
            } else {//next button case
                if (groupOptions.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = groupOptions.getSelection().getActionCommand();
                }
                count++;//0//1
                start(count);
            }

        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupOptions.clearSelection();
    }

    public static void main(String ars[]) {
        new quiz("user");
    }
}
