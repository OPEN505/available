package org.available.io;

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
 * Creates on 2020/3/13 1:09
 */

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Stream static tools class.
 */
public class Streams {

    @SneakyThrows
    public static FileInputStream newFileInputStream(File file) {
        return new FileInputStream(file);
    }

    @SneakyThrows
    public static FileInputStream newFileInputStream(String path) {
        return new FileInputStream(path);
    }

}
