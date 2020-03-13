package org.available.list;

import java.util.*;

/**
 *
 * List静态工具类
 *
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 15:36
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public final class Lists {

    /**
     * 创建一个可变的 {@code ArrayList}
     * @return 空的 {@code ArrayList} 实例
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 创建一个可变的 {@code ArrayList}
     * 复制一个{@link List}中的数据到新的{@code List}中
     *
     * @return 新的List且带有传入List数据的实例
     */
    public static <E> ArrayList<E> newArrayList(Collection<? extends E> collection) {
        return new ArrayList<>(collection);
    }

    /**
     * 创建一个可变的 {@code ArrayList}
     * 复制数组中的内容到新创建的{@code ArrayList}中
     *
     * @return 新的List且带有传入List数据的实例
     */
    public static <E> ArrayList newArrayList(E[] es){
        return new ArrayList<>(Arrays.asList(es));
    }

    /**
     * 创建一个可变的 {@code LinkedList}
     * @return 空的 {@code LinkedList} 实例
     */
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    /**
     * 创建一个可变的 {@code LinkedList}
     * 复制一个{@link List}中的数据到新的{@code LinkedList}中
     *
     * @return 新的List且带有传入List数据的实例
     */
    public static <E> LinkedList<E> newLinkedList(Collection<? extends E> collection) {
        return new LinkedList<>(collection);
    }

    /**
     * 创建一个可变的 {@code LinkedList}
     * 复制数组中的内容到新创建的{@code LinkedList}中
     *
     * @return 新的{@code List}且带有传入数组的数据的实例
     */
    public static <E> LinkedList<E> newLinkedList(E[] es){
        return new LinkedList<>(Arrays.asList(es));
    }

    /**
     * 创建一个可变的 {@code Vector}
     * @return 空的 {@code Vector} 实例.
     */
    public static <E> Vector<E> newVector() {
        return new Vector<>();
    }

    /**
     * 创建一个可变的 {@code Vector}
     * 复制一个{@link Vector}中的数据到新的{@code Vector}中
     *
     * @return 新的{@code Vector}且带有传入{@code Vector}数据的实例
     */
    public static <E> Vector<E> newVector(Collection<? extends E> collection) {
        return new Vector<>(collection);
    }

    /**
     * 创建一个可变的 {@code Vector}
     * 复制一个数组中的数据到新的{@code Vector}中
     *
     * @return 新的{@code Vector}且带有传入的数组数据的实例
     */
    public static <E> Vector<E> newVector(E[] es){
        return new Vector<>(Arrays.asList(es));
    }

}
