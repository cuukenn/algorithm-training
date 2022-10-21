package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Vector;

/**
 * @author changgg
 * @Classname Problem1404
 * @Description https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/submissions/
 * @Date 2021/3/25 21:30
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1404 {
    public int numSteps(String s) {
        int rs = 0;
        Vector<Character> vector = new Vector<>();
        char[] chars = s.toCharArray();
        for (int index = s.length() - 1; index >= 0; index--) {
            vector.add(chars[index]);
        }
        while (vector.size() != 1) {
            if (vector.firstElement() != '0') {
                for (int index = 0; index < vector.size(); index++) {
                    if (vector.get(index) == '0') {
                        vector.remove(0);
                        vector.add(index, '1');
                        break;
                    }
                    vector.remove(index);
                    vector.add(index, '0');
                }
                if (vector.lastElement() == '0') {
                    vector.add('1');
                }
            } else {
                vector.remove(0);
            }
            rs++;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1404 problem1404 = new Problem1404();
        System.out.println(problem1404.numSteps("1101"));
        System.out.println(problem1404.numSteps("10"));
        System.out.println(problem1404.numSteps("1"));
    }
}
