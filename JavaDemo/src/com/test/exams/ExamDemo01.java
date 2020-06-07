package com.test.exams;

import java.util.Scanner;

/**
 * 输入如下的字符串能够计算出结果
 * (add 4 5)
 * (sub 3 5 2 1)
 * (mul 3 2)
 * (div 0 1)，除数为0是结果为error
 * (sub (add 1 2) (mul 2 3))
 * (div (add 8 2) (mul 5 1) 2 (add 0 0))
 */
public class ExamDemo01 {
    public static void main(String[] args) {
        while (true) {
            String str = null;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                str = scanner.nextLine();
            }
            System.out.println(getEntry(str));
        }
    }

    public static String getEntry(String str) {
        if (str.startsWith("(")) {
            int start = str.lastIndexOf("(");
            int end = str.indexOf(')', start);
            String value = str.substring(start + 1, end);

            if ("error".equals(value)) {
                return value;
            }

            String next = str.replace("(" + value + ")", handle(value));
            if (next.contains("(")) {
                return getEntry(next);
            } else {
                return next;
            }
        }

        return null;
    }

    public static String handle(String str) {
        System.out.println("********" + str + "***********");
        String[] s = str.split(" ");
        String op = s[0];
        String[] num = new String[s.length - 1];
        System.arraycopy(s, 1, num, 0, s.length - 1);
        String result = calculate(op, num);
        return result;
    }

    public static String calculate(String op, String[] value) {
        String result = null;

        if (value.length == 1) {
            return String.valueOf(value[0]);
        } else if (value.length > 1) {
            int total = Integer.parseInt(value[0]);
            for (int i = 1; i < value.length; i++) {
                switch (op) {
                    case "add":
                        total += Integer.parseInt(value[i]);
                        result = String.valueOf(total);
                        break;
                    case "sub":
                        total -= Integer.parseInt(value[i]);
                        result = String.valueOf(total);
                        break;
                    case "mul":
                        total *= Integer.parseInt(value[i]);
                        result = String.valueOf(total);
                        break;
                    case "div":
                        if (Integer.parseInt(value[i]) == 0) {
                            return "error";
                        } else {
                            total /= Integer.parseInt(value[i]);
                            result = String.valueOf(total);
                        }
                        break;
                }
            }
        }

        return result;
    }
}
