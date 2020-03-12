package org.available.io.file;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Create by TianSheng on 2020/3/12 21:25
 */
public class Files {

    /**
     * 创建一个File对象
     */
    public static File newFile(String path) {
        return new File(path);
    }

    /**
     * 通过{@code InputStream}流读取文件数据，并返回{@code String}对象
     */
    public static String read(InputStream input) {
        if(input == null) throw new NullPointerException();
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
     * 通过{@code path}读取文件数据，并返回{@code String}对象
     */
    public static String read(String path){
        try {
            return read(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过{@code URL}来读取文件数据，并返回{@code String}对象
     * @param url
     * @return
     */
    public static String read(URL url){
        return read(url.toExternalForm().replace("file:/",""));
    }

}
