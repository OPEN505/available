package org.appcuver.available.logging.slf4j;

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

import org.appcuver.available.logging.Log;
import org.slf4j.helpers.NOPLogger;

/**
 * @author tiansheng
 */
public class Slf4jLog implements Log {

    private org.slf4j.Logger log;

    public Slf4jLog() {}

    public Slf4jLog(org.slf4j.Logger log) {
        this.log = log;
    }

    @Override
    public boolean isBad() {
        return log instanceof NOPLogger;
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void info(String v) {
        log.info(v);
    }

    @Override
    public void debug(String v) {
        log.debug(v);
    }

    @Override
    public void warn(String v) {
        log.warn(v);
    }

    @Override
    public void error(String v) {
        log.error(v);
    }

    @Override
    public void info(String v, Throwable e) {
        log.info(v, e);
    }

    @Override
    public void debug(String v, Throwable e) {
        log.debug(v, e);
    }

    @Override
    public void warn(String v, Throwable e) {
        log.warn(v, e);
    }

    @Override
    public void error(String v, Throwable e) {
        log.error(v, e);
    }

}
