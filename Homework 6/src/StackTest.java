import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

/**
 * StackTest: a test class for the given StackInterface implementation using an ArrayList.
 */
public class StackTest 
{

    /** An object which implements StackInterface. */
    private StackInterface<Integer> stack;

    /** This function is executed every single time before each test runs. */
    @BeforeEach
    public void setup() 
    {
        stack = new ArrayListStack<Integer>();
    }

    @Test
    public void testEmpty() 
    {
        // Verify that a call to empty() on an empty stack returns true
        assertTrue(stack.empty(), "Test should be true (Stack is empty)");
    }

    @Test
    public void testPushAndNotEmpty()
    {
        stack.push(1); //push number onto stack

        assertFalse(stack.empty()); // verifies that the stack is no longer empty.
    }

    @Test
    public void testPushAndPeekOnce()
    {
        stack.push(2); // pushes number onto stack
        assertEquals((int)2, (int)stack.peek()); // makes sure the peek function returns the correct number back.
    }

    @Test
    public void testPushAndPeekMany()
    {
        for(int i = 0; i < 20; i++)
        {
            stack.push(i); //adds number to stack
            assertEquals((int) i, (int) stack.peek()); // makes sure the peek is returning the same value as the number that was just pushed.
        }
    }

    @Test
    public void testPeekError()
    {
        assertThrows(EmptyStackException.class, () -> stack.peek()); // Checks to see if correct exception is thrown when this function is called.
    }

    @Test
    public void testPopOnce()
    {
        stack.push(1);
        int pop = stack.pop();

        assertEquals((int) 1, pop); // verify that item return equals the value of the item pushed.
        assertTrue(stack.empty()); // Verify the stack is now empty.
    }

    @Test
    public void testPopMany()
    {
        for (int i = 0; i < 20; i++) //pushes numbers from 0-19 onto stack, where 19 is on top.
        {
            stack.push(i);
        }

        for(int i = 19; i >= 0; i--)
        {
            assertEquals((int) i, (int) stack.pop()); // Checks order of stack by making sure pops equals 19 and decrease by 1 until the stack is empty
        }
    }

    @Test
    public void testPopError()
    {
        assertThrows(EmptyStackException.class, () -> stack.pop()); //Checks if this call with throw the correct exception
    }

}