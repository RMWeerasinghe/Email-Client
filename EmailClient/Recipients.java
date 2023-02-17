package EmailClient;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

abstract class Recipients  {
    /*abstract class for reciepints */
    private String name;
    private InternetAddress emailAddress;
    private static int count=0;
    
    public Recipients(String name,String mail){
        try{
            this.name=name;
            this.emailAddress=new InternetAddress(mail);
            count++;
        }
        catch (AddressException e){
            System.out.println("Invalid mail address");
            e.printStackTrace();
        }
    }

    public String getName(){
        return this.name;
    }
    public InternetAddress getMail(){
        return this.emailAddress;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMail(String mail){
        try{
            this.emailAddress=new InternetAddress(mail);
        }
        catch (AddressException e){
            System.out.println("Invalid mail address");
            e.printStackTrace();
        }
    }
    public static int getCount(){
        return count;
    }

    
    
}