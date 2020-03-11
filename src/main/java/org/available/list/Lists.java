package org.available.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

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
     * Creates <i>mutable</i>, {@code ArrayList} instance.
     * @return empty {@code ArrayList} instance.
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * Creates <i>mutable</i>, {@code ArrayList} instance.
     *
     * Copy a {@link List} instance data to created {@code ArrayList} instance.
     *
     * @return a new {@code ArrayList} instance after copying data.
     */
    public static <E> ArrayList<E> newArrayList(List<E> list){
        return new ArrayList<>(list);
    }

    /**
     * Creates <i>mutable</i>, {@code LinkedList} instance.
     *
     * Copy a {@link List} instance data to created {@code LinkedList} instance.
     * @return a new {@code LinkedList} instance after copying data.
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    /**
     * Creates <i>mutable</i>
     * @return a new {@code LinkedList} instance after copy data.
     */
    public static <E> LinkedList<E> newLinkedList(List<E> list) {
        return new LinkedList<>(list);
    }

    /**
     * Creates <i>mutable</i>, empty {@code Vector} instance.
     * @return empty {@code Vector} instance.
     */
    public static <E> Vector<E> newVector() {
        return new Vector<>();
    }

    /**
     * Creates <i>mutable</i>, {@code Vector} instance.
     *
     * Copy a {@link List} instance data to created {@code Vector} instance.
     *
     * @return a new {@code Vector} instance after copying data.
     */
    public static <E> Vector<E> newVector(List<E> list) {
        return new Vector<>(list);
    }

}
