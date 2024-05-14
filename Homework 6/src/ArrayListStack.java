
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;


/**
 * ArrayListStack : a simple implementation of the StackInterface using an ArrayList.
 */
public class ArrayListStack<Integer> implements StackInterface<Integer> 
{

    private ArrayList<Integer> arr = new ArrayList<Integer>();

    // Implement StackInterface methods here
    @Override
    public boolean empty() 
    {
        
        return arr.isEmpty();
    }

    @Override
    public Integer peek() throws EmptyStackException 
    {
        if(arr.isEmpty())
        {
            throw new EmptyStackException(); // Throw exception if stack is empty
        }else
        {
            return arr.get(arr.size() - 1); // return the top of the stack == the last element of the arraylist
        }
    }

    @Override
    public Integer pop() throws EmptyStackException 
    {
        
        if(arr.isEmpty())
        {
            throw new EmptyStackException(); // throw exception if stack is empty
        }else
        {
            return arr.remove(arr.size() - 1);
        }
    }

    @Override
    public Integer push(Integer item) 
    {
        
        arr.add(arr.size(), item);
        
        return item;
        
    }
}
