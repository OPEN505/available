package org.available.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 流的静态工具类
 * Create by TianSheng on 2020/3/13 1:09
 */
public class Streams {

    public static FileInputStream newFileInputStream(String path){
        try {
            return new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
