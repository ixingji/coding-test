package com.ixingji;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<String, String> {

    public static final int CAPACITY = 100;

    public LRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return super.size() > CAPACITY;
    }

}
