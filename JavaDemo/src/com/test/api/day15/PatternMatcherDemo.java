package com.test.api.day15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配
 * Pattern和Matcher类支持正则
 * String类部分方法也支持正则操作
 */
public class PatternMatcherDemo {
    public static void main(String[] args) {
        {
            // 全量匹配，使用matches()
            String regex = "[a-d]{3}\\d{2}";

            // public static boolean matches(String regex, CharSequence input)
            System.out.println(Pattern.matches(regex, "abc11")); // true
            System.out.println(Pattern.matches(regex, "abc123")); // false

            // Pattern.matches()方法实际上进行如下操作
            // 实例化Pattern对象，public static Pattern compile(String regex)
            Pattern pattern = Pattern.compile(regex);
            // 获取Matcher类对象，public Matcher matcher(CharSequence input)
            Matcher matcher = pattern.matcher("abc11");
            // 正则匹配，public boolean matches()
            System.out.println(matcher.matches()); // true
        }

        {
            // 部分匹配，使用find()
            String str = "abc123def";
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);

            // 判断字符串中是否存在正则匹配的部分，public boolean find()
            if (matcher.find()) {
                // 提取正则匹配的部分，public String group()
                System.out.println(matcher.group()); // 123
            }
        }

        {
            // 获取正则中的匹配组，使用()标记
            String str = "abc123def";
            Pattern pattern = Pattern.compile("(\\d+)([a-z]+)");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                // 获取整个匹配组，public String group()
                System.out.println(matcher.group()); // 123def
                // 获取第1个匹配组，public String group(int group)
                System.out.println(matcher.group(1)); // 123
                // 获取第2个匹配组
                System.out.println(matcher.group(2)); // def
            }
        }
    }
}
