package CA_project_2;

import java.net.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;        
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println(" Server started. Waiting for clients...");

            while (true) {
                Socket client = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String data = in.readLine();  // format: name,email,phone,college,city
                String[] parts = data.split(",", -1); 
                if (parts.length != 5) {
                    out.println(" Invalid data format received.");
                    continue;
                }

                user2 user = new user2(parts[0], parts[1], parts[2], parts[3], parts[4]);
                String utmLink = generateUTMLink(user.getFullName());
                boolean sent = sendEmail(user.getEmail(), utmLink);

                if (sent) {
                   // out.println(" Email sent successfully to: " + user.getEmail());
                   out.println("Check your email for the UTM link.!");
                } else {
                    out.println(" Email sending failed.");
                }

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generateUTMLink(String name) {
        String baseUrl = "https://www.industryacademiacommunity.com/";
        String utmSource = "utm_source=" + name.trim().replaceAll(" ", "_").toLowerCase();
        String utmMedium = "utm_medium=email";
        String utmCampaign = "utm_campaign=ca_onboarding";
        return baseUrl + "?" + utmSource + "&" + utmMedium + "&" + utmCampaign;
    }

    public static boolean sendEmail(String to, String utmLink) {
        final String from = "9c.rohankerkar@gmail.com"; // <-- replace with your Gmail
        final String password = "qyozcrzltowtdvst"; // <-- replace with your App Password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Welcome - CA Onboarding UTM Link");
            message.setText(
                "Hi,\n\n" +
                "Welcome to the CA Onboarding program! \n\n" +
                "Here is your UTM link:\n" + utmLink + "\n\n" +
                "Please use this link while sharing to ensure your referrals are tracked.\n" +
                "If you have any questions, feel free to reach out to us.\n\n" +
                "Thanks,\nTeam"
            );

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
