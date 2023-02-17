package EmailClient;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MyMail {
    /*class to send emails via my email account 
     * this class represents the user email account
        */
    protected InternetAddress mail;
    protected String password;
    protected String username;
    private Properties prop;
    private static final MyMail account=new MyMail();

    private MyMail(){
        try{
            this.mail=new InternetAddress("assignment200700b@gmail.com");  //user email address
        }
        catch(AddressException e){
            e.printStackTrace();
        }
        this.password="clbsnuqxvmnbjsbu";  //password
        this.username="assignment200700b@gmail.com";  //user name
        this.prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");
        
    }
    public static MyMail getAccount(){
        return account;
    }


    public void send(InternetAddress to,String subject,String text){
        
        //method to send emails from my mail account
        Session session = Session.getInstance(prop,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(account.username, account.password);
         }
      });

      try {
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(account.mail);

        // Set To: header field of the header.
        message.setRecipient(Message.RecipientType.TO,to);
       
        // Set Subject: header field
        message.setSubject(subject);

        // Now set the actual message
        message.setText(text);

        // Send message
        Transport.send(message);
        
        //create EmailMessge object to store the details of the sent mail
        EmailMessage email=new EmailMessage(message); 
        SentBox.getSentbox().add(email);   //add to the sent box
        System.out.println("Sent message successfully....");

     } catch (MessagingException e) {
           throw new RuntimeException(e);
     }
  

    }




   
}
