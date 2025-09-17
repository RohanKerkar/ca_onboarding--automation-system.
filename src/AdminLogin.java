package CA_project_2;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame {
         JLabel adminlabel,usernameLabel,passwordLabel;
    JTextField usernameField;
          JPasswordField passwordField;

    public AdminLogin() {
      //  JFrame frame2=new JFrame();
        setTitle("Admin Login");
        setSize(400, 250);
       // frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLayout(null);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        rounded_panel adminPanel = new rounded_panel(80);
        adminPanel.setLayout(null); // For manual layout inside the panel 
        adminPanel.setBackground(Color.white); 
        adminPanel.setBounds(550, 100, 400, 400);   
        add(adminPanel);
       Color LabelColor = new Color(80, 0, 128); // Purple

        adminlabel=new JLabel("Admin Login");
        adminlabel.setBounds(130, 20, 200, 50);
        adminlabel.setForeground(LabelColor);
        adminlabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        adminPanel.add(adminlabel);

        usernameLabel =new JLabel("Username:");
        usernameLabel.setForeground(LabelColor);
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        usernameLabel.setBounds(110,80,100,50);
        adminPanel.add(usernameLabel);
        usernameField=new JTextField();
        usernameField.setForeground(Color.black);
        usernameField.setBounds(110,130,200,25);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        adminPanel.add(usernameField);

        passwordLabel =new JLabel("Password:");
        passwordLabel.setForeground(LabelColor);
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        passwordLabel.setBounds(110,170,100,50);
        adminPanel.add(passwordLabel);
        passwordField=new JPasswordField();
        passwordField.setForeground(Color.BLACK);
        passwordField.setBounds(110,220,200,25);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        adminPanel.add(passwordField);
          
        rounded_button loginButton=new rounded_button("Login",30);
        loginButton.setBounds(150, 280, 100, 33); 
        Color buttonColor = new Color(166, 28, 245); // Purple     //submit button
        loginButton.setBackground(buttonColor); 
        loginButton.setForeground(Color.WHITE); 
        loginButton.setFont(new Font("SansSerif",Font.BOLD,16));
        adminPanel.add(loginButton);

 

        // Login button action
         loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                //  Hardcoded check (later connect to DB if needed)
                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose(); // close login window
                    // open your Admin Dashboard here
                        Dashboard d = new Dashboard();
                        d.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
                }
            }
        });

       /*  // Back button action
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // close login window
                // go back to your main FormUI
              //  new formUI_2().setVisible(true); 
            }
        }); */
        addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
       
        new formUI_2().setVisible(true); 
    }
});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLogin().setVisible(true));
    }
}
