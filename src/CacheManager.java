import java.util.*;

public class CacheManager {
    private List<CacheLevel> cacheLevels = new ArrayList<>();

    public void addCacheLevel(int size, String evictionPolicy) {
        cacheLevels.add(new CacheLevel(size, evictionPolicy));
    }

    public void removeCacheLevel(int level) {
        if (level >= 0 && level < cacheLevels.size()) {
            cacheLevels.remove(level);
        }
    }

    public String get(String key) {
        for (CacheLevel level : cacheLevels) {
            if (level.containsKey(key)) {
                String value = level.get(key);
                promoteToHigherLevels(key, value);
                return value;
            }
        }
        return "Cache miss!";
    }

    public void put(String key, String value) {
        if (!cacheLevels.isEmpty()) {
            cacheLevels.get(0).put(key, value);
        }
    }

    private void promoteToHigherLevels(String key, String value) {
        for (int i = 1; i < cacheLevels.size(); i++) {
            if (cacheLevels.get(i).containsKey(key)) {
                cacheLevels.get(i).put(key, value);
            }
        }
    }

    public void displayCache() {
        for (int i = 0; i < cacheLevels.size(); i++) {
            System.out.println("Level " + (i + 1) + ": " + cacheLevels.get(i).display());
        }
    }
}
