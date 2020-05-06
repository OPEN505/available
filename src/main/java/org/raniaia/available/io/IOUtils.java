package org.raniaia.available.io;

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
 * Creates on 2020/4/2.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author tiansheng
 */
public class IOUtils {

    /**
     * 从InputStream中读取数据到
     */
    public static String getString(InputStream input) {
        return getString(input,"UTF-8");
    }

    public static String getString(InputStream input, String charset){
        if(input == null) throw new NullPointerException();
        final int size = 1024;
        final char[] buffer = new char[size];
        final StringBuilder out = new StringBuilder();
        try {
            Reader reader = new InputStreamReader(input, charset);
            while(true){
                int rsz = reader.read(buffer,0,size);
                if(rsz < 0) break;
                out.append(buffer,0,rsz);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return out.toString();
    }

}
