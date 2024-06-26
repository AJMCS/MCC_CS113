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

    //Empty constructor version
    public void removeDocument ()
    {
        if(this.getQueueSize() == 0)
        {
            System.out.println("This Queue is currently Empty");
        }else
        {
            queue.poll();
        } 
    }

    
    public int getQueueSize()
    {
        return queue.size();
    }

    //prints doc and removes it. void method so it doesn't return anything anyway
    public String printDocument()
    {
        Document doc = queue.poll();
        return doc.toString();
    }

    //Returns queue. Useful for accessing queue methods from the PrinterQueue class level
    Queue<Document> getQueue()
    {
        for(int i = 0; i < this.getQueueSize(); i++)
        {
            System.out.println(queue.toArray()[i]);
        }
        return queue;
    }
}
