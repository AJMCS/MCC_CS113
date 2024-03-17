public class PrinterQueueDriver 
{ 
    public static void main(String[] args) 
    {
        System.out.println("Driver for PrinterQueue Class\n\n");

        Document doc1 = new Document();
        Document doc2 = new Document("Starbucks Receipt", 1);
        Document doc3 = new Document (3);

        System.out.println("Three new documents have been created:\n");
        System.out.println(doc1);
        System.out.println(doc2);
        System.out.println(doc3);
        System.out.println();

        doc1.setName("W-2 Tax form");
        doc1.setPages(2);

        System.out.println("First document renamed by setting name and pages using set Methods:");
        System.out.println(doc1);
        System.out.println(doc2);
        System.out.println(doc3);
        System.out.println();

        System.out.println("Created a copy of the third document:");
        Document doc4 = new Document(doc3);
        System.out.println(doc4);
        System.out.println();

        System.out.println("renaming the 3rd document copy:");
        doc4.setName("Coding Resume");
        System.out.println(doc4);
        System.out.println();

        PrinterQueue q = new PrinterQueue();

        q.addDocument(doc1);
        q.addDocument(doc2);
        q.addDocument(doc3);
        q.addDocument(doc4);
        System.out.println("\nSuccessfully created a queue and added all four documents to it.");
        System.out.println("The size of the printer queue is " + q.getQueueSize());
        System.out.println();

        q.addDocument("1099 Tax Form", 1);
        System.out.println("Used the add document method to create and add a document to the queue.");
        System.out.println("The size of the printer queue is " + q.getQueueSize());
        System.out.println();


        System.out.println("Here is the printer queue: ");

        q.getQueue();






    }
}
