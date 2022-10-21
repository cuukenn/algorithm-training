package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author changgg
 * @Classname Problem150
 * @Description https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @Date 2021/3/20 20:03
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem150 {
    private final Stack<Integer> data = new Stack<>();
    private final Stack<String> options = new Stack<>();

    public int evalRPN(String[] tokens) {
        if (tokens.length <= 0) {
            return 0;
        }
        //获取中缀算术表达式、然后进行计算
        final String[] midOptions = getMidOptions(tokens).split("_+");
        return calculate(Arrays.stream(midOptions).filter(s -> !s.isEmpty()).toArray(String[]::new));
    }

    private int calculate(String[] s) {
        data.clear();
        options.clear();
        for (int index = s.length - 2; index > 0; index--) {
            final String current = s[index];
            if (")".equals(current)) {
                options.push(current);
            } else if ("(".equals(current)) {
                int num1 = data.pop();
                int num2 = data.pop();
                String opt = options.pop();
                options.pop();
                data.push(getData(num1, num2, opt));
            } else if ("+".equals(current)
                    || "-".equals(current)
                    || "*".equals(current)
                    || "/".equals(current)) {
                options.push(current);
            } else {
                data.push(Integer.parseInt(current));
            }
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
        return data.isEmpty() ? Integer.parseInt(s[0]) : data.pop();
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

    private String getMidOptions(String[] tokens) {
        final Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)
                    || "-".equals(token)
                    || "*".equals(token)
                    || "/".equals(token)) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push("_" + "(" + "_" + "_" + num1 + "_" + token + "_" + num2 + "_" + ")" + "_");
            } else {
                stack.push("_" + token + "_");
            }
        }
        final String result = stack.toString();
        return result.substring(1, result.length() - 1);
    }

    public static void main(String[] args) {
        Problem150 problem150 = new Problem150();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(problem150.evalRPN(tokens));
        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(problem150.evalRPN(tokens));
        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(problem150.evalRPN(tokens));
        tokens = new String[]{"18"};
        System.out.println(problem150.evalRPN(tokens));
        tokens = new String[]{};
        System.out.println(problem150.evalRPN(tokens));
    }
}
