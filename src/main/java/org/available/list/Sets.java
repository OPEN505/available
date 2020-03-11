package org.available.list;

import java.util.*;

/**
 *
 * {@link Set}静态工具类
 *
 * <p/>
 * License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
 * <p/>
 * Copyright: Create by TianSheng on 2020/3/11 18:27
 * @author TianSheng
 * @version 1.0.0
 * @since 1.8
 */
public class Sets {

    /**
     * 创建一个新的且空的{@code HashSet}实例
     */
    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    /**
     * 创建一个可变的 {@code HashSet}实例
     * 拷贝{@link Collection}中的数据到新的{@code HashSet}中。
     */
    public static <E> HashSet<E> newHashSet(Collection<? extends E> collection) {
        return new HashSet<>(collection);
    }

    /**
     * 创建一个新的{@code LinkedHashSet}实例
     */
    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    /**
     * 创建一个新的{@code LinkedHashSet}实例
     * 拷贝{@link Collection}中的数据到新的{@code LinkedHashSet}中。
     */
    public static <E> LinkedHashSet<E> newLinkedHashSet(Collection<? extends E> collection) {
        return new LinkedHashSet<>(collection);
    }

}
