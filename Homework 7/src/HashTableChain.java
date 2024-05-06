import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HashTableChain class implementing the Map interface using chaining for collision resolution.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashTableChain<K, V> implements Map<K, V> {

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

            public void setValue(V value)
            {
                this.value = value;
            }

            public void setNext(Entry<K, V> entry)
            {
                this.next = entry;
            }

            public boolean equals(Entry<K, V> entry)
            {
                return this.value == entry.value;
            }

            public int hashCode()
            {
                if(this.getKey() instanceof Integer)
                {
                    return (int) this.getKey();
                }
                return 0;
            }

            
            public String toString()
            {
                return this.key + " = " + this.value;
            }
    }

    // TODO: Define the array of entries that will store the chains
    private Entry<K, V>[] table = null;

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
        
        for(int i = 0; i < table.length; i++)
        {
            if(key == table[i].getKey())
            {
                return true;
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
            
            if(value == table[i].getValue())
            {
                return true;
            }

            while(table[i].next != null)
            {
                if(value == table[i].getValue())
            {
                return true;
            }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) 
    {
        //Return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        for(int i = 0; i < table.length; i++)
        {
            if(table[i].getKey() == key)
            {
                return table[i].getValue();
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        // TODO: Associate the specified value with the specified key in this map (optional operation).


        mapSize++;
        return null; // Placeholder
    }

    @Override
    public V remove(Object key) 
    {
        // TODO: Remove the mapping for a key from this map if it is present (optional operation).

        for(int i = 0; i < table.length; i++)
        {
            if(table[i].getKey() == key)
            {
                Entry<K, V> temp = table[i];
                table[i] = null;
                mapSize--;
                return temp.getValue();
            }
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
        
        for(Entry<K,V> entry : table)
        {
            entry = null;
        }
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
        // TODO: Returns a Set view of the mappings contained in this map.
        Set<Map.Entry<K,V>> maps = new HashSet<>();

        for(int i = 0; i < table.length; i++)
        {
            maps.add(table[i]);

            while(table[i].next != null)
            {
                maps.add(table[i]);
            }
        }
        

        return maps;
    }

    // TODO: Implement any additional helper methods you need for managing chains and entries.

}
