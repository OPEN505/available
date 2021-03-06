package org.appcuver.available.logging;

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
 * Creates on 2020/5/4.
 */

/**
 * @author tiansheng
 */
public interface Log {

    /**
     * 判断当前Log实现类是不是坏的
     */
    boolean isBad();

    /**
     * 判断当前是否开启了debug模式
     */
    boolean isDebugEnabled();

    void info(String msg);

    void debug(String msg);

    void warn(String msg);

    void error(String msg);

    void info(String msg, Throwable e);

    void debug(String msg, Throwable e);

    void warn(String msg, Throwable e);

    void error(String msg, Throwable e);

}
