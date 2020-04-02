package org.raniaia.available.string;

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

import org.raniaia.available.io.IOUtils;
import org.raniaia.available.io.file.Files;
import org.raniaia.available.list.Lists;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiansheng
 */
public class LineReader {

    String[] value;

    int index = -1;

    public LineReader() {
    }

    public LineReader(String path) throws IOException {
        this(new BufferedReader(new InputStreamReader(
                Files.newFileInputStream(path)
        )));
    }

    public LineReader(BufferedReader buf) throws IOException {
        load(buf);
    }

    public void load(BufferedReader buf) throws IOException {
        List<String> value = Lists.newLinkedList();
        while (buf.ready()) {
            value.add(buf.readLine());
        }
        String[] value0 = new String[value.size()];
        value.toArray(value0);
        this.value = value0;
    }

    public boolean ready() {
        if (index < value.length - 1) {
            index++;
            return true;
        }
        return false;
    }

    public String readLine() {
        return value[index];
    }

}