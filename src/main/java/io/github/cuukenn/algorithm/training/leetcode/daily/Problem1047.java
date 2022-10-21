package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * see:https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class Problem1047 {
    public String removeDuplicates(String S) {
        int index = 0;
        int nextIndex = 0;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean has2Remove = false;
        while (index < chars.length) {
            char current = chars[index];
            while (nextIndex < chars.length && chars[nextIndex] == current) {
                nextIndex++;
            }
            if (nextIndex - index == 1 || (nextIndex - index) % 2 == 1) {
                sb.append(current);
            } else {
                has2Remove = true;
            }
            index = nextIndex;
        }
        if (has2Remove) {
            return removeDuplicates(sb.toString());
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Problem1047 problem1047 = new Problem1047();
        System.out.println(problem1047.removeDuplicates("abbaca"));
        System.out.println(problem1047.removeDuplicates("aaaaaaaaa"));
    }
}
