import java.util.*;

public class CacheLevel {
    private int size;
    private String evictionPolicy;
    private LinkedHashMap<String, String> cache;
    private Map<String, Integer> frequencyMap;

    public CacheLevel(int size, String evictionPolicy) {
        this.size = size;
        this.evictionPolicy = evictionPolicy;
        if (evictionPolicy.equals("LRU")) {
            cache = new LinkedHashMap<>(size, 0.75f, true);
        } else if (evictionPolicy.equals("LFU")) {
            cache = new LinkedHashMap<>();
            frequencyMap = new HashMap<>();
        }
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public String get(String key) {
        if (evictionPolicy.equals("LFU")) {
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        }
        return cache.get(key);
    }

    public void put(String key, String value) {
        if (cache.size() >= size) {
            evict();
        }
        cache.put(key, value);
        if (evictionPolicy.equals("LFU")) {
            frequencyMap.put(key, 1);
        }
    }

    private void evict() {
        String keyToEvict = null;
        if (evictionPolicy.equals("LRU")) {
            keyToEvict = cache.entrySet().iterator().next().getKey();
        } else if (evictionPolicy.equals("LFU")) {
            keyToEvict = Collections.min(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        cache.remove(keyToEvict);
        if (evictionPolicy.equals("LFU")) {
            frequencyMap.remove(keyToEvict);
        }
    }

    public String display() {
        return cache.toString();
    }
}
