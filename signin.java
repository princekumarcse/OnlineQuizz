package onlinequiz;
//
//import java.awt.Font;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class signin extends JFrame implements ActionListener {

    JButton login, clear, register;
    JTextField tfregno;
    JPasswordField tfpassword;
    String name, password, regno;

    signin() {

        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        // hading

        JLabel heading1 = new JLabel("Hello Learners WelCome to Online Quizz Login Page ");
        heading1.setBounds(150, 55, 1500, 50);
        heading1.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading1.setForeground(new Color(30, 144, 30));
        add(heading1);

        ///logo for login
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 10, 880, 400);//600,450
        add(image);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/m.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(0, 0, 2200, 750);//600,450
        add(secimage);

        JLabel lblregno = new JLabel("Registration No:");
        lblregno.setFont(new Font("times new roman", Font.BOLD, 20));
        lblregno.setBounds(300, 310, 220, 20);
        add(lblregno);

        tfregno = new JTextField();
        tfregno.setBounds(460, 310, 150, 25);
        tfregno.setFont(new Font("Arial", Font.BOLD, 14));
        add(tfregno);
        // label for password

        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setFont(new Font("times new roman", Font.BOLD, 20));
        lblpassword.setBounds(300, 390, 220, 20);
        add(lblpassword);
        //password textfield

        tfpassword = new JPasswordField();
        tfpassword.setBounds(460, 390, 150, 25);
        tfpassword.setFont(new Font("Arial", Font.BOLD, 14));
        add(tfpassword);
        //Login Button

        login = new JButton("Login");
        login.setBounds(300, 470, 120, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("tahome", Font.BOLD, 15));
        add(login);
        //cancle button

        clear = new JButton("Clear");
        clear.setBounds(480, 470, 120, 30);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        clear.setFont(new Font("tahome", Font.BOLD, 15));
        add(clear);

        //dont have account
        JLabel lblrandom = new JLabel("Don't Have Account? ");
        lblrandom.setBounds(380, 500, 200, 40);
        lblrandom.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
        lblrandom.setForeground(Color.red);
        add(lblrandom);

        register = new JButton("Register");
        register.setBounds(330, 550, 240, 30);
        register.setBackground(Color.blue);
        register.setForeground(Color.white);
        register.addActionListener(this);
        register.setFont(new Font("tahome", Font.BOLD, 15));
        add(register);

        //frame
        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            //setVisible(false);
            tfregno.setText("");
            tfpassword.setText("");
        } else if (ae.getSource() == register) {
            setVisible(false);
            new registration(name);
        } else if (ae.getSource() == login) {
            connect c = new connect();

            String regno = tfregno.getText();
            String password = tfpassword.getText();
            String query = "Select * from Login where Regno='" + regno + "' and Password='" + password + "'";

            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                     JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
                    setVisible(false);
                    new Login(password).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Registration No. or Password");
                   // setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String args[]) {
        new signin();
    }
}
