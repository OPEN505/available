package org.available.classes;

import java.net.URL;

/**
 * 静态类加载器工具类
 * Create by TianSheng on 2020/3/13 0:34
 */
public class ClassLoaders {

    /**
     * 通过类加载器去查找所需要的资源文件, 传入类对象
     */
    public static URL getResource(String name,Class<?> clazz){
        return clazz.getClassLoader().getResource(name);
    }

    /**
     * 通过类加载器去查找所需要的资源文件, 默认使用当前类的加载器作为对象
     */
    public static URL gerResource(String name){
        return getResource(name,ClassLoaders.class);
    }

}
