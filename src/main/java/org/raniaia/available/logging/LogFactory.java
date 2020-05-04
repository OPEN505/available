package org.raniaia.available.logging;

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

import org.raniaia.available.exception.LogException;
import org.raniaia.available.logging.slf4j.Slf4jLogAdapter;
import org.raniaia.available.logging.stdnop.StdLogAdapter;

import java.lang.reflect.Constructor;

/**
 * @author tiansheng
 */
public class LogFactory {

    private static Constructor<? extends LogAdapter> logAdapterConstructor;

    static {
        tryFindLogImplementation(LogFactory::useSlf4jAdapterLogging);
        tryFindLogImplementation(LogFactory::useStdAdapterLogging);
    }

    public static Log getLog(Class<?> key) {
        return getLog(key.getName());
    }

    public static Log getLog(String key) {
        Log log;
        try {
            log = logAdapterConstructor.newInstance().getLog(key);
        } catch (Exception e) {
            throw new LogException("Error creates logger for logger " + key + " . Cause: " + e, e);
        }
        return log;
    }

    private static void tryFindLogImplementation(Runnable runnable) {
        try {
            if(logAdapterConstructor == null) {
                runnable.run();
            }
        } catch (Throwable e) {
            // 忽略异常
        }
    }

    private static void useSlf4jAdapterLogging() {
        setLogImpalementation(Slf4jLogAdapter.class);
    }

    private static void useStdAdapterLogging() {
        setLogImpalementation(StdLogAdapter.class);
    }

    private static void setLogImpalementation(Class<? extends LogAdapter> implClass) {
        try {
            Constructor<? extends LogAdapter> constructor =implClass.getConstructor();
            Log log = constructor.newInstance().getLog(LogFactory.class);
            if(log.isBad()) {
                System.err.println("STD PRINT: " + log.getClass() + " is bad, refidn.");
                return;
            }
            logAdapterConstructor = constructor;
            log.debug("Logger useing '" + implClass + "' adapter.");
        } catch (Throwable e) {
            // 忽略异常
        }
    }

}
