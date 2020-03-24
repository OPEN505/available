package org.raniaia.available;

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
 * Creates on 2020/3/23 20:25
 */

import org.raniaia.available.thread.Threads;

import java.util.Objects;

/**
 * Available tools.
 * @author tiansheng
 */
public class Available {

    /**
     * Replace the classpath: string in path string with {@link OpCodes#USER_DIR}.
     */
    public static String toClasspath(String path){
        if(Objects.requireNonNull(path,"path cannot null.").contains("classpath:")){
            path = path.replace("classpath:",getClasspath());
        }
        return path.replaceAll("\\\\","/");
    }

    /**
     * Get current project relative path.
     */
    public static String getClasspath(){
        return Threads.getCaller().getClassLoader().getResource("").getFile();
    }

    public static void main(String[] args) {
        System.out.println(toClasspath("classpath:"));
    }

}
