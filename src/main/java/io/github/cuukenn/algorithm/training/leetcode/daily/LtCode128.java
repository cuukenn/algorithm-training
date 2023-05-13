package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/longest-consecutive-sequence">leetcode128</a>
 */
public class LtCode128 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //4
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        //9
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        //3
        //0 1 1 2
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Set<Integer> numSet = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                if (numSet.contains(num)) {
                    continue;
                }
                numSet.add(num);
                list.add(num);
            }
            Integer[] numsI = list.toArray(new Integer[0]);
            Arrays.sort(numsI);
            int startIndex = 0, endIndex = 1, maxCount = 1;
            while (endIndex < numsI.length && startIndex <= endIndex) {
                if (numsI[endIndex - 1] + 1 == numsI[endIndex]) {
                    maxCount = Math.max(maxCount, endIndex - startIndex + 1);
                    endIndex++;
                } else {
                    startIndex = endIndex;
                    endIndex++;
                }
            }
            return maxCount;
        }
    }
}
