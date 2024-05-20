import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * DoubleLinkedListTest : Test class for the DoubleLinkedList implementation and its constituent ListIterator
 * inner class.
 */
public class DoubleLinkedListTest 
{
    Integer[] intTerms = {1, 2, 3, 4, 5};
    String[] stringTerms = {"one", "two", "three", "four", "five"};
    Character[]  charTerms = {'a', 'b', 'c', 'd', 'e'};
    Double[] doubleTerms = {1.5, 2.5, 3.5, 4.5, 5.5};

    
    public <E> List <E> addItems(E[] terms)
    {
        List <E> list = new DoubleLinkedList<E>();
        for(E e : terms)
        {
            list.addLast(e);
        }

        return list;
    }


    @Test
    public void sizeOfEmptyListTest()
    {
        List emptyList = new DoubleLinkedList<>();

        assertEquals(0, emptyList.size());

    }

    @Test
    public void sizeOfListTest()
    {
        List<Integer> intList = new DoubleLinkedList<>();
        List<String> stringList = new DoubleLinkedList<>();
        List<Character> charList = new DoubleLinkedList<>();
        List<Double> doubleList = new DoubleLinkedList<>();
        
        intList = addItems(intTerms);
        stringList = addItems(stringTerms);
        charList = addItems(charTerms);
        doubleList = addItems(doubleTerms);


        assertEquals(intTerms.length, intList);
        assertEquals(stringTerms.length, stringList);
        assertEquals(charTerms.length, charList);
        assertEquals(doubleTerms.length, doubleList);
    }

    @Test
    public void clearEmptyListTest()
    {
        List clearList = new DoubleLinkedList<>();

        clearList.clear();

        assertEquals(0, clearList.size());
    }

    @Test
    public void clearListTest()
    {
        List<String> clearList = new DoubleLinkedList<>();

        clearList = addItems(stringTerms);

        clearList.clear();

        assertEquals(0, clearList.size());
    }

    @Test
    public void iteratorTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        newList = addItems(intTerms);

        var iter = newList.iterator();
        

        for(int i = 0; i < newList.size(); i++)
        {
            assertEquals(intTerms[i], iter.next());
        }

    }

    @Test
    public void listIteratorTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        newList = addItems(intTerms);

        var iter = newList.listIterator();
        

        for(int i = 0; i < newList.size(); i++)
        {
            assertEquals(intTerms[i], iter.next());
        }
    }

    @Test
    public void listIteratorAtIndexTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        newList = addItems(intTerms);

        var iter = newList.listIterator(3);
        

        for(int i = 3; i < newList.size(); i++)
        {
            assertEquals(intTerms[i], iter.next());
        }
    }

    @Test
    public void nextEmptyListTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        var iter = newList.listIterator();

        assertThrows(NoSuchElementException.class, ()-> iter.next());
        
    }

    @Test
    public void nextTest()
    {
        List<Character> newList = new DoubleLinkedList<>();
        newList = addItems(charTerms);
        var iter = newList.listIterator();

        try 
        {
            iter.next();
            
        } catch (NoSuchElementException e) 
        {
            Assert.fail();
        }
    }

    @Test
    public void hasNextEmptyListTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        var iter = newList.listIterator();

        assertFalse(iter.hasNext());
    }

    @Test
    public void hasNextTest()
    {
        List<String> newList = new DoubleLinkedList<>();
        newList = addItems(stringTerms);
        var iter = newList.listIterator();

        assertTrue(iter.hasNext());
    }

    @Test
    public void hasPreviousEmptyListTest()
    {
        List<Integer> newList = new DoubleLinkedList<>();
        var iter = newList.listIterator();

        assertFalse(iter.hasPrevious());
    }

    @Test
    public void hasLastTest()
    {
        List<String> newList = new DoubleLinkedList<>();
        newList = addItems(stringTerms);
        var iter = newList.listIterator();

        for(int i = 0; i < stringTerms.length; i++)
        {
            iter.next();
        }

        assertTrue(iter.hasPrevious());
    }

    @Test
    public void removeEmptyListTest()
    {
        List<String> newList = new DoubleLinkedList<>();
        var iter = newList.listIterator();

        assertThrows(IllegalStateException.class, ()-> iter.remove());
    }

    @Test
    public void removeSingleElementTest()
    {
        List<String> newList = new DoubleLinkedList<>();
        newList = addItems(stringTerms);
        var iter = newList.listIterator(0);

        iter.next();
        iter.remove();

        assertEquals(stringTerms.length -1, newList.size());

        for(int i = 1; i < stringTerms.length; i++)
        {
            assertEquals(stringTerms[i], iter.next());
        }
    }

    @Test
    public void setTest()
    {
        List<Double> newList = new DoubleLinkedList<>(); //Declare list
        newList = addItems(doubleTerms); //Fill list
        var iter = newList.listIterator(0); //Declare List iterator
        

        for(int i = 0; i < doubleTerms.length; i++)
        {
            iter.next();
            iter.set(doubleTerms[i] + 10);
        }

        iter = newList.listIterator(0); //reset iterator

        for(int i = 0; i < doubleTerms.length; i++)
        {
            Double expected = doubleTerms[i] + 10;
            assertEquals(expected, iter.next());
        }

    }


    // endregion ListIterator tests ====================================================================================
    // =================================================================================================================

} // End of class DoubleLinkedListTest