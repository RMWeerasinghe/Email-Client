package EmailClient;
import java.io.*;
public class WriteToFile {
    /*this class handles the writing objects to a text file */

    public static void writeToFile(String fileName,String text){
        //static method to append to the given existing file 
        try{
            FileWriter filewriter=new FileWriter(fileName, true);
            BufferedWriter writer=new BufferedWriter(filewriter);
            writer.write("\n");
            writer.write(text);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
