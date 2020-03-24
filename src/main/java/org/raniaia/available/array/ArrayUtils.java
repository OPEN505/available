package org.raniaia.available.array;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 静态数组工具类
 * Copyright: Create by TianSheng on 2019/12/13 18:36
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public final class ArrayUtils {
    
    /**
     * 判断对象是否为数组
     */
    public static boolean isArray(Object o) {
        if (o == null) return false;
        Class c = o.getClass();
        return c.isArray() || ((Class) o).getName().contains("[");
    }

    /**
     * 对象转数组, 传入的对象必须是数组转成的。
     */
    public static Object[] toArray(Object array) {
        if (!isArray(array)) return null;
        int size = Array.getLength(array);
        Object[] objects = new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = Array.get(array, i);
        }
        return objects;
    }

    /**
     * 数组的{@code toString}方法
     */
    public static String toString(Object array) {
        if (!isArray(array)) {
            throw new Error("parameter object not array.");
        }
        Object[] array0 = toArray(array);
        String str = "[";
        for (Object o : array0) {
            str += o + ",";
        }
        str = str.substring(0, str.length() - 1) + "]";
        return str;
    }

}
