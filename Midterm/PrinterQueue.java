import java.util.Queue;
import java.util.LinkedList;
public class PrinterQueue 
{
    
    
    Queue<Document>  queue = new LinkedList<>();



public void addDocument(Document d)
{
    queue.add(d);
}


public void addDocument(String name, int pages)
{
    Document doc = new Document(name, pages);
    queue.add(doc);
}


public void removeDocument(Document d)
{
    queue.remove(d);
}

public void printDocument()
{
    System.out.println(queue.toArray()[0]);
    queue.poll();
}

public void removeDocument (String name, int pages)
{
    Document doc = new Document(name, pages);

    queue.remove(doc);
}

public int getQueueSize()
{
    return queue.size();
}

Queue<Document> getQueue()
{
    return this.queue;
}

}
