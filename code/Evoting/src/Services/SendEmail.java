package Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
    public static String success="y";
    public static void send(String to,String subject,String msg) {
      // Recipient's email ID needs to be mentioned.
      // Sender's email ID needs to be mentioned
    	
      success="n";
      
      try {
      InputStream input = SendEmail.class.getClassLoader().getResourceAsStream("emailconfig.properties");   
	  Properties p=new Properties();  
	  p.load(input);
	  String from = p.getProperty("emailfrom");
      final String username = from;//change accordingly
      final String password = p.getProperty("emailpass");//change accordingly


      // Assuming you are sending email through gmail
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject(subject);
	
	   // Now set the actual message
	   message.setText(msg);

	   // Send message
	   Transport.send(message);

	   System.out.println("Message sent successfully....");
           success="y";

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}