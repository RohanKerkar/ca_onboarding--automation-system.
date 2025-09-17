package CA_project_2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Dashboard extends JFrame {

    JTable table;
    DefaultTableModel model;

    public Dashboard() {
        setTitle("Dashboard - Applicants");
        setSize(800, 400);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table setup
        model = new DefaultTableModel();
        model.addColumn("Full Name");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("College");
        model.addColumn("City");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Fetch data from MySQL
        fetchData();
    }

    private void fetchData() {
        String url = "jdbc:mysql://localhost:3306/ca_onboarding"; // replace with your DB name
        String user = "root"; // replace with your MySQL username
        String pass = "qwaszx@lm10"; // replace with your MySQL password

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT full_name, email, phone, college, city FROM ca_applicants");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("college"),
                        rs.getString("city")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace(); // prints error in console
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }

               addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
        new AdminLogin().setVisible(true); 
    }
});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          
            new Dashboard().setVisible(true);
        });
    }
}
