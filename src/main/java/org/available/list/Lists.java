package org.available.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * Static {@code List} tools class.
 *
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 15:36
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public class Lists {

    /**
     * Creates <i>mutable</i>, empty {@code ArrayList} instance.
     * @return empty {@code ArrayList} instance.
     */
    public static <E> ArrayList<E> newArrayList(){
        return new ArrayList<>();
    }

    /**
     * Creates <i>mutable</i>, empty {@code LinkedList} instance.
     * @return empty {@code LinkedList} instance.
     */
    public static <E> LinkedList<E> newLinkedList(){
        return new LinkedList<>();
    }

}
