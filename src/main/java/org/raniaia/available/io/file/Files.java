package org.raniaia.available.io.file;

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
 * Creates on 2020/3/12 21:25
 */

import lombok.SneakyThrows;
import org.raniaia.available.AvailTool;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Static {@code File} tools class.
 */
public class Files {

    /**
     * Creates <i>mutable</i> the {@code File} instance.
     * By <b>path#string</b>.
     */
    public static File newFile(String path) {
        return new File(AvailTool.toClasspath(path));
    }

    /**
     * Creates <i>mutable</i> the {@code File} instance.
     * By <b>uri#URI</b>.
     */
    public static File newFile(URI uri) {
        return new File(uri);
    }
    /**
     * Creates <i>mutable</i> the {@code File} instance.
     * By <b>url#URL</b>.
     */
    @SneakyThrows
    public static File newFile(URL url) {
        return newFile(url.toURI());
    }

    /**
     * Read file data via {@code InputStream}, and return {@code String}.
     */
    public static String read(InputStream input) {
        if (input == null) throw new NullPointerException();
        StringBuilder out = new StringBuilder();
        try {
            final int size = 1024;
            final char[] buffer = new char[size];
            Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
            while (true) {
                int rsz = reader.read(buffer, 0, size);
                if (rsz < 0) break;
                out.append(buffer, 0, rsz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Read file data via path, and return {@code String}
     */
    public static String read(String path) {
        try {
            return read(new FileInputStream(AvailTool.toClasspath(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read file data via {@code URL}, and return {@code String}
     */
    public static String read(URL url) {
        return read(url.toExternalForm().replace("file:/", ""));
    }

    /**
     * Write data to the specified file. and return {@code boolean}
     * true write success, false write failure.
     */
    public static boolean write(String path, String content) {
        path = AvailTool.toClasspath(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = newFileWrite(path, true);
            fileWriter.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates a new {@code FileWrite} object instance. this method will
     * judge path whether exist. if not exist will create directory and file.
     */
    @SneakyThrows
    public static FileWriter newFileWrite(String path,String filename){
        path = AvailTool.toClasspath(path);
        File file0 = new File(path);
        if(!file0.exists()){
            file0.mkdirs();
        }
        File file = new File(path.concat("/").concat(filename));
        if(!file.exists()){
            file.createNewFile();
        }
        return new FileWriter(file);
    }

    /**
     * Creates a new {@code FileWrite} object instance by path, and {@code append}.
     */
    @SneakyThrows
    public static FileWriter newFileWrite(String path,boolean append){
        return new FileWriter(AvailTool.toClasspath(path),append);
    }

    /**
     * Creates new {@code FileWrite} object instance by {@code File} instance.
     */
    @SneakyThrows
    public static FileWriter newFileWrite(File file){
        return new FileWriter(file);
    }

    /**
     * Creates new {@code FileInputStream} object instance by {@code File} instance.
     */
    @SneakyThrows
    public static FileInputStream newFileInputStream(File file) {
        return new FileInputStream(file);
    }

    /**
     * Creates new {@code FileInputStream} object instance by {@code path} instance.
     */
    @SneakyThrows
    public static FileInputStream newFileInputStream(String path) {
        return new FileInputStream(AvailTool.toClasspath(path));
    }

}
