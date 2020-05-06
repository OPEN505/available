package org.raniaia.available.reflect;

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
 * Creates on 2020/3/20.
 */

import lombok.SneakyThrows;
import org.raniaia.available.list.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 方法的静态工具类
 *
 * @author tiansheng
 * @since 8
 */
public class Methods {

    /**
     * 通过{@link Class}实例获取方法。
     */
    public static Method[] getMethods(Class<?> target) {
        return getMethods(target, false);
    }

    /**
     * 通过{@link Class}实例获取方法。
     */
    public static Method[] getMethods(Class<?> target, boolean accessible) {
        Method[] methods = target.getMethods();
        for (int i = 0; i < methods.length; i++) methods[i].setAccessible(accessible);
        return methods;
    }

    /**
     * 通过{@link Class}实例获取声明的方法。
     */
    public static Method[] getDeclaredMethods(Class<?> target) {
        return getDeclaredMethods(target, false);
    }

    /**
     * 通过{@link Class}实例获取声明的方法。
     */
    public static Method[] getDeclaredMethods(Class<?> target, boolean accessible) {
        Method[] methods = target.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) methods[i].setAccessible(accessible);
        return methods;
    }

    /**
     * 如果{@param method}具有{@param annotations}，则返回当前注解实例。
     */
    public static <T extends Annotation> T isAnnotation(Method method, Class<T> annotations) {
        if (method.isAnnotationPresent(annotations)) {
            return method.getDeclaredAnnotation(annotations);
        }
        return null;
    }

    /**
     * 根据注解来获取方法实例。
     */
    public static Method[] getMethodsByAnnotations(Class<?> target, Class<? extends Annotation>[] annotations) {
        List<Method> methodList = Lists.newArrayList();
        Method[] methods = getDeclaredMethods(target);
        for (Method method : methods) {
            for (Class<? extends Annotation> annotation : annotations) {
                if (method.isAnnotationPresent(annotation)) {
                    methodList.add(method);
                    break;
                }
            }
        }
        Method[] methods0 = new Method[methodList.size()];
        methodList.toArray(methods0);
        return methods0;
    }

    @SneakyThrows
    public static Object invoke(Method method, Object... args) {
        Class clazz = method.getDeclaringClass();
        Object instance = clazz.newInstance();
        return method.invoke(instance, args);
    }

    @SneakyThrows
    public static Object invoke(Method method, boolean accessible, Object... args) {
        setAccessible(method, accessible);
        Class clazz = method.getDeclaringClass();
        Object instance = clazz.newInstance();
        return method.invoke(instance, args);
    }


    /**
     * 设置方法访问参数
     */
    public static void setAccessible(Method method) {
        method.setAccessible(true);
    }

    /**
     * 设置方法访问参数
     */
    public static void setAccessible(Method method, boolean flag) {
        method.setAccessible(flag);
    }

}