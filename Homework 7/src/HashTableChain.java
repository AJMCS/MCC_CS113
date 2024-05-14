import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * HashTableChain class implementing the Map interface using chaining for collision resolution.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashTableChain<K, V> implements Map<K, V> 
{

    private static class Entry<K, V> implements Map.Entry<K, V>
    {
        private final K key;
        private V value;
        Entry<K, V> next; // Pointer to the next entry in the chain

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        // Getters, setters, and possibly equals() and hashCode(), depending on your implementation

        public boolean equals()
        {
            return false;
        }

        public K getKey()
            {
                return this.key;
            }

            public V getValue()
            {
                return this.value;
            }

            public Entry<K, V> getNext()
            {
                return this.next;
            }

            @Override
            public V setValue(V value)
            {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            }

            public void setNext(Entry<K, V> entry)
            {
                this.next = entry;
            }

            public boolean equals(Entry<K, V> entry)
            {
                return key.equals(entry.getKey()) && value.equals(entry.getValue());
            }

            public int hashCode()
            {
                return Objects.hash(key, value);
            }

            
            public String toString()
            {
                return this.key + " = " + this.value;
            }

            public void addFirst(Entry<K,V> entry) 
            {
                // TODO Auto-generated method stub
                
                entry.next = this;

            }
    }

    
    // TODO: Define the array of entries that will store the chains
    private Entry<K, V>[] table = new Entry[10];

    // TODO: Define other necessary fields (like size, threshold, load factor, etc.)
    private int mapSize;
    private double threshold;


    public HashTableChain() 
    {
        mapSize = 0;
        threshold = 0.85;
    }

    @Override
    public int size() 
    { 
        return mapSize;
    }

    @Override
    public boolean isEmpty() 
    {
        return mapSize == 0; 
    }

    @Override
    public boolean containsKey(Object key) 
    {
        int index = key.hashCode() % table.length;

        if(table[index] == null)
        {
            return false;
        }

        Entry<K, V> temp = table[index];

        while(temp != null)
        {
            if(temp.getKey().equals(key))
            {
                return true;
            }
            else
            {
                temp = temp.next;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) 
    {
        // TODO: Return true if this map maps one or more keys to the specified value.
 
        for(int i = 0; i < table.length; i++)
        {
            Entry<K, V> temp = table[i];

            while(temp != null)
            {
                if(temp.getValue().equals(value))
                {
                    return true;
                }
                else
                {
                    temp = temp.next;
                }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) 
{
    // Return the value to which the specified key is mapped, or null if this map contains no mapping for the key.

    int index = key.hashCode() % table.length;
    if (index < 0) 
    {
        index = -index; // Handle negative hash codes
    }

    Entry<K, V> temp = table[index];
    
    // Loop through the linked list at the index
    while (temp != null) 
    {
        if (key.equals(temp.getKey())) 
        {
            return temp.getValue();
        }
        temp = temp.next;
    }

    return null;
}

    @Override
    public V put(K key, V value) 
    {
        // TODO: Associate the specified value with the specified key in this map (optional operation).
        Entry<K, V> temp = new Entry(key, value);
    
        //Initializing values
        int index = key.hashCode() % table.length;
        temp = table[index];

        //If the table at the index is null
        if(table[index] == null)
        {
            table[index] = new Entry<K, V>(key, value); //place the entry in the table
            mapSize++; //increase size of map
            return value;
        }
        else
        {
            while(temp != null) //Loop through the chain
            {
                //Check each entry to see if this key already exists in the table
                if(key.equals(temp.getKey()))
                {
                    V oldValue = temp.getValue();
                    temp.setValue(value); //If it does, update the value to the new value
                    return oldValue; // return oldValue
                }
                else
                {
                    temp = temp.next;
                }
            }

            //Add Entry to the beginning of the chain
            temp = table[index];
            table[index] = new Entry<K, V>(key, value);
            table[index].next = temp;
            mapSize++; //increase size of map
            return value;
        }
    }

    @Override
    public V remove(Object key) 
{
    // Calculate the index
    int index = key.hashCode() % table.length;
    if (index < 0) {
        index = -index; // Handle negative hash codes
    }
    Entry<K, V> temp = table[index];
    Entry<K, V> prev = null;

    // If the table at the index is null
    if (temp == null) {
        return null;
    }

    // Check if the first entry is the one to remove
    while (temp != null) {
        if (key.equals(temp.getKey())) {
            V value = temp.getValue();
            if (prev == null) {
                // Remove the first entry in the linked list
                table[index] = temp.next;
            } else {
                // Remove the entry in the middle or end of the linked list
                prev.next = temp.next;
            }
            mapSize--;
            return value;
        }
        prev = temp;
        temp = temp.next;
    }
    return null;
}

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO: Copies all of the mappings from the specified map to this map (optional operation).
    }

    @Override
    public void clear() 
    {
        // TODO: Removes all of the mappings from this map (optional operation).
        
        for(int i = 0; i < table.length; i++)
        {
            table[i] = null;
        }
        mapSize = 0;
    }

    @Override
    public Set<K> keySet() 
    {
        // TODO: Returns a Set view of the keys contained in this map.

        Set<K> set = new HashSet<K>();

        for(Entry<K, V> entry : table)
        {
            set.add(entry.getKey());
        }

        return set;
    }

    @Override
    public Collection<V> values() 
    {
        //Returns a Collection view of the values contained in this map.
        
        ArrayList<V> valuesArr = new ArrayList<>();

        for(int i = 0; i < table.length; i++)
        {
            valuesArr.add(table[i].getValue());

            while(table[i].next != null)
            {
                valuesArr.add(table[i].getValue());
            }
        }

        return valuesArr;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() 
    {
        Set<Map.Entry<K, V>> maps = new HashSet<>();

        for (int i = 0; i < table.length; i++) 
        {
            Entry<K, V> temp = table[i];

            while (temp != null) 
            {
                maps.add(temp);
                temp = temp.next;
            }
                
                if(table[i] != null)
                {
                    temp = table[i];
                    
                    while(temp != null)
                    {
                        maps.add(temp);
                        temp = temp.next;
                    }
                }

            return maps;
        }

        return maps;
    }

    // TODO: Implement any additional helper methods you need for managing chains and entries.

}
