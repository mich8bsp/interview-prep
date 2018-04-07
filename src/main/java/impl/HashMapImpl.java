package impl;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapImpl<K, V> implements Map<K, V> {

    private float loadFactor = 0.75f;
    private int size = 0;
    private HashBucket[] buckets;

    public HashMapImpl() {
        this(16);
    }

    public HashMapImpl(int initialCapacity) {
        buckets = new HashBucket[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getBucketIndex(key);
        return buckets[index].getNode((K) key)!=null;
    }

    @Override
    public boolean containsValue(Object value) {
        if(value==null){
            return false;
        }
        for (HashBucket bucket : buckets) {
            Entry<K, V> found = bucket.getNodeByValue((V) value);
            if (found != null) {
                return true;
            }
        }
        return false;
    }

    private int getBucketIndex(Object key){
        int hash = key.hashCode();
        return hash % buckets.length;
    }

    @Override
    public V get(Object key) {
        int index = getBucketIndex(key);
        if(buckets[index]==null){
            return null;
        }
        Entry<K, V> node = buckets[index].getNode((K) key);
        return Optional.ofNullable(node)
                .map(Entry::getValue)
                .orElse(null);
    }

    @Override
    public V put(K key, V value) {
        ensureLoadBalance();
        int index = getBucketIndex(key);
        if(buckets[index]==null){
            buckets[index] = new HashBucket();
        }
        Entry<K, V> existingNode = buckets[index].getNode(key);
        if(existingNode==null) {
            buckets[index].addNode(key, value);
            size++;
        }else{
            existingNode.setValue(value);
        }
        return value;
    }

    private void ensureLoadBalance() {
        if(size > loadFactor * buckets.length){
            List<Entry> allEntries = Arrays.stream(buckets)
                    .filter(Objects::nonNull)
                    .filter(bucket -> bucket.getEntriesList()!=null)
                    .flatMap(bucket -> bucket.getEntriesList().stream())
                    .collect(Collectors.toList());
            buckets = new HashBucket[buckets.length * 2];
            size = 0;
            allEntries.forEach(entry -> put((K)entry.getKey(), (V)entry.getValue()));
        }
    }

    @Override
    public V remove(Object key) {
        int index = getBucketIndex(key);
        if(buckets[index]==null){
            return null;
        }
        Entry<K, V> toBeRemoved = buckets[index].getNode((K) key);

        boolean success = buckets[index].getEntriesList().
                removeIf(entry -> key.equals(entry.getKey()));
        if(success){
            size--;
            return toBeRemoved.getValue();
        }else{
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
