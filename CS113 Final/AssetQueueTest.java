import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Queue;

public class AssetQueueTest 
{
    
    @Test
    public void addAssetTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue
        Asset a1 = new Asset("test", 1); //create asset
        q.addAsset(a1); //add asset to queue

        //Check if size was increased
        assertEquals(1, q.getQueueSize()); 

        //Check all data structures to see if it was added
        assertTrue(q.getSortedAssets().contains(a1));
        assertTrue(q.getAssetMap().containsKey(a1.getName()));
        assertTrue(q.getAssetNames().contains(a1.getName()));
        assertTrue(q.getAssetTree().contains(a1));
        assertTrue(q.getPriorityQueue().contains(a1));
        assertTrue(q.getQueue().contains(a1));

    }


    @Test
    public void addCopiesTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset a1 = new Asset("test1", 1); //Create asset1

        //Add assets to queue
        q.addAsset(a1);
        q.addAsset(a1);
        q.addAsset(a1);

        //Check if size is equal to 1
        assertEquals(1, q.getQueueSize());

        //Check all data structures to see if it's size reflects only one asset in the queue
        assertEquals(1, q.getSortedAssets().size());
        assertEquals(1, q.getAssetMap().size());
        assertEquals(1, q.getAssetNames().size());
        assertEquals(1, q.getAssetTree().size());
        assertEquals(1, q.getPriorityQueue().size());
        assertEquals(1, q.getQueue().size());

    }


    @Test
    public void removeAssetTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue
        Asset a1 = new Asset("test", 1); //create asset
        q.addAsset(a1); //add asset to queue
        q.removeAsset(a1.getName()); // remove that asset from queue

        //Check if size was decreased
        assertEquals(0, q.getQueueSize()); 

        //Check all data structures to see if it was removed
        assertFalse(q.getSortedAssets().contains(a1));
        assertFalse(q.getAssetMap().containsKey(a1.getName()));
        assertFalse(q.getAssetNames().contains(a1.getName()));
        assertFalse(q.getAssetTree().contains(a1));
        assertFalse(q.getPriorityQueue().contains(a1));
        assertFalse(q.getQueue().contains(a1));
    }

    @Test
    public void removeFromEmptyQueue()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        q.removeAsset("doesNotExist");//try to remove asset that does not exist in the queue
        
        assertEquals(0, q.getQueueSize()); //check if queuesize is still zero.
    }


    @Test
    public void emptyQueueTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue
        
        //Check if size was initialized to zero
        assertEquals(0, q.getQueueSize()); 

        //Check all data structures to see if it is empty
        assertTrue(q.getSortedAssets().isEmpty());
        assertTrue(q.getAssetMap().isEmpty());
        assertTrue(q.getAssetNames().isEmpty());
        assertTrue(q.getAssetTree().isEmpty());
        assertTrue(q.getPriorityQueue().isEmpty());
        assertTrue(q.getQueue().isEmpty());
    }


    @Test
    public void assetTreeTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset a1 = new Asset("test1", 1); //create asset1
        Asset a2 = new Asset("test2", 2); //create asset2

        //Add assets to queue
        q.addAsset(a1);
        q.addAsset(a2);

        assertEquals(a1, q.getAssetTree().first()); //Checks if the first asset in is the first in the sorted tree (will be the first to be removed | FIFO)
        assertEquals(a2, q.getAssetTree().last()); //Checks if the last asset in is the last in sorted tree
    }


    @Test
    public void priorityQueueTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset a1 = new Asset("test1", 1); //Create asset1
        Asset a2 = new Asset("test2", 2); //Create asset2

        //Add assets to queue
        q.addAsset(a1);
        q.addAsset(a2);

        //priortiy queue sorts by assets with the lowest quantity get put at the front,
        assertEquals(a1, q.getPriorityQueue().peek()); //Checks if the asset with the lowest quanitity is at the front of the queue.
    }

    @Test
    public void retrieveAssetTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset a1 = new Asset("test1", 1); //Create asset1
        Asset a2 = new Asset("test2", 2); //Create asset2

        //Add assets to queue
        q.addAsset(a1);
        q.addAsset(a2);

        Asset ra = q.retrieveAsset();

        //Check if queue size decreased
        assertEquals(1, q.getQueueSize());

        //Check if queue returned the correct asset a1 (FIFO)
        assertEquals(a1, ra);
    }

    @Test
    public void retrieveAssetNullTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset ra = q.retrieveAsset();

        //Check if queue returned null since the queue is empty
        assertEquals(null, ra);
    }


    @Test
    public void addDependencyTest()
    {
        AssetQueue q = new AssetQueue(10); //Create new Queue

        Asset a1 = new Asset("test1", 1); //Create asset1
        Asset a2 = new Asset("test2", 2); //Create asset2

        //Add assets to queue
        q.addAsset(a1);
        q.addAsset(a2);

        //Add dependency
        q.addDependency(a1.getName(),a2.getName());

        assertTrue(q.canRetrieveAsset(a2.getName())); //Checks if asset that is not dependent can be retrieved
        assertFalse(q.canRetrieveAsset(a1.getName())); //Checks if asset that is depenedtent cannot be retrieved
    }
}
