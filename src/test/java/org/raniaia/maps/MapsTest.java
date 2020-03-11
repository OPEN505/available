package org.raniaia.maps;

import org.available.map.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 16:35
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public class MapsTest {

    static Map<String,String> data = Maps.newHashMap();

    static{
        data.put("0","a");
        data.put("1","b");
        data.put("2","c");
    }

    Map<String,String> map = Maps.newHashMap(data);

    @Test
    public void test01(){
        String a = Maps.getFirstValue(map);
    }

}
