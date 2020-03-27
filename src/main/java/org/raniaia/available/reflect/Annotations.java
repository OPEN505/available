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
 * Creates on 2020/3/21.
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

/**
 * @author tiansheng
 */
public class Annotations {

    @SuppressWarnings("unchecked")
    public static <A> A isAnnotation(AccessibleObject target,
                                     Class<? extends Annotation> annotation) {
        if (target.isAnnotationPresent(annotation)) {
            return (A) target.getDeclaredAnnotation(annotation);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <A> A isAnnotation(Class<?> target,
                                     Class<? extends Annotation> annotation) {
        if (target.isAnnotationPresent(annotation)) {
            return (A) target.getDeclaredAnnotation(annotation);
        }
        return null;
    }

}
