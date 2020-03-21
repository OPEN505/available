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
 * Creates on 2020/3/21 14:17
 */

import lombok.SneakyThrows;
import org.raniaia.available.list.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Static {@link Field} tools class.
 */
public class Fields {

    /**
     * Get {@link Field} in the {@param target}.
     */
    public static Field[] getFields(Class<?> target) {
        return getFields(target, false);
    }

    /**
     * Get {@link Field} in the {@param target}.
     */
    public static Field[] getFields(Class<?> target, boolean accessible) {
        Field[] fields = target.getFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(accessible);
        }
        return fields;
    }

    /**
     * Get {@link Field} by {@param annotations}.
     */
    public static Field[] getFields(Class<?> target,
                                    Class<? extends Annotation>[] annotations) {
        return getFields(target, annotations, false);
    }

    /**
     * Get {@link Field} by {@param annotations}.
     */
    public static Field[] getFields(Class<?> target,
                                    Class<? extends Annotation>[] annotations,
                                    boolean accessible) {
        return getFieldsByAnnotation(getFields(target, accessible), annotations);
    }

    /**
     * Get declared {@link Field} in the {@param target}.
     */
    public static Field[] getDeclaredFields(Class<?> target) {
        return getDeclaredFields(target, false);
    }

    /**
     * Get declared {@link Field} in the {@param target}.
     */
    public static Field[] getDeclaredFields(Class<?> target, boolean accessible) {
        Field[] fields = target.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(accessible);
        }
        return fields;
    }

    /**
     *  Get declared {@link Field} by {@param annotations}.
     */
    public static Field[] getDeclaredFields(Class<?> target,
                                            Class<? extends Annotation>[] annotations) {
        return getFieldsByAnnotation(getDeclaredFields(target), annotations);
    }

    /**
     *  Get declared {@link Field} by {@param annotations}.
     */
    public static Field[] getDeclaredFields(Class<?> target,
                                            Class<? extends Annotation>[] annotations,
                                            boolean accessible) {
        return getFieldsByAnnotation(getDeclaredFields(target, accessible), annotations);
    }

    /**
     * Get fields by {@param annotations}.
     *
     * The {@param accessible} is {@link Field#setAccessible}
     */
    public static Field[] getFieldsByAnnotation(Field[] fields,
                                                Class<? extends Annotation>[] annotations) {
        List<Field> fields0 = Lists.newLinkedList();
        for (Field field : fields) {
            for (Class<? extends Annotation> annotation : annotations) {
                if (field.isAnnotationPresent(annotation)) {
                    fields0.add(field);
                    break;
                }
            }
        }
        Field[] fieldArray = new Field[fields0.size()];
        fields0.toArray(fieldArray);
        return fieldArray;
    }

    /**
     * filed value set.
     */
    @SneakyThrows
    public static void set(Object instance,Object value,Field field){
        field.set(instance,value);
    }

}
