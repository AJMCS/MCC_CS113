import java.util.Scanner;
public class PrinterQueueDriver 
{ 
    public static void displayMenu(int[] options, String[] items)
        {
            System.out.println("Printer Queue Menu");
            System.out.println("==================");
            
            for(int i = 0; i < options.length; i++)
            {
                System.out.printf("%d. %s\n", options[i], items[i]);
            }
        }

    


    public static void main(String[] args) 
    {
       int userChoice = 0;
       int[] menuOptions = {1, 2, 3, 4, 5, 6, 7, 8};
       String[] menuItems = {"addDocument(E element)", "addDocument(String name, int pages)", "removeDocument(Document d)", "removeDocument()", "getQueueSize()", "printDocument()", "getQueue()", "Exit Program"};
       PrinterQueue queue = new PrinterQueue();
       int exit = menuOptions.length - 1;
       String docName = "";
       int docPages = 0;
       
       
       displayMenu(menuOptions, menuItems);

       Scanner keyboard = new Scanner(System.in);

       userChoice = keyboard.nextInt();
       keyboard.nextLine();

       while(userChoice != exit)
       {

        switch(userChoice)
        {
            case 1:
            System.out.println("---- " + menuItems[0] + " ----");

            System.out.println("Enter name of document:");
            docName = keyboard.nextLine();

            System.out.println("Enter page count of document:");
            docPages = keyboard.nextInt();

            Document d1 = new Document(docName, docPages);

            queue.addDocument(d1);
            System.out.println("The document has been added.");
            System.out.println("The size of the queue is now: " + queue.getQueueSize());
            System.out.println();
            break;



            case 2:
            System.out.println("---- " + menuItems[1] + " ----");

            System.out.println("Enter name of document:");
            docName = keyboard.nextLine();
            System.out.println("Enter page count of document:");
            docPages = keyboard.nextInt();

            queue.addDocument(docName, docPages);
            System.out.println("The document has been added.");
            System.out.println("The size of the queue is now: " + queue.getQueueSize());
            System.out.println();
            break;



            case 3:
            System.out.println("---- " + menuItems[2] + " ----");

            System.out.println("Enter name of document:");
            docName = keyboard.nextLine();
            System.out.println("Enter page count of document:");
            docPages = keyboard.nextInt();
            
            Document d2 = new Document(docName, docPages);
            queue.removeDocument(d2);
            System.out.println("The document has been removed.");
            System.out.println("The size of the queue is now: " + queue.getQueueSize());
            System.out.println();
            break;



            case 4:
            System.out.println("---- " + menuItems[3] + " ----");

            queue.removeDocument();
            System.out.println("The document has been removed.");
            System.out.println("The size of the queue is now: " + queue.getQueueSize());
            System.out.println();
            break;



           case 5:
           System.out.println("---- " + menuItems[4] + " ----");

           System.out.println("The size of the queue is: " + queue.getQueueSize());
           System.out.println();
           break;
            


           case 6:
           System.out.println("---- " + menuItems[5] + " ----");

           queue.printDocument();
           System.out.println();
           break;



           case 7:
           System.out.println("---- " + menuItems[6] + " ----");

           queue.getQueue();
           System.out.println();
           break;



           default:
           System.out.println("Invalid entry: Please try again.");
           System.out.println();

        }

        displayMenu(menuOptions, menuItems);

        userChoice = keyboard.nextInt();
        keyboard.nextLine();

        if(userChoice == 8)
        {
            System.out.println("---- " + menuItems[7] + " ----");
            System.out.println("Ending Program...");
        }
        
        
       }
       keyboard.close();

    
    }
}
