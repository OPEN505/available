package org.appcuver.relfect;

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

import org.appcuver.available.reflect.ClassUtils;

/**
 * @author tiansheng
 */
public class ClassUtilsTest {

    static public class A {
        public A() {
            System.out.println("无参构造器");
        }

        public A(String name) {
            System.out.println("有参构造器，参数: " + name);
        }
    }

    public static void main(String[] args) {
        ClassUtils.newInstance(A.class,new Class[]{String.class},"张三");
    }

}
