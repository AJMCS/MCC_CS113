import org.junit.*;
import java.util.Queue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.LinkedList;

public class PrinterQueueTest 
{
    PrinterQueue queue = new PrinterQueue();

    //Instantiate some documents to reference in tests
    Document doc1 = new Document("Doc1", 1);
    Document doc2 = new Document(2);
    Document doc3 = new Document();
    Document doc4 = new Document("Doc4",3);
    Document doc5 = new Document("Doc5", 10);
    Document doc6 = new Document(1);
    Document doc7 = new Document();
    Document doc8 = new Document("Doc8", 13);
    Document doc9 = new Document("Doc9", 1);
    Document doc10 = new Document("Doc10", 10);
    
    


    @Test
    public void addDocumentTest()
    {
        //Instantiate a queue
        PrinterQueue queue = new PrinterQueue();

        //Make some document objects
        Document doc1 = new Document();
        Document doc2 = new Document( 1);
        Document doc3 = new Document(0);
        Document doc4 = new Document(-7);

        //Check if queue size initialized at 0
        Assert.assertEquals(0, queue.getQueueSize());
        
        //check if queue size icreases when using the add method
        queue.addDocument(doc1);
        Assert.assertEquals(1, queue.getQueueSize());

        queue.addDocument(doc2);
        Assert.assertEquals(2, queue.getQueueSize());
    }

    @Test
    public void addDocumentNoNameTest()
    {
        //Instantiate a queue
        PrinterQueue queue = new PrinterQueue();

        queue.addDocument(doc3);
        queue.addDocument(doc2);

        //Check document made in empty contructor has "New Document" title
        Assert.assertEquals("New Document", queue.getQueue().peek().getName());
        queue.removeDocument();
        
        Assert.assertEquals("Untitled", queue.getQueue().peek().getName());
        queue.removeDocument();

    
    }

    @Test
    public void DocumentThrowExceptionTest()
    {
       
        //check if an exception is thrown when trying to create a document with 0 pages
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            Document doc3 = new Document(0);
        });

        //Check if we received the correct exception text
        assertEquals("The number of pages cannot be less the or equal to zero.", exception.getMessage());


        //Check if an exceptio is thrown when trying to add a document with negative pages
        exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            Document doc4 = new Document(-7);
        });
        //Check if we received the correct exception text
        assertEquals("The number of pages cannot be less the or equal to zero.", exception.getMessage());

        
    }

    @Test
    public void removeDocumentTest()
    {
        //Instantiate a queue
        PrinterQueue queue = new PrinterQueue();
        
        //Make some document objects
        Document doc1 = new Document("Doc1", 1);
        Document doc2 = new Document(2);
        Document doc3 = new Document();
        Document doc4 = new Document("Doc4",3);
        Document doc5 = new Document("Doc5", 10);

        //Add docs to queue
        queue.addDocument(doc1);
        queue.addDocument(doc2);
        queue.addDocument(doc3);
        queue.addDocument(doc4);
        queue.addDocument(doc5);

        
        queue.removeDocument();
        //Check if the size of the queue decreased
        Assert.assertEquals(4, queue.getQueueSize());
        //Check if removed doc still exists in queue
        Assert.assertFalse(queue.getQueue().contains(doc1));
        //Status of Queue: [Doc2, Doc3, Doc4, Doc5]

        
        queue.removeDocument(doc3);
        //Check if the size of the queue decreased
        Assert.assertEquals(3, queue.getQueueSize());
        //Check if removed doc still exists in queue
        Assert.assertFalse(queue.getQueue().contains(doc3));
        //Status of Queue: [Doc2,Doc4, Doc5]


    }

    @Test
    public void removeDocumentOrderTest()
    {
        //Instantiate a queue
        PrinterQueue queue = new PrinterQueue();
        
        //Make some document objects
        Document doc1 = new Document("Doc1", 1);
        Document doc2 = new Document(2);
        Document doc3 = new Document();
        Document doc4 = new Document("Doc4",3);
        Document doc5 = new Document("Doc5", 10);

        //Add docs to queue
        queue.addDocument(doc1);
        queue.addDocument(doc2);
        queue.addDocument(doc3);
        queue.addDocument(doc4);
        queue.addDocument(doc5);

        
        queue.removeDocument();

        //Doc2 should be at the head of the queue
        Assert.assertEquals(doc2, queue.getQueue().toArray()[0]);
        //Status of Queue: [Doc2, Doc3, Doc4, Doc5]

        
        queue.removeDocument(doc3);

        //Doc4 should now be located at index 2
        Assert.assertEquals(doc4, queue.getQueue().toArray()[1]);
        //Status of Queue: [Doc2,Doc4, Doc5]


    }

    @Test
    public void printDocumentTest() 
    {
        
        PrinterQueue queue = new PrinterQueue();
    
        //Add documents tob queue
        queue.addDocument(doc8);
        queue.addDocument(doc10);
    
        //Print document
        queue.printDocument();

        //Check if a document was removed; size of queue decrease
        Assert.assertEquals(1, queue.getQueueSize());
        //Check if doc10 is still in the queue; that queue removed the correct document
        Assert.assertEquals(doc10, queue.getQueue().peek());
    }

    @Test
    public void getQueueSizeTestEmptyQueue()
    {
        //Instantiate PrinterQueue object
        PrinterQueue queue = new PrinterQueue();
        Assert.assertEquals(0, queue.getQueueSize());
    }

    @Test
    public void getQueueSizeAfterAddingTest()
    {
        //Instantiate PrinterQueue object
        PrinterQueue queue = new PrinterQueue();
        
        //Add documents to queue
        queue.addDocument(doc1);
        queue.addDocument(doc2);
        queue.addDocument(doc3);
        queue.addDocument(doc4);
        queue.addDocument(doc5);
        queue.addDocument(doc6);
        queue.addDocument(doc7);
        queue.addDocument(doc8);

        //Check if return of the method matches the number of documents you added.
        Assert.assertEquals(8, queue.getQueueSize());
    }

    @Test
    public void getQueueSizeAfterRemovalTest()
    {
        //Instantiate PrinterQueue object
        PrinterQueue queue = new PrinterQueue();
        
        //Add documents to queue
        queue.addDocument(doc1);
        queue.addDocument(doc2);
        queue.addDocument(doc3);
        queue.addDocument(doc4);

        //Check if return of the method matches the number of documents you added.
        Assert.assertEquals(4, queue.getQueueSize());
        
        //Check if queue size reflects the absence of the doc removed.
        queue.removeDocument();
        Assert.assertEquals(3, queue.getQueueSize());
    }

    @Test
    public void getQueueTest()
    {
        //instantiate a PrinterQueue object and a queue
        PrinterQueue queue = new PrinterQueue();
        Queue<Document> q = new LinkedList<>();

        //Add Documents to Queue Directly
        q.add(doc1);
        q.add(doc2);
        q.add(doc3);

        //Add documents to through PrinterQueue Class
        queue.addDocument(doc1);
        queue.addDocument(doc2);
        queue.addDocument(doc3);

        //Check if both the queue made directly has the same size as the queue made from PrinterQueue class
        Assert.assertEquals(q.size(), queue.getQueue().size());

        //Check that both queues have the same contents:
        Assert.assertEquals(q.contains(doc1),queue.getQueue().contains(doc1));
        Assert.assertEquals(q.contains(doc2),queue.getQueue().contains(doc2));
        Assert.assertEquals(q.contains(doc3),queue.getQueue().contains(doc3));

        //Check that the documents in the queues are in the same order
        Assert.assertEquals(q.toArray()[0],queue.getQueue().toArray()[0]);
        Assert.assertEquals(q.toArray()[1],queue.getQueue().toArray()[1]);
        Assert.assertEquals(q.toArray()[2],queue.getQueue().toArray()[2]);
        
        
    }
}
