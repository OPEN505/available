package org.available.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Static {@code Map} tools class.
 *
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 15:35
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public class Maps {

    private Maps(){}

    /**
     * Creates <i>mutable</i>, empty {@code HashMap} instance.
     *
     * @return a new, empty {@code HashMap}
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * Creates <i>mutable</i>, empty {@code HashMap} instance.
     *
     * Copy a {@link Map} instance to created {@code HashMap} instance.
     *
     * @return a new {@code HashMap} instance after copy.
     */
    public static <K, V> HashMap<K, V> newHashMap(Map<K, V> map) {
        return new HashMap<>(map);
    }

    /**
     * Get first key in {@link Map} instance.
     *
     * @return first key in map.
     */
    public static Object getFirstKey(Map map) {
        for (Object o : map.keySet()) {
            return o;
        }
        return null;
    }

    /**
     * Get first value in {@link Map} instance.
     *
     * @return first value in {@link Map} instance.
     */
    public static Object getFirstValue(Map map) {
        for (Object value : map.values()) {
            return value;
        }
        return null;
    }

    /**
     * Get key by index in {@link Map} instance.
     *
     * @return the index key.
     */
    public static Object getKey(Map map, int index) {
        int count = 0;
        for (Object value : map.keySet()) {
            if (count == index) return value;
            count++;
        }
        return null;
    }

    /**
     * Get value by index in {@link Map} instance.
     *
     * @return the index value.
     */
    public static Object getValue(Map map, int index) {
        int count = 0;
        for (Object value : map.values()) {
            if (count == index) return value;
            count++;
        }
        return null;
    }

}
