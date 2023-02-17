package EmailClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface IFriends {
    //interface for objects who have a birthday
    public final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public void setBday(String date);
    public LocalDate getBday();   
    public void printDetails();
}
