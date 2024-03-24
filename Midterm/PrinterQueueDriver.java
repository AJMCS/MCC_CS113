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

       while(userChoice != exit)
       {

        switch(userChoice)
        {
            case 1:

            System.out.println("Enter name of document:");
            docName = keyboard.nextLine();
            System.out.println("Enter page count of document:");
            docPages = keyboard.nextInt();

            Document d = new Document(docName, docPages);

            queue.addDocument(d);
            break;

            case 2:
            
            System.out.println("Enter name of document:");
            docName = keyboard.nextLine();
            System.out.println("Enter page count of document:");
            docPages = keyboard.nextInt();

            queue.addDocument(docName, docPages);

        }


       }





















       
       
        System.out.println("Driver for PrinterQueue Class\n\n");

        //Create documents using all three constructors for the documents class
        Document doc1 = new Document();
        Document doc2 = new Document("Starbucks Receipt", 1);
        Document doc3 = new Document (3);

        //Print documents
        System.out.println("Three new documents have been created:\n");
        System.out.println(doc1);
        System.out.println(doc2);
        System.out.println(doc3);
        System.out.println();

        //Rename doc1 using setters
        doc1.setName("W-2 Tax form");
        doc1.setPages(2);

        //Print results
        System.out.println("First document renamed by setting name and pages using set Methods:");
        System.out.println(doc1);
        System.out.println(doc2);
        System.out.println(doc3);
        System.out.println();

        //use object constructor for document class
        System.out.println("Created a copy of the third document:");
        Document doc4 = new Document(doc3);
        System.out.println(doc4);
        System.out.println();

        //Give it a new name
        System.out.println("renaming the 3rd document copy:");
        doc4.setName("Coding Resume");
        System.out.println(doc4);
        System.out.println();

        //Create PrinterQueue object
        PrinterQueue q = new PrinterQueue();

        //Add our documents to object
        q.addDocument(doc1);
        q.addDocument(doc2);
        q.addDocument(doc3);
        q.addDocument(doc4);


        //Print out size using getQueueSize() method 
        System.out.println("\nSuccessfully created a queue and added all four documents to it.");
        System.out.println("The size of the printer queue is " + q.getQueueSize());
        System.out.println();

        //Add new document to queue using name and pages constructor
        q.addDocument("1099 Tax Form", 1);
        System.out.println("Used the add document method to create and add a document to the queue.");
        System.out.println("The size of the printer queue is " + q.getQueueSize());
        System.out.println();

        //Print document to the user
        System.out.println("Printing document:");
        q.printDocument();

        System.out.println("The size of the queue is now: " + q.getQueueSize());

        //Remove Document 3 using element constructor of the remove method
        q.removeDocument(doc3);
        System.out.println("Doc3 has been removed.");


        //Return the queue of documents to the user
        System.out.println("Here is the printer queue: ");
        q.getQueue();






        

    }
}
