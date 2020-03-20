package org.available.classes;

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
 * Creates on 2020/3/20 14:42
 */

import lombok.SneakyThrows;
import org.available.io.file.Files;

import java.io.File;
import java.net.URL;

/**
 * Static {@code ClassLoader#getResource} tools class.
 */
public class ClassResources {

    /**
     * Get resource {@link ClassLoader#getResource} to {@link URL}.
     */
    public static URL toURL(){
        return toURL("");
    }

    /**
     * Get resource {@link ClassLoader#getResource} to {@link URL}.
     */
    public static URL toURL(String name){
        return caller().getResource(name);
    }

    /**
     * Get resource {@link ClassLoader#getResource} to {@link File}.
     */
    public static File toFile(){
        return Files.newFile(toURL());
    }

    /**
     * Get resource {@link ClassLoader#getResource} to {@link File}.
     */
    public static File toFile(String name){
        return Files.newFile(toURL(name));
    }

    @SneakyThrows
    static Class<?> caller(){
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        return Class.forName(stacks[stacks.length-1].getClassName());
    }

}
