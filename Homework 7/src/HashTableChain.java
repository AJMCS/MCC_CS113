import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * HashTableChain class implementing the Map interface using chaining for collision resolution.
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashTableChain<K, V> implements Map<K, V> {

    private static class Entry<K, V> {
        private final K key;
        private V value;
        Entry<K, V> next; // Pointer to the next entry in the chain

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        // Getters, setters, and possibly equals() and hashCode(), depending on your implementation
    }

    // TODO: Define the array of entries that will store the chains
    private Entry<K, V>[] table;

    // TODO: Define other necessary fields (like size, threshold, load factor, etc.)

    public HashTableChain() {
        Hashtable<K, V> table = new Hasttable<>(10, 0.80f);
    }

    @Override
    public int size() {
        // TODO: Return the number of key-value mappings in this map.
        return 0; // Placeholder
    }

    @Override
    public boolean isEmpty() {
        // TODO: Return true if this map contains no key-value mappings.
        return true; // Placeholder
    }

    @Override
    public boolean containsKey(Object key) {
        // TODO: Return true if this map contains a mapping for the specified key.
        return false; // Placeholder
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO: Return true if this map maps one or more keys to the specified value.
        return false; // Placeholder
    }

    @Override
    public V get(Object key) {
        // TODO: Return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        return null; // Placeholder
    }

    @Override
    public V put(K key, V value) {
        // TODO: Associate the specified value with the specified key in this map (optional operation).
        return null; // Placeholder
    }

    @Override
    public V remove(Object key) {
        // TODO: Remove the mapping for a key from this map if it is present (optional operation).
        return null; // Placeholder
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO: Copies all of the mappings from the specified map to this map (optional operation).
    }

    @Override
    public void clear() {
        // TODO: Removes all of the mappings from this map (optional operation).
    }

    @Override
    public Set<K> keySet() {
        // TODO: Returns a Set view of the keys contained in this map.
        return null; // Placeholder
    }

    @Override
    public Collection<V> values() {
        // TODO: Returns a Collection view of the values contained in this map.
        return null; // Placeholder
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        // TODO: Returns a Set view of the mappings contained in this map.
        return null; // Placeholder
    }

    // TODO: Implement any additional helper methods you need for managing chains and entries.

}
