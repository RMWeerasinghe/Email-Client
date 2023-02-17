// 200700B

//import libraries
package EmailClient;

import java.util.Scanner;

public class EmailClientDemo {

    public static void main(String[] args) throws InterruptedException {
        Email_Client client=new Email_Client();
        //retrieve previous messages
        client.setSentBox();
        //create objects
        client.createRecipents();
        //send birthday wishes
        client.sendBirthdayWishes();
       


        Scanner scanner = new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

          int option = scanner.nextInt();

          switch(option){
                case 1:
                    // input format - Official: nimal,nimal@gmail.com,ceo
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file
                    // Hint: use methods for reading and writing files
                    String inputString=scanner2.nextLine();
                    client.addRecipients(inputString);

                    break;
                case 2:
                    // input format - email, subject, content
                    // code to send an email
                    System.out.println("Enter senders email address: ");
                    String reciever=scanner2.nextLine();
                    System.out.println("Enter subject: ");
                    String subject=scanner2.nextLine();
                    System.out.println("Enter Message: ");
                    String content=scanner2.nextLine();
                    client.sendMail(reciever, subject, content);
                    
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    System.out.println("Enter date: yyyy/MM/dd");
                    String inputdate=scanner2.nextLine();
                    client.printFriends(inputdate);
                    
                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    System.out.println("Enter Date: yyyy/MM/dd");
                    String input=scanner2.nextLine();
                    client.sentMessages(input);
                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    client.getCount();
                    break;

          }
          scanner.close();
          scanner2.close();
          
          client.store(SentBox.getSentbox());

      }
}
