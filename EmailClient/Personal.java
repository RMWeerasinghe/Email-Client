package EmailClient;
import java.time.LocalDate;




public class Personal extends Recipients implements IFriends {
    /*concrete class for Personal Recipients */
    private LocalDate birthDay;
    private String nickname;
    
    public Personal(String name,String nickname,String mail,String date){
        super(name,mail);
        this.birthDay=LocalDate.parse(date,formatter);
        this.nickname=nickname;
    }
    public void setnickN(String nick){
        this.nickname=nick;
    }
    public String getnickN(){
        return this.nickname;
    }

    
    public void setBday(String date){
        this.birthDay=LocalDate.parse(date, formatter);
    }
    public LocalDate getBday(){
        return this.birthDay;
    }
    
    public static void create(String details) {
        /*method to create Personal Recipients using single line string input */
        String[] info=details.split(",",4);
        String name=info[0];
        String nickname=info[1];
        String mail=info[2];
        String birthday=info[3];
        
        Personal person1=new Personal(name,nickname,mail,birthday);
        Logger log=Logger.getLog();
        log.addFriend(person1);
    

        
    
    }
    
    
    @Override
    public void printDetails() {
        //method to print details
        String name=this.getName();
        String nickn=this.getnickN();
        String mail=this.getMail().toString();
        String date=this.birthDay.toString();

        System.out.printf("Personal: %s,%s,%s,%s \n", name,nickn,mail,date);
      
    }
}
