import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    static LRUCache testCache;

    @BeforeAll
    static void setUp() {
        testCache = new LRUCache(3);
        testCache.put(4, 4);
        testCache.put(5, 5);
    }

    @Test
    void put() {
        testCache.put(2, 2);
        testCache.put(3, 3);
        assertEquals(3, testCache.map.size());
    }

    @Test
    void get() {
        assertEquals(5, testCache.get(5));
        testCache.put(6, 6);
        assertEquals(5, testCache.get(5));
        assertEquals(-1, testCache.get(2));
    }
}