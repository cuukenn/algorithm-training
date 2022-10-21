package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Stack;

/**
 * @Classname Problem331
 * @Description https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * @Date 2021/3/13 14:50
 * @Created by changgg
 */
public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] split = preorder.split(",");
        for (String s : split) {
            if (!"#".equals(s)) {
                stack.push(s);
            } else {
                stack.push(s);
                while (true) {
                    String last1 = !stack.isEmpty() ? stack.pop() : null;
                    String last2 = !stack.isEmpty() ? stack.pop() : null;
                    String last3 = !stack.isEmpty() ? stack.pop() : null;
                    if (last1 == null || last2 == null || last3 == null) {
                        if (last3 != null) {
                            stack.push(last3);
                        }
                        if (last2 != null) {
                            stack.push(last2);
                        }
                        if (last1 != null) {
                            stack.push(last1);
                        }
                        break;
                    }
                    if ("#".equals(last1) && "#".equals(last2) && !"#".equals(last3)) {
                        stack.push("#");
                    } else {
                        stack.push(last3);
                        stack.push(last2);
                        stack.push(last1);
                        break;
                    }
                }
            }
        }
        return stack.size() == 1 && "#".equals(stack.pop());
    }

    public static void main(String[] args) {
        Problem331 problem331 = new Problem331();
        System.out.println(problem331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(problem331.isValidSerialization("1,#"));
        System.out.println(problem331.isValidSerialization("9,#,#,1"));
    }
}
