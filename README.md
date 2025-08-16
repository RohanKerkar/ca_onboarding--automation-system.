# ca_onboarding--automation-system.
Java Swing Client-Server project for Community Ambassador onboarding

📂 src   → all Java source files  
📂 lib   → external libraries (jars)  
📄 README.md → project instructions  


# CA Onboarding Automation System

A Java Swing Client-Server application that automates the onboarding process of Community Ambassadors (CA). The system generates UTM links, sends them via email, and manages applicant details.

---

## 📂 Project Structure
ca_onboarding--automation-system/
│
├── src/   → contains all Java source files
│     ├── FormUI.java
│     ├── Server.java
│     └── User.java
│
├── lib/   → contains required external JAR files
│     ├── mail.jar
│     ├── activation.jar
│     ├── mysql-connector.jar
│     └── other-libraries.jar
│
└── README.md

---

## ⚡ Features
- Java Swing form (FormUI.java) to collect applicant data: Full Name, Email, Phone, College, City  
- Server (Server.java) generates a unique UTM link for each applicant  
- Emails the UTM link to the applicant using JavaMail API  
- Uses socket communication between client and server  
- Database integration (Supabase/MySQL) for storing applicant data  

---

## ▶️ How to Compile and Run

1. Open terminal inside the project folder.  
2. Compile all source files with libraries:  
   - On Windows:  
     javac -cp ".;lib/*" src/*.java  
   - On Linux/Mac:  
     javac -cp ".:lib/*" src/*.java  
3. Run the Server:  
   java -cp ".;lib/*" src.Server  
4. Run the Client (Form):  
   java -cp ".;lib/*" src.FormUI  

---

## 🔑 Configuration Notes

This project does not include real credentials.  
Before running, open **Server.java** and replace placeholders with your own:  

- Gmail SMTP setup  
  final String senderEmail = "ENTER_YOUR_EMAIL";  
  final String appPassword = "ENTER_YOUR_APP_PASSWORD";  

- Database setup  
  String dbPassword = "ENTER_DB_PASSWORD";  

⚠️ **Important Notes**:  
- Internet connection is required for email transfer.  
- Ensure JavaMail API is properly configured (mail.jar + activation.jar should be inside the `lib/` folder and added to the classpath).  

Without adding these, email sending and DB integration will not work.  

---

## 📅 Project Timeline
- Start Date: 7 June 2025  
- End Date: 16 AUgust 2025  

---

👨‍💻 Developed by: Rohan Kerkar
