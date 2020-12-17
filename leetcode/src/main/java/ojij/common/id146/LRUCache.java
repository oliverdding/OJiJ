package ojij.common.id146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author OliverDD
 * @version 1.0.0
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(16, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * 当存量大于容量时删除最未使用的缓存。
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }

    /**
     * 获取key值的缓存，若不存在则返回-1.
     *
     * @param key key值
     * @return 对应的缓存，不存在则为-1。
     */
    public int get(int key) {
        Integer result = super.get(key);
        return result == null ? -1 : result;
    }

    /**
     * 往缓存写入新的键值。若超出{@code capacity}则删除最近最久未使用的缓存。
     *
     * @param key   key值
     * @param value value值
     */
    public void put(int key, int value) {
        super.put(key, value);
    }
}
