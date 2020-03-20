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
 * Creates on 2020/3/20 23:48
 */

import lombok.SneakyThrows;
import org.raniaia.available.list.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Method static tools class.
 *
 * @author tiansheng
 * @since 8
 */
public class Methods {

    /**
     * Get methods by {@link Class} instance.
     */
    public static Method[] getMethods(Class<?> target) {
        return target.getMethods();
    }

    /**
     * Get declared methods by {@link Class} instance.
     */
    public static Method[] getDeclaredMethods(Class<?> target) {
        return target.getDeclaredMethods();
    }

    /**
     * If the {@param method} has {@param annotations}, return the
     * current annotation instance.
     */
    public static <T extends Annotation> T isAnnotation(Method method, Class<T> annotations) {
        if (method.isAnnotationPresent(annotations)) {
            return method.getDeclaredAnnotation(annotations);
        }
        return null;
    }

    /**
     * Get methods by annotations, return if method has {@param annotations}.
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

    /**
     * Invoke.
     */
    @SneakyThrows
    public static Object invoke(Method method, Object... args) {
        setAccessible(method);
        Class clazz = method.getDeclaringClass();
        Object instance = clazz.newInstance();
        return method.invoke(instance, args);
    }

    /**
     * Set method accessible, default {@code Boolean#true}.
     */
    public static void setAccessible(Method method){
        method.setAccessible(true);
    }

    /**
     * Set method accessible.
     */
    public static void setAccessible(Method method,boolean flag){
        method.setAccessible(flag);
    }

}