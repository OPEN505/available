package org.available.io.file;

import org.available.io.Streams;

/**
 * jar包内部进行文件相关操作的静态工具类
 * Create by TianSheng on 2020/3/13 0:52
 */
public class JarFiles {

    /**
     * 通过相对路径来读取外部文件，并返回{@code String}
     */
    public static String readExternal(String path) {
        path = System.getProperty("user.dir").concat(path);
        return Files.read(Streams.newFileInputStream(path));
    }

}
