package onlinequiz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registration extends JFrame implements ActionListener {

    JButton registerButton, Back, sign;
    JTextField txtfieldname, txtfieldregno, txtfieldemail, txtfieldpassword, txtfielddegree, txtfielddistrict, txtfieldstate;
    String name;

    registration(String name) {

        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading1 = new JLabel("Hello,Learners Now You are on   Online Quizz Register  Page ");
        heading1.setBounds(50, 10, 1500, 50);
        heading1.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading1.setForeground(new Color(200, 10, 0));
        add(heading1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/reg.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(660, 10, 280, 200);//600,450
        add(image);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icons/10.png"));
        JLabel pimage = new JLabel(i3);
        pimage.setBounds(10, 140, 480, 500);//600,450
        add(pimage);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(1150, 140, 380, 500);//600,450
        add(secimage);

        //NAME
        JLabel Name = new JLabel("Name :");
        Name.setBounds(550, 180, 120, 25);
        Name.setFont(new Font("Times new roman", Font.BOLD, 20));
        add(Name);

        //text field for name
        txtfieldname = new JTextField();
        txtfieldname.setBounds(780, 180, 270, 30);
        add(txtfieldname);

        //registration field   
        JLabel Registration = new JLabel("Registration No :");
        Registration.setBounds(550, 230, 160, 25);
        Registration.setFont(new Font("Times new roman", Font.BOLD, 20));
        add(Registration);
        //textfield for registration 

        txtfieldregno = new JTextField();
        txtfieldregno.setBounds(780, 230, 270, 30);
        add(txtfieldregno);

        //email 
        JLabel email = new JLabel("Email :");
        email.setBounds(550, 280, 120, 25);
        email.setFont(new Font("times new roman", Font.BOLD, 20));
        add(email);

        //textfield for email
        txtfieldemail = new JTextField();
        txtfieldemail.setBounds(780, 280, 270, 30);
        add(txtfieldemail);

        //password
        JLabel password = new JLabel("Password :");
        password.setBounds(550, 330, 120, 25);
        password.setFont(new Font("times new roman", Font.BOLD, 20));
        add(password);
        //textfield for password

        txtfieldpassword = new JPasswordField();
        txtfieldpassword.setBounds(780, 330, 270, 30);
        add(txtfieldpassword);

        //retype password
        JLabel degree = new JLabel("Degree :");
        degree.setBounds(550, 380, 220, 25);
        degree.setFont(new Font("times new roman", Font.BOLD, 20));
        add(degree);

//        Degree field
        txtfielddegree = new JTextField();
        txtfielddegree.setBounds(780, 380, 270, 30);
        add(txtfielddegree);

        //district
        JLabel district = new JLabel("District : ");
        district.setBounds(550, 430, 120, 25);
        district.setFont(new Font("times new roman", Font.BOLD, 20));
        add(district);
        //textfield for district

        txtfielddistrict = new JTextField();
        txtfielddistrict.setBounds(780, 430, 270, 30);
        add(txtfielddistrict);

        //state
        JLabel state = new JLabel("State :");
        state.setBounds(550, 490, 120, 25);
        state.setFont(new Font("times new roman", Font.BOLD, 20));
        add(state);
        //textfield for state
        txtfieldstate = new JTextField();
        txtfieldstate.setBounds(780, 490, 270, 30);
        add(txtfieldstate);

        // registration button
        registerButton = new JButton("Register");
        registerButton.setBounds(650, 550, 300, 30);
        registerButton.setBackground(Color.BLUE);
        registerButton.setForeground(Color.white);
        registerButton.setFont(new Font("times new roman", Font.BOLD, 15));
        registerButton.addActionListener(this);
        add(registerButton);

        //if already registered 
        JLabel lblrandom = new JLabel("Registered? ");
        lblrandom.setBounds(750, 600, 200, 40);
        lblrandom.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        lblrandom.setForeground(Color.red);
        add(lblrandom);
        //login button

        sign = new JButton("Now SignIn");
        sign.setBounds(650, 650, 300, 30);
        sign.setBackground(Color.BLUE);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
//        login.setFont(new Font("tahome", Font.BOLD, 15));
        add(sign);

        //frame 
        setSize(1600, 1200);
        setLocation(0, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sign) {
            String name = txtfieldname.getText();
            setVisible(false);
            new signin();

        }
        /*
        if (ae.getSource() == Back) {
            setVisible(false);
            new signin();
        }
         */
        if (ae.getSource() == registerButton) {
            String Name = txtfieldname.getText();
            String Registration = txtfieldregno.getText();
            String Email = txtfieldemail.getText();
            String Password = txtfieldpassword.getText();
            String degree = txtfielddegree.getText();
            String District = txtfielddistrict.getText();
            String State = txtfieldstate.getText();

            try {
                connect c = new connect();
                String query = "insert into StudRegistration values('" + Name + "', '" + Registration + "', '" + Email + "', '" + Password + "', '" + degree + "','" + District + "','" + State + "')";
                String query1 = "insert into Login values('" + Registration + "','" + Password + "')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "You are Registered");
                txtfieldname.setText("");
                txtfieldname.setText("");
                txtfieldemail.setText("");
                txtfieldpassword.setText("");
                txtfielddegree.setText("");
                txtfielddistrict.setText("");
                txtfieldstate.setText("");
                 
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String args[]) {

        new registration("user");
    }
}
