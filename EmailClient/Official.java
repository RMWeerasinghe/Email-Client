package EmailClient;

public class Official extends Recipients {
    /*concrete Official recipients class */
    private String designation;

    public Official(String name,String mail,String designation){
        /*constructer */
        super(name,mail);
        this.designation=designation;
    }

    public void setDesignation(String des){
        this.designation=des;
    }
    public String getDesignation(){
        return this.designation;
    }
    
    public static void create(String details) {
        /*Method to create reciepients using single line input  */
        String[] info=details.split(",",3);
        String name=info[0];
        String mail=info[1];
        String designation=info[2];
        new Official(name, mail, designation);
        
    }
    

}
