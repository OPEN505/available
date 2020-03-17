package org.available.io.file;

import lombok.SneakyThrows;

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
     * 通过{@code path}读取文件数据，并返回{@code String}对象
     */
    public static String read(String path) {
        try {
            return read(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过{@code URL}来读取文件数据，并返回{@code String}对象
     */
    public static String read(URL url) {
        return read(url.toExternalForm().replace("file:/", ""));
    }

    /**
     * 数据写出到磁盘文件中
     * @param path          写出到path文件夹下，如果没有会自动创建
     * @param content       文件内容
     * @return true代表写出成功，false则失败
     */
    public static boolean write(String path, String content) {
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
     * 创建一个{@code FileWrite}对象，默认会判断路径是否存在，然后
     * 如果不存在则会进行创建。创建后返回{@code FileWrite}流。
     *
     * @param path          文件所在的文件夹
     * @param filename      文件名，需要携带后缀
     * @return 一个{@code FileWrite}对象
     */
    @SneakyThrows
    public static FileWriter newFileWrite(String path,String filename){
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
     * 根据{@code path}创建一个{@code FileWrite}
     */
    @SneakyThrows
    public static FileWriter newFileWrite(String path,boolean append){
        return new FileWriter(path,append);
    }

}
