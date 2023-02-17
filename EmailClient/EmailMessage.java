package EmailClient;

import java.io.Serializable;
import java.time.LocalDate;
import javax.mail.Message;
import javax.mail.MessagingException;

public class EmailMessage implements Serializable{
    /*class to represent EmailMessage object */
    private String subject;
    private String email;
    private LocalDate sentdate;

    public EmailMessage(Message msg){
        
        try {
            this.subject=msg.getSubject();
            this.email=msg.getRecipients(Message.RecipientType.TO)[0].toString();
            this.sentdate=LocalDate.now();
        } catch (MessagingException e) {
            
            e.printStackTrace();
        }
    }

    public String getSubject(){
        return this.subject;
    }
    public String getAddress(){
        return this.email;
    }
    public LocalDate getSentdate(){
        return this.sentdate;
    }

}
