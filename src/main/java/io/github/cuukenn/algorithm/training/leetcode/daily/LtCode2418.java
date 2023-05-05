package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/sort-the-people/">leetcode2418</a>
 */
public class LtCode2418 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(solution.sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})));
    }

    static class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Map<Integer, String> heightSet = new HashMap<>();
            Integer[] heightsBox = new Integer[heights.length];
            for (int i = 0; i < names.length; i++) {
                heightSet.put(heights[i], names[i]);
                heightsBox[i] = heights[i];
            }
            Arrays.sort(heightsBox);
            String[] sortedNames = new String[names.length];
            for (int j = names.length - 1; j >= 0; j--) {
                sortedNames[names.length - j - 1] = heightSet.get(heightsBox[j]);
            }
            return sortedNames;
        }
    }
}
