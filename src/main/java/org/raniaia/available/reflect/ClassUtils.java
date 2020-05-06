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

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

/**
 * 类的静态工具类
 *
 * @author tiansheng
 */
public class ClassUtils {

    /**
     * 创建一个实例。
     */
    @SneakyThrows
    public static Object newInstance(Class<?> clazz){
        return clazz.newInstance();
    }

    /**
     * 创建一个实例并传递构造函数参数。
     *
     * @param parametersType 构造函数参数类型。
     * @param parametersValue 构造函数参数值。
     */
    @SneakyThrows
    public static Object newInstance(Class<?> clazz,Class<?>[] parametersType,
                                     Object... parametersValue){
        Constructor constructor = clazz.getConstructor(parametersType);
        return constructor.newInstance(parametersValue);
    }

}
