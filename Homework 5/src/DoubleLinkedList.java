import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;





public class DoubleLinkedList<E> extends AbstractSequentialList<E> {

    /** A reference to the head of the list. */
    private Node<E> head = null;
    /** A reference to the end of the list. */
    private Node<E> tail = null;
    /** The size of the list. */
    private int size = 0;


    /**
     * Insert an object at the beginning of the list.
     * @param item - the item to be added
     */
    public void addFirst(E item) 
    {
        //Add when linked list is empty (head and tail are null)
        if(size == 0)
        {
            Node<E> temp = new Node<E>(item);
            head = temp;
            tail = temp;

           size++; 

        }else //Add when linkedList has at least one element
        {
            Node<E> temp = new Node<E>(item);
            temp.next = head;
            head.prev = temp;
            head = temp;
            
            size++;
        }
        
    }

    /**
     * Insert an object at the end of the list.
     * @param item - the item to be added
     */
    public void addLast(E item) 
    {
        //Add when linked list is empty (head and tail are null)
        if(size == 0)
        {
            Node<E> temp = new Node<E>(item);
            head = temp;
            tail = temp;

           size++; 

        }else //Add when linkedList has at least one element
        {
            Node<E> temp = new Node<E>(item);
            temp.prev = tail;
            tail.next = temp;
            tail = temp;

            size++;
        }
        // Your implementation here
        
        
    }

    /**
     * Get the first element in the list.
     * @return The first element in the list.
     */
    public E getFirst() 
    {
        // Your implementation here
        return head.data;
    }

    /**
     * Get the last element in the list.
     * @return The last element in the list.
     */
    public E getLast() 
    {
        // Your implementation here
        return tail.data; 
    }

    /**
     * Return an Iterator to the list
     * @return an Itertor to the list
     */
    public Iterator<E> iterator() 
    {
        // Your implementation here
        return new ListIter(0);
    }

    /**
     * Return a ListIterator to the list
     * @return a ListItertor to the list
     */
    public ListIterator<E> listIterator() 
    {
        // Your implementation here
        return new ListIter(0);
    }

    /** Return a ListIterator that begins at index
     * @param index - The position the iteration is to begin
     * @return a ListIterator that begins at index
     */
    public ListIterator<E> listIterator(int index) 
    {
        // Your implementation here
        return new ListIter(index);
    }

    /**
     * Return a ListIterator that begins at the same
     * place as an existing ListIterator
     * @param iter - The other ListIterator
     * @return a ListIterator that is a copy of iter
    */
    public ListIterator <E> listIterator(ListIterator <E> iter) {
        return new ListIter( (ListIter) iter);
    }

    /**
     * Add an item at the specified index.
     * @param index The index at which the object is to be
     *        inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out
     *         of range (i < 0 || i > size())
     */
    @Override
    public void add(int index, E obj) 
    {
        // Your implementation here
    }

    /**
     * Get the element at position index.
     * @param index Position of item to be retrieved
     * @return The item at index
     */
    @Override
    public E get(int index) {
        // Your implementation here
        return null; // Placeholder, replace with actual return value
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        // Your implementation here
        return 0; // Placeholder, replace with actual return value
    }

    // Inner Classes
    /** 
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link to the next node. */
        private Node<E> next = null;
        /** The link to the previous node. */
        private Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    } //end class Node

    /** Inner class to implement the ListIterator interface. */
    private class ListIter implements ListIterator<E> {

        /** A reference to the next item. */
        private Node<E> nextItem;
        /** A reference to the last item returned. */
        private Node<E> lastItemReturned;
        /** The index of the current item. */
        private int index = 0;

        /**
         * Construct a ListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public ListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * Construct a ListIter that is a copy of another ListIter
         * @param other The other ListIter
         */
        public ListIter(ListIter other) {
            ListIter itr = new ListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }
        /**
         * Indicate whether movement forward is defined.
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() 
        {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }
        /**
         * Indicate whether movement backward is defined.
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() 
        {
        // Your implementation here
        return (nextItem == null && size !=0) || (nextItem != null && nextItem.prev != null);
       }

        /**
         * Return the index of the next item to be returned by next
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
       // Your implementation here
	        return 0; // Placeholder, replace with actual return value	
        }
        /**
         * Return the index of the next item to be returned by previous
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
       // Your implementation here
            return this.index-1;
        }
        /**
         * Move the iterator backward and return the previous item.
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() 
        {
            
            // Your implementation here
            

	        return 0; // Placeholder, replace with actual return value	

        }

        @Override
        public void add(E obj) {
       // Your implementation here
	        // Placeholder	

        } // End of method add.
        /** Remove the last item returned. This can only be
         *  done once per call to next or previous.
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        @Override
        public void remove() 
        {
       // Your implementation here

	         if(lastItemReturned == null)
            {
                throw new IllegalStateException();
            }
            else if(index == 0)
            {
                throw new NoSuchElementException();
            }
            else if (head == tail)
            {
                head = null;
                tail = null;
            }
            else if(lastItemReturned == head)
            {
                lastItemReturned.next.prev = null;
                head= head.next;
            }
            else if(lastItemReturned == tail)
            {
                tail.prev.next = null;
                tail= tail.prev;
            }
            else
            {
                lastItemReturned.prev.next = lastItemReturned.next;
                lastItemReturned.next.prev = lastItemReturned.prev;
                lastItemReturned = null;
            }
            size--;

        }

        /** Replace the last item returned with a new value
         *  @param item The new value
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        @Override
        public void set(E item) {
       // Your implementation here
       if(lastItemReturned == null)
       {
           throw new IllegalStateException();
       }
       else
       {
           lastItemReturned.data = item;
       }
        }
        
    } 
    /**
     * Method to find the index of the first occurence of an item in the list
     * @param target The item being sought
     * @return The index of the first occurence of the tartet item
     *         or -1 if the item is not found.
     */
    @Override
    public int indexOf(Object target) {
       // Your implementation here
	        // Placeholder

        return -1;
    }

    /**
     * Method to find the index of the last occurence of an item in the list
     * @param target The item being sought
     * @return The index of the last occurence of the tartet item
     *         or -1 if the item is not found.
     */
    @Override
    public int lastIndexOf(Object target) {
       // Your implementation here
	        // Placeholder

        return -1;
    }

    /**
     * Method to return the index of the minimum item in the list
     * It is assumed that each item in the list implements Comparable
     * @return Index of the minimum item in the list
     *         or -1 if the list is empty
     * @throws ClassCastExcepition if the list elements do not implement Comparable
     */
    public int indexOfMin() {
       // Your implementation here
	        // Placeholder

        return 0; //return correct value
    }
}
