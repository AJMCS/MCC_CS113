import java.util.Queue;
import java.util.LinkedList;
public class PrinterQueue 
{
    
    //Instantiate private queue
    private Queue<Document>  queue = new LinkedList<>();


    //Object constructor for addDoc method
    public void addDocument(Document d)
    {
        queue.add(d);
    }

    //Full Constructor for addDoc method
    public void addDocument(String name, int pages)
    {
            Document doc = new Document(name, pages);
            queue.add(doc); 
    }


    //Object constructor version
    public void removeDocument(Document d)
    {
        queue.remove(d);
    }


    //Empty constructor version
    public void removeDocument ()
    {
        queue.poll();
    }

    
    public int getQueueSize()
    {
        return queue.size();
    }

    //prints doc and removes it. void method so it doesn't return anything anyway
    public void printDocument()
    {
        queue.poll();
    }

    //Returns queue. Useful for accessing queue methods from the PrinterQueue class level
    Queue<Document> getQueue()
    {
        return this.queue;
    }

}
