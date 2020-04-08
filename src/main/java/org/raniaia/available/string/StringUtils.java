package org.raniaia.available.string;

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
 * Creates on 2020/3/11.
 */

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * String工具类
 */
public class StringUtils {

    /**
     * 字符串是否为空
     *
     * @param s 目标字符串
     * @return 返回boolean
     */
    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }
        // Unicode 编码下的空格
        if ("\u0000".equals(s)) {
            return true;
        }
        return s.length() == 0 || " ".equals(s);
    }

    public static boolean isNull(String input) {
        return "null".equals(input);
    }

    /**
     * 获取最后一个字符
     *
     * @param v 目标字符串
     * @return 返回该字符串的最后一个字符
     */
    public static String getLast(String v) {
        return v.substring(v.length() - 1);
    }

    /**
     * 删除最后一个字符
     *
     * @param v 目标字符串
     * @return 返回处理后的字符串
     */
    public static String delLast(String v) {
        return v.substring(0, v.length() - 1);
    }

    /**
     * 获取首字符
     * @param v
     * @return
     */
    public static String getFirst(String v) {
        return v.substring(0, 1);
    }

    /**
     * 删除第一个字符
     *
     * @param v 目标字符串
     * @return 返回处理后的字符串
     */
    public static String delFirst(String v) {
        return v.substring(1, v.length());
    }

    /**
     * 删除首尾字符
     */
    public static String delHeadAndTail(String input){
        return delFirst(delLast(input));
    }

    /**
     * 判断字符串是不是数字
     * @param v
     * @return
     */
    public static boolean isNumber(String v) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(v).matches();
    }

    /**
     * 清空StringBuilder
     * @param builder
     */
    public static String clear(StringBuilder builder) {
        String v = builder.toString();
        builder.delete(0, builder.length());
        return v;
    }

    /**
     * 获取一个字符串的开始位置和结束位置
     *
     * @param v         源字符串
     * @param find      需要查找的字符串
     * @return 数组 0=开始位置 1=结束位置
     */
    public static int[] getStartAndEndIndex(String v, String find) {
        int start = -1; // 开始下标
        int end = -1; // 结束下标
        int currentIndex = 0; // 当前下标 -1等于当前源字符串长度已遍历完
        char[] source = v.toCharArray(); // 源字符串char数组
        char[] target = find.toCharArray();
        while (source.length >= currentIndex) {
            boolean result = true;
            for (char c : target) {
                if (source[currentIndex] == c) {
                    result = true;
                } else {
                    result = false;
                    currentIndex++;
                    break;
                }
                currentIndex++;
            }
            if (result) {
                start = currentIndex - target.length;
                end = currentIndex;
                break;
            }
        }
        return new int[]{start, end};
    }

    /**
     * String格式化,大约比String.format()快17倍
     * @param input
     * @param args
     * @return
     */
    public static String format(String input, Object... args) {
        int argsLen = 0;
        int offset = 0;
        int subscript = 0;
        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        char previous = '#';
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (previous == '{' && current == '}') {
                if(argsLen >= args.length){
                    return builder.toString().concat(new String(chars).substring((i+1)));
                }
                char[] temp = new char[(i - offset) - 1];
                System.arraycopy(chars, offset, temp, 0, (offset = i - 1));
                builder.append(temp).append(args[subscript]);
                temp = new char[chars.length - offset - 2];
                System.arraycopy(chars, offset + 2, temp, 0, temp.length);
                // reset
                chars = temp;
                subscript++;
                i = 0;
                offset = 0;
                argsLen++;
            } else {
                previous = current;
            }
        }
        return builder.append(chars).toString();
    }

    /**
     * 将字符串合并成一行
     * @param text
     * @return
     */
    public static String trim(String text) {
        StringBuilder content = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while (tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken();
            content.append(str);
            if (tokenizer.hasMoreTokens()) {
                content.append(" ");
            }
        }
        return content.toString();
    }

    /**
     * 对某个字母转换成大写
     * @param index
     * @return
     */
    public static String upperCase(String input, int index) {
        StringBuilder builder = new StringBuilder(input);
        String value = new String(new char[]{input.charAt(index - 1)}).toUpperCase();
        builder.replace(0, 1, value);
        return builder.toString();
    }

    /**
     * 对某个字母转换成小写
     * @param index
     * @return
     */
    public static String lowerCase(String input, int index) {
        StringBuilder builder = new StringBuilder(input);
        String value = new String(new char[]{input.charAt(index - 1)}).toLowerCase();
        builder.replace(0, 1, value);
        return builder.toString();
    }

    /**
     * 驼峰转下划线
     *
     * @param string
     * @return
     */
    public static String humpToUnderline(String string) {
        StringBuilder builder = new StringBuilder(string);
        int temp = 0; // 定位
        for (int i = 0, len = string.length(); i < len; i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                builder.insert(i + temp, "_");
                temp++;
            }
        }
        return builder.toString().toLowerCase();
    }

    /**
     * 下划线转驼峰
     *
     * @param string
     * @return
     */
    public static String underlineToHump(String string) {
        StringBuilder builder = new StringBuilder();
        String[] strs = string.split("_");
        builder.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            StringBuilder v = new StringBuilder(strs[i]);
            v.replace(0, 1, String.valueOf(v.charAt(0)).toUpperCase());
            builder.append(v);
        }
        return builder.toString();
    }

    public static String newString(char[] input){
        return new String(input);
    }

    public static String newString(String input){
        return new String(input);
    }

    public static String newString(String[] inputs){
        StringBuilder builder = new StringBuilder();
        for (String input : inputs) {
            builder.append(input);
        }
        return builder.toString();
    }

}

