package com.changgg.algorithm.leetcode.daily;

import java.util.Stack;

/**
 * @See https://leetcode-cn.com/problems/basic-calculator/
 * @Classname Problem224
 * @Description TODO
 * @Date 2021/3/10 19:12
 * @Created by changgg
 */
public class Problem224 {
    private final Stack<Integer> data = new Stack<>();
    private final Stack<String> options = new Stack<>();

    public int calculate(String s) {
        data.clear();
        options.clear();
        char[] chars = s.replaceAll("\\s+", "").toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int index = chars.length - 1; index >= 0; index--) {
            char c = chars[index];
            if (c == '(') {
                if (sb.length() > 0) {
                    data.push(Integer.parseInt(sb.reverse().toString()));
                    sb.delete(0, sb.length());
                }
                String opt = options.pop();
                while (!opt.equals(")")) {
                    data.push(getData(data.pop(), data.pop(), opt));
                    opt = options.pop();
                }
            } else if (c == ')') {
                if (sb.length() > 0) {
                    data.push(Integer.parseInt(sb.reverse().toString()));
                    sb.delete(0, sb.length());
                }
                options.push(String.valueOf(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '+' || c == '-') {
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
        } else {
            throw new IllegalArgumentException("no option found");
        }
    }

    public static void main(String[] args) {
        Problem224 problem224 = new Problem224();
        System.out.println(problem224.calculate("1 + 1"));
        System.out.println(problem224.calculate("2-1 + 2"));
        System.out.println(problem224.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(problem224.calculate("2147483647"));
        System.out.println(problem224.calculate("-2+1"));
    }
}
