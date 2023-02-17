package EmailClient;

import java.time.LocalDate;

public class OfficialFriend extends Official implements IFriends{
    /*concrete class for Official Friend recipients */
    private LocalDate birthday;


    public OfficialFriend(String name,String mail,String designation,String birthday){
        super(name,mail,designation);
        this.birthday=LocalDate.parse(birthday,formatter);
  
    }
    
    public static void create(String details) {
        /*method to create Official Friend objects using single line string input  */
        String[] info=details.split(",",4);
        String name=info[0];
        String mail=info[1];
        String designation=info[2];
        String birthday=info[3];
        Logger log=Logger.getLog();
        OfficialFriend offFriend=new OfficialFriend(name, mail, designation,birthday);
        log.addFriend(offFriend);        
    }

    @Override
    public void setBday(String date) {
        this.birthday=LocalDate.parse(date,formatter);
    }

    @Override
    public LocalDate getBday() {
        
        return this.birthday;
    }
    

    @Override
    public void printDetails() {
        //method to print details
        String name=this.getName();
        String des=this.getDesignation();
        String mail=this.getMail().toString();
        String date=this.birthday.toString();

        System.out.printf("Official_friend: %s,%s,%s,%s \n", name,mail,des,date);
      
    }

}
