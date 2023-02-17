package EmailClient;

import java.util.ArrayList;


public class Logger {
    /*logger class
     * store reciepients who have birthdays(Official friends and personal friends)
     */
    private ArrayList<IFriends> friendlist;
    private static final Logger logger=new Logger();

    private Logger(){
        this.friendlist=new ArrayList<IFriends>();
    }
    public static Logger getLog(){
        return logger;
    }
    public void addFriend(IFriends f){
        friendlist.add(f);
    }
    
    public ArrayList<IFriends> getFriends(){
        return logger.friendlist;
    }

}
