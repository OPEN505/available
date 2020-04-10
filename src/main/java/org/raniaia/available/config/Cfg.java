package org.raniaia.available.config;

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

import org.raniaia.available.io.Paths;
import org.raniaia.available.map.Maps;
import org.raniaia.available.string.LineReader;
import org.raniaia.available.string.StringUtils;
import org.raniaia.available.thread.Threads;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * 读取.cfg后缀类型的配置文件。
 * 文件格式为(config.cfg)：
 * <code>
 *     [user]
 *     name = 法外狂徒：张三
 *     age = 18
 *     [parent]
 *     dad = 李四
 *     age = 50
 * </code>
 *
 * 使用方法为，首先初始化构造器比如<code>new Cfg("c:/config.cfg")</code>，或者是new一个Cfg类，
 * 然后通过{@link #load}方法进行初始化。和构造器有着相同的效果。
 *
 * 我们要获取上面配置中的内容就通过{@link #get}方法获取即可。比如我们获取user节点下的name。
 * <code>
 *     Cfg cfg = new Cfg("config.cfg");
 *     //
 *     // 第一个参数为根节点就是用大括号括起来的内容
 *     // 第二个参数就是节点下的键值对。
 *     //
 *     cfg.get("user","name");
 * </code>
 *
 *
 * @author tiansheng
 */
public class Cfg {

    Map<String, Map<String,Object>> cfg = Maps.newHashMap();

    public Cfg(){}

    public Cfg(String path) throws IOException {
        load(new LineReader(path));
    }

    public Cfg(String path,Class<?> clazz) throws IOException {
        if(clazz == null){
            clazz = Threads.getCaller();
        }
        load(new LineReader(path,clazz));
    }

    public Cfg(String path,ClassLoader loader) throws IOException {
        if(loader == null){
            loader = Threads.getCallerLoader();
        }
        load(new LineReader(path,loader));
    }

    public void load(LineReader reader) throws IOException {
        String root = null;
        Map<String,Object> kv = Maps.newHashMap();
        while (reader.ready()){
            String value = reader.readLine();
            if(StringUtils.isEmpty(value)){
                continue;
            }
            char c = value.charAt(0);
            if('#' == c){
                continue;
            }
            if('[' == c){
                if(!StringUtils.isEmpty(root)){
                    cfg.put(root.trim(),Maps.newHashMap(kv));
                    root = null;
                    kv.clear();
                }
                root = StringUtils.delHeadAndTail(value);
                continue;
            }
            int index = value.indexOf("=");
            String k = value.substring(0,index);
            String v = value.substring(index+1);
            kv.put(k.trim(),v.trim());
        }
        cfg.put(root,Maps.newHashMap(kv));
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String root,String key){
        Map v = cfg.get(root);
        return v == null ? null : (T) v.get(key);
    }

}
