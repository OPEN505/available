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

import java.io.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

/**
 * Reading .cfg file to {@code Map}.
 * @author tiansheng
 */
public class Cfg {

    Map<String, Map<String,Object>> cfg = Maps.newHashMap();

    public Cfg(){}

    public Cfg(String path) throws IOException {
        load(path);
    }

    public void load(String path) throws IOException {
        String root = null;
        Map<String,Object> kv = Maps.newHashMap();
        LineReader reader = new LineReader(path);
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
