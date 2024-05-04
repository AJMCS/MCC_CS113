import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;


public class StacksTest 
{
    
    StackInterface<Integer> stack;

    @Before
    public void setup()
    {
        stack = new ArrayListStack<Integer>();
    }
    
    @Test
    public void testEmpty()
    {
        assertTrue(stack.empty());
    }

    @Test
    public void testPushAndNotEmpty()
    {
        stack.push(1);

        assertFalse(stack.empty());
    }

    @Test
    public void testPushAndPeekOnce()
    {
        stack.push(2);
        assertEquals((int)2, (int)stack.peek());
    }

    @Test
    public void testPushAndPeekMany()
    {
        for(int i = 0; i < 20; i++)
        {
            stack.push(i);
            assertEquals((int) i, (int) stack.peek());
        }
    }

    @Test
    public void testPeekError()
    {
        try
        {
            stack.peek();
            
        }
    }


}
