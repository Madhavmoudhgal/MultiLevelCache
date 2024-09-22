public class Main {
    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager();

        // Add cache levels with eviction policies
        cacheManager.addCacheLevel(3, "LRU");
        cacheManager.addCacheLevel(2, "LFU");

        // Insert data into cache
        cacheManager.put("A", "1");
        cacheManager.put("B", "2");
        cacheManager.put("C", "3");

        // Retrieve data from cache
        System.out.println("Get A: " + cacheManager.get("A")); // Expected: 1

        // Insert data causing eviction
        cacheManager.put("D", "4"); // LRU should evict least recently used

        // Display cache content
        cacheManager.displayCache();

        // Fetch and promote data
        System.out.println("Get B (promoted): " + cacheManager.get("B"));
        cacheManager.displayCache();
    }
}
