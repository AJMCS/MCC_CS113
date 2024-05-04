
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
            return arr.get(arr.size() - 1); //
        }
    }

    @Override
    public Integer pop() throws EmptyStackException 
    {
        
        if(arr.isEmpty())
        {
            throw new EmptyStackException();
        }else
        {
            return this.pop();
        }
    }

    @Override
    public Integer push(Integer item) 
    {
        
        arr.add(arr.size() -1, item);
        
        return item;
        
    }
}
