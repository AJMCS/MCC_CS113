import org.junit.*;
import java.util.Queue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.LinkedList;

public class PrinterQueueTest 
{
   
    public static final Document[] DOCUMENTS = {

        new Document(),
        new Document(2),
        new Document("Doc3", 1),
        new Document("Doc4",3),
        new Document("Doc5", 10)

    };



    public static final Document[] NO_NAME_DOCUMENTS = 
    {
        new Document(),
        new Document(),
        new Document(2),
        new Document(500)
    };
    


    public static final int[] INVALID_PAGES = {0, -1, -7, -2000};





    @Test
    public void addDocumentTest()
    {
        PrinterQueue queue = new PrinterQueue();

        for(int i = 0; i < DOCUMENTS.length; i++)
        {
            //Add Document to Queue
            queue.addDocument(DOCUMENTS[i]);

            //Ensures size changes with added docs
            Assert.assertEquals(i+1, queue.getQueueSize()); 
        }
    }


    @Test
    public void addDocumentNoNameTest()
    {
        PrinterQueue queue = new PrinterQueue();

        for(int i = 0; i < NO_NAME_DOCUMENTS.length; i++)
        {    
            //Add Documents to Queue
            queue.addDocument(NO_NAME_DOCUMENTS[i]);

            //Name of initialized doc is Unititled
            Assert.assertEquals("Untitled", queue.getQueue().peek().getName()); 
        }
    }

    
    @Test
    public void DocumentThrowExceptionTest()
    {
        //check if an exception is thrown when trying to create a document with invalid number of pages
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            for(int i = 0; i < INVALID_PAGES.length; i++)
                {
                    new Document(INVALID_PAGES[i]); 
                }
            
        });

        //Check if we received the correct exception text
        assertEquals("The number of pages cannot be less the or equal to zero.", exception.getMessage());
    }


    @Test
    public void removeDocumentTest()
    {
        PrinterQueue queue = new PrinterQueue();
        

        //Add Document to Queue
        for(int i = 0; i < DOCUMENTS.length; i++)
        {  
            queue.addDocument(DOCUMENTS[i]);
        }

        
        for(int i = DOCUMENTS.length - 1 ; i >= 0; i--)
        {
            //Add Document to Queue
            queue.removeDocument();

            //Check if queue decreased in size.
            Assert.assertEquals(i, queue.getQueueSize());
        }
    }


    @Test
    public void removeDocumentOrderTest()
    {
        PrinterQueue queue = new PrinterQueue();
        

        for(int i = 0; i < DOCUMENTS.length; i++)
        {
            //Add Document to Queue
            queue.addDocument(DOCUMENTS[i]);
        }
        
        queue.removeDocument();

        //Second element of DOCUMENTS[] should be at the front of the queue
        Assert.assertEquals(DOCUMENTS[1], queue.getQueue().toArray()[0]);
    }


    @Test
    public void printDocumentTest() 
    {
        PrinterQueue queue = new PrinterQueue();

        
        for(int i = 0; i < DOCUMENTS.length; i++)
        {
            //Add Document to Queue
            queue.addDocument(DOCUMENTS[i]);

            //Checks if the correct toString was returned
            Assert.assertEquals(DOCUMENTS[i].toString(), queue.printDocument());

            //Checks if document was removed from the queue
            //Should always be equal to 0 since I add and then remove document by printing it.
            Assert.assertEquals(0, queue.getQueueSize());  
        }
    }


    @Test
    public void getQueueSizeTestEmptyQueue()
    {
        //Instantiate PrinterQueue object
        PrinterQueue queue = new PrinterQueue();
        
        //Check if queue is enpty upon initialization
        Assert.assertEquals(0, queue.getQueueSize());
    }


    @Test
    public void getQueueTest()
    {
        //instantiate a PrinterQueue object and a queue
        PrinterQueue queue = new PrinterQueue();
        Queue<Document> q = new LinkedList<>();

        for(int i = 0; i < DOCUMENTS.length; i++)
        {
            //Add Document to Queue and LinkedList
            queue.addDocument(DOCUMENTS[i]);
            q.add(DOCUMENTS[i]);

            //Check if both the queue made directly has the same size as the queue made from PrinterQueue class
            Assert.assertEquals(q.size(), queue.getQueue().size());

            //Check that both queues have the same contents:
            Assert.assertEquals(q.contains(DOCUMENTS[i]),queue.getQueue().contains(DOCUMENTS[i])); 

            //Check that the documents in the queues are in the same order
            Assert.assertEquals(q.toArray()[i],queue.getQueue().toArray()[i]);
        }  
    }
}
