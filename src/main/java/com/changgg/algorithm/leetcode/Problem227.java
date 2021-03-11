package com.changgg.algorithm.leetcode;

import java.util.Stack;

/**
 * @Classname Problem227
 * @Description see:https://leetcode-cn.com/problems/basic-calculator-ii/
 * @Date 2021/3/11 19:46
 * @Created by changgg
 */
public class Problem227 {
    private final Stack<Integer> data = new Stack<>();
    private final Stack<String> options = new Stack<>();

    public int calculate(String s) {
        data.clear();
        options.clear();
        char[] chars = s.replaceAll("\\s+", "").toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int index = chars.length - 1; index >= 0; index--) {
            char c = chars[index];
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '+' || c == '-') {
                if (sb.length() > 0) {
                    data.push(Integer.parseInt(sb.reverse().toString()));
                    sb.delete(0, sb.length());
                }
                while (data.size() >= 2 && !options.isEmpty()) {
                    int a = data.pop();
                    String opt = options.pop();
                    int b = data.pop();
                    if ("*".equals(opt) || "/".equals(opt)) {
                        data.push(getData(a, b, opt));
                    } else {
                        options.push(opt);
                        data.push(b);
                        data.push(a);
                        break;
                    }
                }
                options.push(String.valueOf(c));
            } else if (c == '*' || c == '/') {
                if (sb.length() > 0) {
                    data.push(Integer.parseInt(sb.reverse().toString()));
                    sb.delete(0, sb.length());
                }
                options.push(String.valueOf(c));
            }
        }
        if (sb.length() > 0) {
            data.push(Integer.parseInt(sb.reverse().toString()));
            sb.delete(0, sb.length());
        }
        while (!options.empty()) {
            String opt = options.pop();
            int a = data.pop();
            if (data.isEmpty()) {
                data.push(-1 * a);
            } else {
                data.push(getData(a, data.pop(), opt));
            }

        }
        return data.pop();
    }

    private int getData(int a, int b, String opt) {
        if ("+".equals(opt)) {
            return a + b;
        } else if ("-".equals(opt)) {
            return a - b;
        } else if ("*".equals(opt)) {
            return a * b;
        } else if ("/".equals(opt)) {
            return a / b;
        } else {
            throw new IllegalArgumentException("no option found");
        }
    }

    public static void main(String[] args) {
        Problem227 problem227 = new Problem227();
//        System.out.println(problem227.calculate("3+2*2"));
//        System.out.println(problem227.calculate("3/2"));
//        System.out.println(problem227.calculate("3+5 / 2"));
//        System.out.println(problem227.calculate("-1+1"));
//        System.out.println(problem227.calculate("-1"));
        System.out.println(problem227.calculate("1+2*5/3+6/4*2"));
    }
}
