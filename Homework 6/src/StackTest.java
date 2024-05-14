import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

/**
 * StackTest: a test class for the given StackInterface implementation using an ArrayList.
 */
public class StackTest {

    /** An object which implements StackInterface. */
    private StackInterface<Integer> stack;

    /** This function is executed every single time before each test runs. */
    @BeforeEach
    public void setup() {
        stack = new ArrayListStack<Integer>();
    }

    @Test
    public void testEmpty() {
        // Verify that a call to empty() on an empty stack returns true
        assertTrue(stack.empty(), "Test Failed - Should start as empty");
    }

    @Test
    public void testPushAndNotEmpty() {
        // Push one item into the stack and verify that it isn't empty with empty()
        stack.push(5);
        assertFalse(stack.empty(), "Should not be empty");
    }

    @Test
    public void testPushAndPeekOnce() {
        // Push one item into the stack and verify that peek returns that item
        stack.push(5);
        assertEquals(5L, (long) stack.peek(), "Expected and actual don't match, only one value was pushed!");
    }

    @Test
    public void testPushAndPeekMany() {
        // Push four integers, 0 through 4, onto the top of the stack and verify that peek() returns the current
        // integer following its insertion through each iteration
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            assertEquals((long) i, (long) stack.peek(), "Expected and actual don't match, somethings wrong with pushing multiple values?");
        }
    }

    @Test
    public void testPeekError() {
        // Attempts to call peak() on an empty stack should throw an EmptyStackException
        assertThrows(EmptyStackException.class, () -> stack.peek(), "Peek should have thrown EmptyStackException!");
    }

    @Test
    public void testPopOnce() {
        // Push one integer into the stack
        stack.push(71);
        assertEquals(71L, (long) stack.pop(), "Expected and actual don't match- something's wrong with popping or pushing one value?");
    }

    @Test
    public void testPopMany() {
        // Push 13 integers, 50 through 63, onto the stack
        for (int i = 50; i <= 63; i++) {
            stack.push(i);
        }

        // Values come out in reverse order!
        for (int i = 63; i >= 50; i--) {
            assertEquals((long) i, (long) stack.pop(), "Expected and actual don't match- something's wrong with popping or pushing multiple values?");
        }
    }

    @Test
    public void testPopError() {
        // Attempts to call pop() on an empty stack should throw an EmptyStackException
        assertThrows(EmptyStackException.class, () -> stack.pop(), "Pop should have thrown EmptyStackException!");
    }

} // End of class StackTest