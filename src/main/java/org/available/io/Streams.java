package org.available.io;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 流的静态工具类
 * Create by TianSheng on 2020/3/13 1:09
 */
public class Streams {

    @SneakyThrows
    public static FileInputStream newFileInputStream(String path) {
        return new FileInputStream(path);
    }

}
