package HeapsAndMaps;

import java.util.HashMap;
import java.util.TreeMap;

public class LruCache {

    // more easier way is using hasMap<K,V> and arrayList(keys) for linked list

    private HashMap<Integer, Integer> hashMapValues = new HashMap<>(); // key, value
    private HashMap<Integer, Integer> hashMapTimes = new HashMap<>(); // key, timestamp
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // timestamp, key

    private int capacity = 0;
    private int timestamp = 0;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hashMapValues.containsKey(key)) {
            int oldTimestamp = hashMapTimes.get(key);
            hashMapTimes.put(key, timestamp);
            treeMap.remove(oldTimestamp);
            treeMap.put(timestamp, key);
            timestamp++;
            return hashMapValues.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (hashMapValues.containsKey(key)) {
            int oldTimestamp = hashMapTimes.get(key);
            treeMap.remove(oldTimestamp);
        } else if (hashMapValues.size() == capacity) {
            int removeKey = treeMap.pollFirstEntry().getValue();
            hashMapValues.remove(removeKey);
            hashMapTimes.remove(removeKey);
        }
        hashMapValues.put(key, value);
        hashMapTimes.put(key, timestamp);
        treeMap.put(timestamp, key);
        timestamp++;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.set(1, 10);
        lruCache.set(5, 12);
        lruCache.get(5);
        lruCache.get(1);
        lruCache.set(6, 14);
        lruCache.get(5);
    }
}
