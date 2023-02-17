package EmailClient;
public class Factory {
    /*class to handle the creaton of new objects  */
    public void createRecipients(String details){
        /*factory method for creating recipients */
        String type=details.split(": ",2)[0];
        String info=details.split(": ",2)[1];

        if (type.equalsIgnoreCase("official")){
            
            Official.create(info);
        }
        else if(type.equalsIgnoreCase("official_friend")){
            
            OfficialFriend.create(info);
        }
        else if(type.equalsIgnoreCase("Personal")){
            
            Personal.create(info);
        }
    }
}
