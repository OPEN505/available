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
 * Creates on 2020/4/29.
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局异常捕获，只捕捉并打印异常但不会对异常进行处理。
 * 如果异常已经被捕获了那么UncheckedException将不会对它进行捕捉。
 *
 * @author tiansheng
 */
public class UncheckedExceptionHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 线程对象
     */
    private ThreadGroup currentGroup;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String className = "--- ".concat(e.getStackTrace()[0].getClassName())
                .concat(": ")
                .concat(e.getStackTrace()[0].getMethodName())
                .concat(" ---");
        String datetime = "--- ".concat(sdf.format(new Date())).concat(" ---");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionInfo = sw.toString();
        StringBuffer buffer = new StringBuffer();
        buffer.append(className)
                .append("\n")
                .append(datetime)
                .append("\n\n     ")
                .append(exceptionInfo);
        String endExceptionInfo = "\n".concat(buffer.toString()).concat("\n");
        System.err.println(endExceptionInfo);
    }

    public void init() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        // 获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slackList);
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        for (Thread thread : list) {
            thread.setUncaughtExceptionHandler(new UncheckedExceptionHandler());
        }
    }

}
