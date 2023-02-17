package EmailClient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Email_Client {
    //Class to represent Email client objects
    private static final MyMail account=MyMail.getAccount();
    public Logger log=Logger.getLog();
    private static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");

    //1.method to create recipients according to the recipients list 
    public void createRecipents(){
        ReadFromFile.readFromFile("clientList.txt");
    }
    //2.method to add new recipients
    public void addRecipients(String inputString){
        Factory creator=new Factory();
        creator.createRecipients(inputString);
        WriteToFile.writeToFile("clientList.txt",inputString);
    }
    //3.method to send birthday wishes to friends who have birthdays today
    public void sendBirthdayWishes(){
        
        LocalDate today=LocalDate.now();
        int k=log.getFriends().size();
            
    
        for (int i=0;i<k;i++){
            IFriends friend=log.getFriends().get(i);
            String text=null;
            InternetAddress mail=null;
            if ((friend.getBday().getMonthValue()==today.getMonthValue()) && (friend.getBday().getDayOfMonth()==today.getDayOfMonth())){
                if (friend instanceof OfficialFriend){
                    mail=((OfficialFriend)friend).getMail();
                    text="Wish you a Happy Birthday.\nRavindi Weerasinghe";
                }
                else{
                    mail=((Personal)friend).getMail();
                    text="Hugs and love on your birthday.\nRavindi Weerasinghe"; 
                }
                account.send(mail, "Happy Birthday", text);
            }
           
        }
    }
    //4.method to send an email
    public void sendMail(String reciever,String subject,String text){
        try{
            InternetAddress to=new InternetAddress(reciever);
            account.send(to, subject, text);
        }
        catch (AddressException e){
            e.printStackTrace();
        }
        
    }
    //5.method to print list of friends who have birthdays on a given date
    
    public void printFriends(String inputdate){
        Logger log=Logger.getLog();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date=LocalDate.parse(inputdate, formatter);
        ArrayList<IFriends> friends=log.getFriends();
        int k=friends.size();
        for(int i=0;i<k;i++){
            if ((friends.get(i).getBday().getDayOfMonth()==date.getDayOfMonth()) &&(friends.get(i).getBday().getMonthValue()==date.getMonthValue())){
                friends.get(i).printDetails();
            }
        }
    }
    

    //6.method to print the number of recipients
    public void getCount(){
        int count=Recipients.getCount();
        System.out.printf("Number of Recipients: %d",count);
        
    }

    //7.method to store messages-serialize - to the file Messages.ser
    public void store (SentBox sentbox){
        FileOutputStream filestream;
        try {
            filestream = new FileOutputStream("Messages.ser");
            ObjectOutputStream os = new ObjectOutputStream(filestream);
            os.writeObject(sentbox);
            os.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }

    //8.method to retrieve sentbox from Messages.ser and return the sent box 
    public ArrayList<EmailMessage> retrieve(){
        FileInputStream filestream=null;
        ObjectInputStream os = null;
        ArrayList<EmailMessage> sentlist=null;

        try{
            filestream=new FileInputStream("Messages.ser");
            os=new ObjectInputStream(filestream);
            SentBox sent=(SentBox) os.readObject();
            sentlist=sent.getSent();

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally{
            if (os!=null){
                try {
                    os.close();
                } catch (IOException c) {
                    os=null;
                    c.printStackTrace();
                }   
            }

        }
        return sentlist;

    }
    //9.method to update (set) the sentbox
    public void setSentBox(){
        ArrayList<EmailMessage> sentbefore=this.retrieve();
        if (sentbefore!=null){
            SentBox.getSentbox().setSent(sentbefore);
        }
        else{
            return;
        }
        
    }

    //10.method to print details of emails sent on given date
    public void sentMessages(String inputdate){
        LocalDate givdDate=LocalDate.parse(inputdate, formatter);
        ArrayList<EmailMessage> sent=SentBox.getSentbox().getSent();
        

        int k=sent.size();

        for(int i=0;i<k;i++){
            EmailMessage msg=sent.get(i);
            if ((msg.getSentdate().toString()).equals(givdDate.toString())){
                String subject=msg.getSubject();
                String reciever=msg.getAddress();

                System.out.printf("sent to: \t%s\nsubject: \t%s\n",reciever,subject);
            }
            
        }
        
    }


}
