package org.available.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 静态{@code Map}工具类
 *
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 15:35
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public final class Maps {

    private Maps() {}

    /**
     * 创建一个新的{@code HashMap}实例
     * @return 新的且空的{@code HashMap}实例
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 拷贝{@code Map}中的数据到新创建的{@code HashMap}实例中
     * @return 拷贝数据后的{@code HashMap}实例
     */
    public static <K, V> HashMap<K, V> newHashMap(Map<K, V> map) {
        return new HashMap<>(map);
    }

    /**
     * 创建一个新的{@code LinkedHashMap}实例
     * @return 一个新的、空的{@code LinkedHashMap}实例
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 拷贝{@code Map}中的数据到新创建的{@code LinkedHashMap}中
     * @return 拷贝数据后的{@code HashMap}实例
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<K, V> map) {
        return new LinkedHashMap<>(map);
    }

    /**
     * 创建一个新的{@code ConcurrentHashMap}实例
     * @return 一个新的、空的{@code ConcurrentHashMap}实例
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 拷贝{@code Map}中的数据到新的{@code ConcurrentHashMap}实例中
     * @return 拷贝数据后的{@code ConcurrentHashMap}实例
     */
    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap(Map<K, V> map) {
        return new ConcurrentHashMap<>(map);
    }

    /**
     * 获取{@code Map}中的第一个Key
     */
    public static <K, V> V getFirstKey(Map<K, V> map) {
        for (Object o : map.keySet()) {
            return (V) o;
        }
        return null;
    }

    /**
     * 获取{@code Map}中的第一个值
     */
    public static <K, V> V getFirstValue(Map<K, V> map) {
        for (Object value : map.values()) {
            return (V) value;
        }
        return null;
    }

    /**
     * 根据下标获取{@code Map}中的Key
     */
    public static <K, V> V getKey(Map<K, V> map, int index) {
        int count = 0;
        for (Object value : map.keySet()) {
            if (count == index) return (V) value;
            count++;
        }
        return null;
    }

    /**
     * 根据下标获取{@code Map}中的Value
     */
    public static <K, V> V getValue(Map<K, V> map, int index) {
        int count = 0;
        for (Object value : map.values()) {
            if (count == index) return (V) value;
            count++;
        }
        return null;
    }

}
