package org.raniaia.available.array;

/*
 * Copyright (C) 2020 Tiansheng All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Creates on 2019/12/13
 */

import lombok.SneakyThrows;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 静态数组工具类
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
