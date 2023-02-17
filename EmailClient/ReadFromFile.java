package EmailClient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    /*this class handles reading files */
    
    public static void readFromFile(String fileName){
        //static method to read from given file
        Factory factory = new Factory(); {
            
        };
        try{
            FileReader filereader = new FileReader(fileName);
            BufferedReader reader =new BufferedReader(filereader);
            String line=null;
            while ((line = reader.readLine()) != null) {
                factory.createRecipients(line);
            }  
            reader.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }


    
}
