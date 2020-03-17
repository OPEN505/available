package org.available.array;

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * 静态数组工具类
 * Copyright: Create by TianSheng on 2019/12/13 18:36
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class Arrays {

    /**
     * 判断对象是否为数组
     */
    public static boolean isArray(Object o) {
        if (o == null) return false;
        Class c = o.getClass();
        return c.isArray() || ((Class) o).getName().contains("[");
    }

    /**
     * 对象数组扩容
     *
     * @param array 数组对象
     * @param size  扩容大小
     * @return 扩容后的数组
     */
    @SneakyThrows
    public static <T> T[] expansion(Object array, int size) {
        Object[] array0 = toArray(array);
        String typename0 = array.getClass().getTypeName();
        typename0 = typename0.substring(0,typename0.length()-2);
        Object[] dest = (Object[]) Array.newInstance(Class.forName(typename0), (array0.length + size));
        System.arraycopy(array0, 0, dest, 0, array0.length);
        return (T[]) dest;
    }

    /**
     * 对象转数组
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

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3};
        System.out.println(toString(array));
        array = expansion(array, 3);
        System.out.println(array.length);
    }

}
