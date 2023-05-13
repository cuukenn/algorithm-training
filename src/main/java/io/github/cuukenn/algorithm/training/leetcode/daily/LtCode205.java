package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/isomorphic-strings">leetcode205</a>
 */
public class LtCode205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add"));
        System.out.println(solution.isIsomorphic("foo", "bar"));
        System.out.println(solution.isIsomorphic("paper", "title"));
        System.out.println(solution.isIsomorphic("badc", "baba"));
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (t.length() < s.length()) {
                return false;
            }
            Map<Character, Character> s2tcharMap = new HashMap<>(s.length());
            Map<Character, Character> t2scharMap = new HashMap<>(s.length());
            char[] sChars = s.toCharArray(), tChars = t.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                //获取上次的映射关系、存在则判断此次映射是否与之前一致
                Character tChar = s2tcharMap.putIfAbsent(sChars[i], tChars[i]);
                if (tChar != null && tChar != tChars[i]) {
                    return false;
                }
                //反向映射唯一、获取上次的映射关系、存在则判断此次映射是否与之前一致
                Character sChar = t2scharMap.putIfAbsent(tChars[i], sChars[i]);
                if (sChar != null && sChar != sChars[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
