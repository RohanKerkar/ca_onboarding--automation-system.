package CA_project_2;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.*;
public class formUI_2  extends JFrame implements FocusListener{
  JTextField nameField, emailField, phoneField, collegeField, cityField;
    JLabel nameLabel, emailLabel, phoneLabel, collegeLabel, cityLabel;
  public  formUI_2()
    {
         JFrame frame = new JFrame("New Joinee Form - IAC Onboarding");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(173, 216, 230));  
        Color labelColor = new Color(80, 0, 128); // Purple

        rounded_panel formPanel = new rounded_panel(100);
        formPanel.setLayout(null); // For manual layout inside the panel 
        formPanel.setBackground(Color.white); 
        formPanel.setBounds(500, 10, 490, 740);   
        frame.add(formPanel);

        rounded_button login=new rounded_button("Admin Login",30);
        frame.add(login);
        login.setBounds(1300,20,170,50);
        login.setBackground(Color.WHITE);
        login.setForeground(labelColor);
        login.setFont(new Font("SansSerif", Font.BOLD, 16));
        login.addActionListener(e -> {
         new AdminLogin().setVisible(true); // open login window
           frame.dispose(); // optional: close FormUI if you don’t want both open
});

   
        JLabel introLabel1=new JLabel("IAC- community Ambassador ");
        introLabel1.setForeground(labelColor);
        introLabel1.setBounds(80,20,500,30);
        introLabel1.setFont(new Font("SansSerif", Font.BOLD, 22));
        formPanel.add(introLabel1);
        JLabel introLabel2=new JLabel("Onboarding");
        introLabel2.setForeground(labelColor);
         introLabel2.setBounds(160,60,500,30);
        introLabel2.setFont(new Font("SansSerif", Font.BOLD, 22));
        formPanel.add(introLabel2);

      ImageIcon icon = new ImageIcon("src/CA_project_2/IAC_logo.png");
      Image img = icon.getImage();
      Image scaledImg = img.getScaledInstance(330, 320, Image.SCALE_SMOOTH); //  Reduced size
      JLabel logoLabel = new JLabel(new ImageIcon(scaledImg));
      logoLabel.setBounds(100, 120, 300, 140); // Adjusted position
      formPanel.add(logoLabel); 


        nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(140, 280, 100, 25);
        nameLabel.setForeground(labelColor);
        nameLabel.setFont(new Font("SansSerif",Font.BOLD,16));
        formPanel.add(nameLabel);                                        // name label and name field
        nameField = new JTextField(" Full Name:");
        nameField.setBounds(140, 310, 224, 25);
        nameField.setForeground(Color.gray);
        nameField.setFont(new Font("SansSerif",Font.ITALIC,14));
        formPanel.add(nameField);                                           // 40 and 25
        nameField.addFocusListener(this);


        emailLabel = new JLabel("Email (Gmail):");
        emailLabel.setBounds(140, 350, 120, 25);
        emailLabel.setForeground(labelColor);
        emailLabel.setFont(new Font("SansSerif",Font.BOLD,16));
        formPanel.add(emailLabel);                                            //email label and email field
        emailField = new JTextField(" Email (Gmail):");
        emailField.setBounds(140, 380, 224, 25);
        emailField.setForeground(Color.GRAY);
        emailField.setFont(new Font("SansSerif",Font.ITALIC,14));
        formPanel.add(emailField);
        emailField.addFocusListener(this);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(140,420, 120, 25);
        phoneLabel.setForeground(labelColor);
        phoneLabel.setFont(new Font("SansSerif",Font.BOLD,16));
        formPanel.add(phoneLabel);                                                 //phone label and phone field
        phoneField = new JTextField(" Phone Number:");
        phoneField.setBounds(140, 450, 224, 25);
        phoneField.setForeground(Color.gray);
        phoneField.setFont(new Font("SansSerif",Font.ITALIC,14));
        formPanel.add(phoneField);
        phoneField.addFocusListener(this);

        collegeLabel = new JLabel("College Name:");
        collegeLabel.setBounds(140, 490, 120, 25);
        collegeLabel.setForeground(labelColor);
        collegeLabel.setFont(new Font("SansSerif",Font.BOLD,16));       
        formPanel.add(collegeLabel);                                              //college label and college field
        collegeField = new JTextField(" College Name:");
        collegeField.setBounds(140, 520, 224, 25);
        collegeField.setForeground(Color.gray);
        collegeField.setFont(new Font("SansSerif",Font.ITALIC,14));
        formPanel.add(collegeField);
        collegeField.addFocusListener(this);

        cityLabel = new JLabel("City: ");            
        cityLabel.setBounds(140, 560, 100, 25);
        cityLabel.setForeground(labelColor);
        formPanel.add(cityLabel);   
        cityLabel.setFont(new Font("SansSerif",Font.BOLD,16));         //city label and city field
        cityField = new JTextField(" City:");  
        cityField.setBounds(140, 590, 224, 25);
        cityField.setForeground(Color.gray);
        cityField.setFont(new Font("SansSerif",Font.ITALIC,14));
        formPanel.add(cityField);
        cityField.addFocusListener(this);

        rounded_button submitButton = new rounded_button("Submit",30);
        submitButton.setBounds(200, 640, 100, 33); 
        Color buttonColor = new Color(166, 28, 245); // Purple     //submit button
        submitButton.setBackground(buttonColor); 
        submitButton.setForeground(Color.WHITE); 
        submitButton.setFont(new Font("SansSerif",Font.BOLD,16));
        formPanel.add(submitButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(95, 690, 400, 100);
        formPanel.add(resultArea);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        resultArea.setOpaque(false);
        resultArea.setFont(new Font("SanSerif",Font.BOLD,18));
        submitButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                StringBuilder errors = new StringBuilder();

                String name = nameField.getText().trim();
                 String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String college = collegeField.getText().trim();
                String city = cityField.getText().trim();

                // Validate inputs
                if (name.isEmpty() || name.equals("Full Name:")||name.equals("*Full Name is required."))
                {
                nameField.setForeground(Color.red);
                errors.append("");
                nameField.setText("*Full Name is required.");
                }
                if (!email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) 
                {
                emailField.setForeground(Color.red);
                errors.append(" ");
                emailField.setText("* Valid Gmail is required.");
                }
                if (!phone.matches("\\d{10}")) 
                {
                errors.append(" ");
                phoneField.setForeground(Color.red);
                phoneField.setText("*Phone number must be 10 digits.");
                }
                if (college.isEmpty() || college.equals("College Name:")||college.equals("*College is required."))
                {  
                collegeField.setForeground(Color.red);
                errors.append(" ");
                collegeField.setText("*College is required.");
                }
                if (city.isEmpty() || city.equals("City:")||city.equals("*City is required.") )
                {
                cityField.setForeground(Color.red);
                errors.append(" ");
                cityField.setText("*City is required.");
                }
                if(errors.length()>0)
                return; 
                resultArea.setText("Please wait.......");


                // Client-Server communication
                SwingUtilities.invokeLater(() -> {
                    try (Socket socket = new Socket("localhost", 5000);
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                        String message = name + "," + email + "," + phone + "," + college + "," + city;
                        out.println(message);

                        String response = in.readLine();
                        resultArea.setText(response);

         String url=new String("jdbc:mysql://localhost:3306/ca_onboarding");    //database code   
        String username=new String("root");
        String password=new String("qwaszx@lm10");

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("success");
        Connection con=DriverManager.getConnection(url,username,password);
        System.out.println("Connection esatablished successfully");
        
        PreparedStatement ps = con.prepareStatement(
  "INSERT INTO ca_applicants(full_name, email, phone, college, city) VALUES (?,?,?,?,?)");
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,phone);
        ps.setString(4,college);
        ps.setString(5,city);
       

        int i=ps.executeUpdate();
        if(i>0)
        {
            System.out.println("successfully inserted values in table");
    
        }
        else{
            System.out.println("failed to insert values in table");
        }
        ps.close();
        con.close();

                    } catch (Exception ex) {
                      
                        resultArea.setText(" Server connection failed.please try again!"); 
                        ex.printStackTrace();
                    }
                });
            }
        });

        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

     public void focusGained(FocusEvent fe)
     {
    JTextField field = (JTextField) fe.getSource();
    if (field.getForeground().equals(Color.GRAY)||field.getForeground().equals(Color.red)) {
        field.setText("");
        field.setForeground(Color.BLACK);
        if(field==nameField||field==emailField||field==phoneField||field==collegeField||field==cityField) 
        field.setFont(new Font("SansSerif",Font.PLAIN,14));
    }
    }
    public void focusLost(FocusEvent fe) 
     {
    JTextField field = (JTextField) fe.getSource();
    if (field.getText().trim().isEmpty()) 
    {
        field.setForeground(Color.GRAY);
    
        if (field == nameField)
        {    
             field.setFont(new Font("SansSerif",Font.ITALIC,14));
             field.setText(" Full Name:");

        } 
        else if (field == emailField) 
        {   
            field.setFont(new Font("SansSerif",Font.ITALIC,14));
            field.setText(" Email (Gmail):");
        }
        else if (field == phoneField)
        {
          field.setFont(new Font("SansSerif",Font.ITALIC,14));
          field.setText(" Phone Number:");
        }
        else if (field == collegeField) 
        {   
            field.setFont(new Font("SansSerif",Font.ITALIC,14));
            field.setText(" College Name:");
        }
        else if (field == cityField)
        {
        field.setFont(new Font("SansSerif",Font.ITALIC,14));
         field.setText(" City:");
        }
    } 
} 


     public static void main(String[] args) {
       new formUI_2();
    } 
}

     