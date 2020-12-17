package ojij.common.id146;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

    LRUCache lruCache;

    @Test
    void removeEldestEntry() {
        lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
    }
}