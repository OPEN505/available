package org.raniaia.available.logging.stdnop;

/*
 * Copyright (C) 2020 tiansheng All rights reserved.
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
 * Creates on 2020/3/27.
 */

import org.raniaia.available.logging.Log;

/**
 * @author tiansheng
 */
public class StdLog implements Log {

    public StdLog() {
    }

    public StdLog(Class<?> name){
        this(name.getName());
    }

    public StdLog(String name){
        // Do Noting
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println(msg);
    }

    @Override
    public void debug(String msg) {
        System.out.println(msg);
    }

    @Override
    public void error(String msg) {
        System.out.println(msg);
    }

    @Override
    public void error(String msg, Throwable e) {
        System.out.println(msg);
    }

    @Override
    public boolean isBad() {
        return false;
    }

    @Override
    public void info(String v, Throwable e) {
    }

    @Override
    public void debug(String v, Throwable e) {

    }

    @Override
    public void warn(String v, Throwable e) {

    }
}
