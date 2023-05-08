package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/3sum/">leetcode15</a>
 */
public class LtCode15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<String> matchedResult = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int index = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                    if (index >= 0) {
                        matchedResult.add(String.join(",", Arrays.asList(String.valueOf(nums[i]), String.valueOf(nums[j]), String.valueOf(nums[index]))));
                    }
                }
            }
            return matchedResult.stream().map(s -> Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
        }
    }
}
