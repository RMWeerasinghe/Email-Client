package EmailClient;

import java.io.Serializable;
import java.util.ArrayList;

public class SentBox implements Serializable {
    private ArrayList<EmailMessage> sent;
    private static final SentBox INSTANCE_SENT_BOX=new SentBox();

    private SentBox(){
        this.sent=new ArrayList<EmailMessage>();
    }
    public void add(EmailMessage email){
        sent.add(email);
    }
    public static SentBox getSentbox(){
        return INSTANCE_SENT_BOX;
    }
    public ArrayList<EmailMessage> getSent(){
        return sent;
    }
    public void setSent(ArrayList<EmailMessage> sent1){
        this.sent=sent1;
    }

    
}
